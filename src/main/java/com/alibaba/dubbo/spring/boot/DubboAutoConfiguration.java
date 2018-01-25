package com.alibaba.dubbo.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.spring.boot.endpoint.DubboEndpoint;
import com.alibaba.dubbo.spring.boot.health.DubboHealthIndicator;
import com.alibaba.dubbo.spring.boot.metrics.DubboMetrics;

/**
 * Dubbo common configuration
 *
 * @author xionghui
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAutoConfiguration {
  @Autowired
  private DubboProperties properties;

  @Bean
  @ConditionalOnMissingBean
  public ApplicationConfig dubboApplicationConfig() {
    ApplicationConfig appConfig = new ApplicationConfig();
    appConfig.setName(this.properties.getAppname());
    return appConfig;
  }

  @Bean
  @ConditionalOnMissingBean
  public ProtocolConfig dubboProtocolConfig() {
    ProtocolConfig protocolConfig = new ProtocolConfig();
    protocolConfig.setName(this.properties.getProtocol());
    protocolConfig.setHost(this.properties.getHost());
    protocolConfig.setPort(this.properties.getPort());
    protocolConfig.setThreads(this.properties.getThreads());
    return protocolConfig;
  }

  @Bean
  @ConditionalOnMissingBean
  public RegistryConfig dubboRegistryConfig() {
    RegistryConfig registryConfig = new RegistryConfig();
    registryConfig.setAddress(this.properties.getRegistry());
    registryConfig.setUsername(this.properties.getUsername());
    registryConfig.setPassword(this.properties.getPassword());
    return registryConfig;
  }

  @Bean
  public DubboHealthIndicator dubboHealthIndicator() {
    return new DubboHealthIndicator();
  }

  @Bean
  public DubboEndpoint dubboEndpoint() {
    return new DubboEndpoint();
  }

  @Bean
  public DubboMetrics dubboConsumerMetrics() {
    return new DubboMetrics();
  }
}
