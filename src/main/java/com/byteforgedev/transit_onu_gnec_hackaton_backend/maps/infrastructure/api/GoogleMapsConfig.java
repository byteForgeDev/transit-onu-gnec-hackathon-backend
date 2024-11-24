package com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.infrastructure.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GoogleMapsConfig {
    
        @Value("${GOOGLE_MAPS_KEY}")
        private String apiKey;
    
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    
        public String getBaseUrl() {
            return "https://maps.googleapis.com/maps/api/geocode/json";
        }
    
        public String getApiKey() {
            return apiKey;
        }
}
