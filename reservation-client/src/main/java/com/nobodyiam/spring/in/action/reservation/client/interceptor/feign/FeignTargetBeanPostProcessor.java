package com.nobodyiam.spring.in.action.reservation.client.interceptor.feign;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;

public class FeignTargetBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LoadBalancerFeignClient) {
            return new TestLoadBalancerFeignClient((LoadBalancerFeignClient) bean);
        }
        return bean;
    }
}
