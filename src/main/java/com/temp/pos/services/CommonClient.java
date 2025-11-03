package com.temp.pos.services;

import com.temp.pos.models.longterm.LTCCustomerLookupResultsModel;
import com.temp.pos.models.longterm.LTCVendorLocationsResultModel;
import com.temp.pos.models.longterm.TenderTypeResultsModel;
import com.temp.pos.models.longterm.VLogonModel;
import com.temp.pos.models.longterm.VendorLoginResultsModel;
import com.temp.pos.utils.WebApiConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class CommonClient {
    
    private final RestTemplate restTemplate = new RestTemplate();
    HttpHeaders hdr = new HttpHeaders();
    
    public CommonClient() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        hdr.setContentType(MediaType.APPLICATION_JSON);
        hdr.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

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

    public LTCCustomerLookupResultsModel getCustomerLookup(String guid, String uid, String first, String last, String phone, int dbVal) {
        String url = WebApiConstants.baseUrl + "/common" + "/GetCustomerLookup?guid=" + guid + "&uid=" + uid + "&pFirst=" + first + "&pLast=" + last + "&pPhone=" + phone + "&DBVal=" + dbVal;
        return restTemplate.getForObject(url, LTCCustomerLookupResultsModel.class);
    }

    public TenderTypeResultsModel getTenderTypes(String guid, String uid, int appType) {
        String url = WebApiConstants.baseUrl + "/common" + "/GetTenderTypes?guid=" + guid + "&uid=" + uid + "&AppType=" + appType;
        return restTemplate.getForObject(url, TenderTypeResultsModel.class);
    }
}