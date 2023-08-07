package com.subproblem.user.config;

import com.subproblem.user.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@RequiredArgsConstructor
@Configuration
public class WebClientConfig {

    private final LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient productWebClient() {
        return WebClient.builder()
                .baseUrl("http://PRODUCTS")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public ProductClient productClient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                        .builder(WebClientAdapter.forClient(productWebClient()))
                        .build();
        return httpServiceProxyFactory.createClient(ProductClient.class);
    }
}
