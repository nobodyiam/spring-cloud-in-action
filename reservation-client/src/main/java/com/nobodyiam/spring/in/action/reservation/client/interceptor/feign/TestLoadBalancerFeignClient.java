package com.nobodyiam.spring.in.action.reservation.client.interceptor.feign;

import com.google.common.collect.Lists;
import feign.Client;
import feign.Request;
import feign.Response;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestLoadBalancerFeignClient extends LoadBalancerFeignClient {
    private LoadBalancerFeignClient delegate;

    public TestLoadBalancerFeignClient(LoadBalancerFeignClient delegate) {
        super(null, null, null);
        this.delegate = delegate;
    }

    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        return delegate.execute(request, options);
    }

    @Override
    public Client getDelegate() {
        return new TestClient(delegate.getDelegate());
    }

    private static class TestClient implements Client {
        private static final String PATTERN_STRING = "sofa:(.*)@";
        private static final Pattern pattern = Pattern.compile(PATTERN_STRING);
        private final Client delegate;

        public TestClient(Client delegate) {
            this.delegate = delegate;
        }

        @Override
        public Response execute(Request request, Request.Options options) throws IOException {
            String url = request.url();
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                String appName = matcher.group(1);
                request.headers().put("X-SERVICE-APP-NAME", Lists.newArrayList(appName));
            }
            return delegate.execute(request, options);
        }

    }

}
