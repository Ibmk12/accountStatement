package com.example.demo.Controller;


import com.example.demo.Entity.AgentLocation;
import com.example.demo.Entity.ImageEntity;
import com.example.demo.Repository.AgentLocationRepository;
import com.example.demo.Repository.ImageRepository;
import com.example.demo.ResponseModel.AgentLocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("/img")
    public ImageEntity postImg(@RequestPart("img") MultipartFile image){

        byte[] imageInBytes = null ;
        try {
            imageInBytes = image.getBytes();
        }
        catch (Exception e){}

        ImageEntity response = new ImageEntity();
        response.setImage(imageInBytes);
//        result.setId(3);

        return imageRepository.save(response);
    }

    @GetMapping("/img/get")
    public byte[] postImg1(){

//        byte[] imageInBytes = null ;
//        try {
//            imageInBytes = image.getBytes();
//        }
//        catch (Exception e){}
//
//        ImageEntity response = new ImageEntity();
//        response.setImage(imageInBytes);
//        result.setId(3);

        return imageRepository.findById(3).getImage();
    }


    @Autowired
    AgentLocationRepository agentLocationRepository;

    @GetMapping("/location")
    AgentLocationResponse getLocation(@RequestBody List<AgentLocation> agentLocations){

        AgentLocationResponse agentLocationResponse = new AgentLocationResponse();
        agentLocationResponse.setAgentLocations(agentLocationRepository.findAllByStatus("Active"));
        return agentLocationResponse;
    }

}
