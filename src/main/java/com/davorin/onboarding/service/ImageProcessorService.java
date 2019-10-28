package com.davorin.onboarding.service;

import com.davorin.onboarding.model.dto.MicroblinkImageRequestDTO;
import com.davorin.onboarding.model.dto.MicroblinkImageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImageProcessorService {

    @Autowired
    RestTemplate restTemplate;

    public MicroblinkImageResponseDTO processImage(MicroblinkImageRequestDTO base64image) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "NWYwODc0N2U2ZmI1NDE1Mjk1ODM0NTE2NjI0NTc2MzU6MWY5ZGI5YmEtZTYwMi00MGE2LWE3YjItMjk4NWJlYzA3NDIx");
        headers.set("Content-Type", "application/json");

        HttpEntity<MicroblinkImageRequestDTO> request = new HttpEntity<>(base64image, headers);
        HttpEntity<MicroblinkImageResponseDTO> response = restTemplate.exchange("https://api.microblink.com/recognize/execute", HttpMethod.POST, request, MicroblinkImageResponseDTO.class);

        return response.getBody();
    }
}
