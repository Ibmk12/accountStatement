package com.example.demo.Shared;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunction {

    public static String Hash(String AccountNumber){
        String generatedPassword = "";
        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = null;
            try
            {
                md = MessageDigest.getInstance("MD5");
            }
            catch (NoSuchAlgorithmException e1)
            {
            }

            // Add password bytes to digest
            md.update(AccountNumber.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}