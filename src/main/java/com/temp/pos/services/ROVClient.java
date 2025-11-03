package com.temp.pos.services;

import org.springframework.web.client.RestTemplate;

public class ROVClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8080/api/rov"; // Configure as needed

    // Empty controller, no methods yet
}