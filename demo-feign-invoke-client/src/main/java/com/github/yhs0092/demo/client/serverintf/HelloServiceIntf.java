package com.github.yhs0092.demo.client.serverintf;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface HelloServiceIntf {
  @RequestLine("GET /hello/get?name={name}")
  String get(@Param(value = "name") String name);

  @Headers({"Content-Type: application/json", "Accept: application/json", "header-extra: extraHeader"})
  @RequestLine("POST /hello/post")
  EntityPost post(EntityPost param);
}
