package com.temp.pos.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.temp.pos.models.longterm.*;
import com.temp.pos.utils.WebApiConstants;
import com.temp.pos.views.CustomerSearchDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class CommonClient {
    
    private final RestTemplate restTemplate = new RestTemplate();
    HttpHeaders hdr = new HttpHeaders();
    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(java.time.Duration.ofSeconds(10))
            .build();;
    private final ObjectMapper mapper = new ObjectMapper();


    private static final Logger logger = LoggerFactory.getLogger(CommonClient.class);
    
    public CommonClient() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        hdr.setContentType(MediaType.APPLICATION_JSON);
        hdr.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

        restTemplate.setMessageConverters(messageConverters);
    }

    public LTCVendorLocationsResultModel getVendorLocations(String exchNum, String vid, String uid, int cliTimeVar) {
        String url = WebApiConstants.baseUrl + "/common" + "/GetVendorLocations?guid=" + WebApiConstants.getGuid + "&vid=" + vid + "&uid=" + uid + "&CliTimeVar=" + cliTimeVar;
        return restTemplate.getForObject(url, LTCVendorLocationsResultModel.class);
    }

    // public VendorLoginResultsModel valPin(VLogonModel model) {
    //     HttpEntity<String> requestEntity = new HttpEntity<>(model.toString(), hdr);

    //     //HttpEntity<String> request = new HttpEntity<String>(model.toString(), hdr);
    //     //restTemplate.
    //     ResponseEntity<VendorLoginResultsModel> resp =  restTemplate.postForEntity(baseUrl + "/ValPin", requestEntity, VendorLoginResultsModel.class );
        
    //     return resp.getBody();
    // }
    
    public VendorLoginResultsModel valPin(VLogonModel vLogonModel) {
        // Construct the full URL
        String url = WebApiConstants.baseUrl + "/common" + "/ValPin";
        VendorLoginResultsModel retVal = null;

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request entity
        HttpEntity<VLogonModel> request = new HttpEntity<>(vLogonModel, headers);

        // Make HTTPS POST request
        ResponseEntity<VendorLoginResultsModel> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                VendorLoginResultsModel.class
        );

        retVal = response.getBody();
        
        System.out.println( response.getStatusCode());
        System.out.println( retVal.getResults().getReturnMsg());
        return retVal;
    }

//    public LTCCustomerLookupResultsModel getCustomerLookup(String first, String last, String phone) {
//
//        String url = WebApiConstants.baseUrl + "common" + "/GetCustomerLookup?guid=" + WebApiConstants.getGuid + "&uid=" + "0" + "&pFirst=" + first + "&pLast=" + last + "&pPhone=" + phone + "&DBVal=0";
//        logger.info("Searching customer: " + url);
//        return restTemplate.getForObject(url, LTCCustomerLookupResultsModel.class);
//    }
    public List<LTCCustomer> getCustomerLookup(String firstName, String lastName, String phone) throws Exception {
        // Build URL with encoded parameters
        String url = WebApiConstants.baseUrl + "common" + "/GetCustomerLookup?guid=" + WebApiConstants.getGuid + "&uid=" + "0" + "&pFirst=" + firstName + "&pLast=" + lastName + "&pPhone=" + phone + "&DBVal=0";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .timeout(java.time.Duration.ofSeconds(30))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // HTTP error
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new RuntimeException("HTTP " + response.statusCode() + ": " + response.body());
        }
        try {
        // Parse JSON into your model
        LTCCustomerLookupResultsModel resultModel = mapper.readValue(response.body(), LTCCustomerLookupResultsModel.class);

        // API-level error (success = false)
        if (resultModel.getResults() != null && !resultModel.getResults().isSuccess()) {
            String msg = resultModel.getResults().getReturnMsg();
            throw new RuntimeException("API Error: " + (msg != null && !msg.isBlank() ? msg : "Unknown error"));
        }

        // Return customers – safe empty list if null
        List<LTCCustomer> customers = resultModel.getCustomers();
        return customers != null ? customers : Collections.emptyList();
    } catch (Exception e) {
        logger.error("JSON Parsing failed: " + e.getMessage(), e);
        e.printStackTrace();
        throw new RuntimeException("Failed to parse customer data: " + e.getMessage(), e);
    }
    }
    public TenderTypeResultsModel getTenderTypes(String uid, int appType) {
        String url = WebApiConstants.baseUrl + "common" + "/GetTenderTypes?guid=" + WebApiConstants.getGuid + "&uid=" + uid + "&AppType=" + appType;
        return restTemplate.getForObject(url, TenderTypeResultsModel.class);
    }
}