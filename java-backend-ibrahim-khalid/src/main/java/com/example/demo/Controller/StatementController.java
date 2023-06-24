package com.example.demo.Controller;

import com.example.demo.DTO.AccountStatementDto;
import com.example.demo.RequestModel.AccountStatementRequestModel;
import com.example.demo.RequestModel.IpinGenerationRequestModel;
import com.example.demo.ResponseModel.AccountStatementResponseModel;
import com.example.demo.Service.AccountService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.crypto.Cipher;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

@RestController
public class StatementController {

    @Autowired
    AccountService accountService;

    @GetMapping("statements")
    public AccountStatementResponseModel getStatement(@RequestBody AccountStatementRequestModel accountStatementRequestModel) throws Exception
    {

        System.out.println(accountStatementRequestModel);
        AccountStatementDto dto = new AccountStatementDto();

        BeanUtils.copyProperties(accountStatementRequestModel, dto);

        AccountStatementDto returnedDto = accountService.getStatement1(dto);

        AccountStatementResponseModel accountStatementResponseModel = new AccountStatementResponseModel();

        BeanUtils.copyProperties(returnedDto, accountStatementResponseModel);

        return accountStatementResponseModel;
    }

    @GetMapping("/generateEncryptedIpin")
    public HashMap<String,String> getStatement(@RequestBody IpinGenerationRequestModel ipinGenerationRequestModel) {

        HashMap<String, String> hashMap = new HashMap<>();

        for(int i = 0; i < ipinGenerationRequestModel.getCounter(); i++) {
            String text = ipinGenerationRequestModel.getIpin();
            String publicKey = ipinGenerationRequestModel.getConsumerPublicKey();
            String uuid = "";
            if(ipinGenerationRequestModel.getUuid() == null || ipinGenerationRequestModel.getUuid().isEmpty())
                uuid = UUID.randomUUID().toString();
            else
                uuid = ipinGenerationRequestModel.getUuid();

            System.out.println("*********** Text ****************  " + text);
            System.out.println("*********** Pb key **************  " + publicKey);
            System.out.println("*********** UUID ****************  " + uuid);

           hashMap.put(encrypt(text, publicKey, uuid), uuid);
        }
        exportToExcel(hashMap);

        return hashMap;
    }

    private static String encrypt(String text, String publicKey, String uuid) {
        String encryptedText = text;
        String fullClearText = uuid + text;
        try {
            Base64 base64 = new Base64();
            byte[] keyByte = base64.decode(publicKey.getBytes(StandardCharsets.UTF_8));

            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyByte);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            Key pubKey = factory.generatePublic(x509EncodedKeySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            encryptedText = (new String(base64.encode(cipher.doFinal(fullClearText.getBytes()))));
        } catch (Exception e) {
//            Timber.e(e, e.getMessage());
        }
        return encryptedText;
    }

    private static void exportToExcel(HashMap<String, String> hashMap){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");

        //Setting the headers
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("IPIN");
        cell.setCellStyle(style);

        Cell cell1 = row.createCell(1);
        cell1.setCellValue("UUID");
        cell1.setCellStyle(style);
        int rowno=1;


        for(HashMap.Entry entry:hashMap.entrySet()) {
            XSSFRow xssfRow=sheet.createRow(rowno++);
            xssfRow.createCell(0).setCellValue((String)entry.getKey());
            xssfRow.createCell(1).setCellValue((String)entry.getValue());
        }

        try {
            FileOutputStream file = new FileOutputStream("D:\\Ibrahim\\Output\\Hash.xlsx");
            workbook.write(file);
            file.close();
            System.out.println("Data Copied to Excel in the following path D:\\Ibrahim\\Output\\Hash.xlsx");
        }
        catch (Exception e){System.out.println(e.getMessage());}
    }
}