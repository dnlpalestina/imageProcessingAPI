package com.palestina.imageProcessingAPI.controllers;

import com.palestina.imageProcessingAPI.models.entities.Image;
import com.palestina.imageProcessingAPI.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/images")
    public Iterable<Image> getAllImages() {
        return imageService.findAll();
    }

    @PostMapping("/images")
    public Image createNewImage(@RequestBody Image image) {
        Image newImage = imageService.save(image);
        return newImage;
    }


}
