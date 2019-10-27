//package com.davorin.onboarding.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//
//@Component
//public class RestClient {
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    public HttpHeaders getRequestHeaderBearer() {
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add(HeaderParameters.AUTHORIZATION, HeaderParameters.BEARER +
//                TokenGeneration.token);
//
//        return headers;
//
//    }
//
//    public HttpHeaders getRequestHeader() {
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        return headers;
//
//    }
//
//    public <T> ResponseEntity<T> restExchangeBearer(String url, HttpMethod httpMethod,
//                                                    Class<T> classObj) {
//
//        return restTemplate.exchange(url, httpMethod,
//                new HttpEntity<>("parameters", this.getRequestHeaderBearer()), classObj);
//
//    }
