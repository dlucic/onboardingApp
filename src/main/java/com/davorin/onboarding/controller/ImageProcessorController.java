package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.dto.MicroblinkImageRequestDTO;
import com.davorin.onboarding.model.dto.MicroblinkImageResponseDTO;
import com.davorin.onboarding.service.ImageProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
public class ImageProcessorController {

    ImageProcessorService imageProcessorService;

    @Autowired
    public ImageProcessorController(ImageProcessorService imageProcessorService) {
        this.imageProcessorService = imageProcessorService;
    }

    @PostMapping(value = "/process", consumes = "application/json")
    @ResponseBody
    public MicroblinkImageResponseDTO processImage(@RequestBody MicroblinkImageRequestDTO image) {
        return imageProcessorService.processImage(image);
    }

}
