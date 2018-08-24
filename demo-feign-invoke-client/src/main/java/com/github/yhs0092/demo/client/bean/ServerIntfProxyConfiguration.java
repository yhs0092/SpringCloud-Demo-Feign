package com.github.yhs0092.demo.client.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.yhs0092.demo.client.serverintf.HelloServiceIntf;

import feign.Feign;
import feign.Request.Options;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class ServerIntfProxyConfiguration {

  /**
   * Instantiate feign invocation proxy.
   * For text/plain response.
   */
  @Bean(name = "helloServiceIntfTextPlain")
  public HelloServiceIntf helloServiceIntfTextPlain() {
    return Feign.builder()
        .options(new Options(30000, 30000))
        .target(HelloServiceIntf.class, "http://127.0.0.1:8080");
  }

  /**
   * Instantiate feign invocation proxy.
   * For application/json response.
   */
  @Bean(name = "helloServiceIntfJackson")
  public HelloServiceIntf helloServiceIntfJackson() {
    return Feign.builder()
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder())
        .options(new Options(30000, 30000))
        .target(HelloServiceIntf.class, "http://127.0.0.1:8080");
  }
}
