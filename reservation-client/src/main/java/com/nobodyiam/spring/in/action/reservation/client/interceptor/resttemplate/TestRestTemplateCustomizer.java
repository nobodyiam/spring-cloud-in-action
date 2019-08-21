package com.nobodyiam.spring.in.action.reservation.client.interceptor.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TestRestTemplateCustomizer implements RestTemplateCustomizer {
    @Autowired
    private RestTemplateInterceptor restTemplateInterceptor;
    @Autowired
    private LoadBalancerInterceptor loadBalancerInterceptor;

    @Override
    public void customize(RestTemplate restTemplate) {
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(restTemplateInterceptor);
        interceptors.add(loadBalancerInterceptor);
    }
}
