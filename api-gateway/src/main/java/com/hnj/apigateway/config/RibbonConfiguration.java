package com.hnj.apigateway.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {
    @Bean
    public IPing ribbonPing(final IClientConfig config) {
        return new PingUrl(false,"/health");
    }

    @Bean
    public IRule ribbonRule(final IClientConfig config) {
        return new AvailabilityFilteringRule();
    }

}
