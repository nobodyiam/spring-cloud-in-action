package com.nobodyiam.spring.in.action.reservation.client.interceptor.feign;

import feign.Client;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnClass(value = {LoadBalancerFeignClient.class, Client.class})
@Configuration
public class FeignTargetAutoConfiguration {
    @Bean
    public BeanPostProcessor feignTargetBeanPostProcessor() {
        return new FeignTargetBeanPostProcessor();
    }
}
