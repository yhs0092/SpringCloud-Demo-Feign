package com.github.yhs0092.demo.server.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloService {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public String get(@RequestParam(value = "name", defaultValue = "defaultName") String name) {
    LOGGER.info("get() is called, name = [{}]", name);
    return "Hello, " + name;
  }

  @RequestMapping(value = "/post", method = RequestMethod.POST)
  public EntityPost post(@RequestBody EntityPost param, HttpServletRequest request) {
    LOGGER.info("post() is called, param = [{}]", param);
    printAllHeaders(request);
    return param;
  }

  private void printAllHeaders(HttpServletRequest request) {
    LOGGER.info("----- headers -----");
    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      LOGGER.info("HEADER: [{}] : [{}]", headerName, request.getHeader(headerName));
    }
    LOGGER.info("----- headers -----");
  }
}
