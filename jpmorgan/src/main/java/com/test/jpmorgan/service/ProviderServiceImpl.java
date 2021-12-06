package com.test.jpmorgan.service;

import com.test.jpmorgan.model.ProviderRequest;
import com.test.jpmorgan.model.ProviderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProviderServiceImpl implements ProviderService{
    private Logger logger = LoggerFactory.getLogger(ProviderService.class);

    @Value("${provider1.service.url}")
    private String provider1Url;

    @Value("${provider2.service.url}")
    private String provider2Url;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean isProvider1Valid(ProviderRequest request) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");

            HttpEntity<ProviderRequest> restEntity = new HttpEntity<>(request, headers);

            ProviderResponse response = restTemplate.
                    exchange(provider1Url, HttpMethod.POST, restEntity, ProviderResponse.class)
                    .getBody();

            assert response != null;
            return response.isValid();
        }catch (Exception e){
            this.logger.error("Exception while trying to contact provider1 service for request {}",request,e);
            throw e;
        }
    }

    @Override
    public boolean isProvider2Valid(ProviderRequest request) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");

            HttpEntity<ProviderRequest> restEntity = new HttpEntity<>(request, headers);

            ProviderResponse response = restTemplate.
                    exchange(provider2Url, HttpMethod.POST, restEntity, ProviderResponse.class)
                    .getBody();

            assert response != null;
            return response.isValid();
        }catch (Exception e){
            this.logger.error("Exception while trying to contact provider2 service for request {}",request,e);
            throw e;
        }
    }
}
