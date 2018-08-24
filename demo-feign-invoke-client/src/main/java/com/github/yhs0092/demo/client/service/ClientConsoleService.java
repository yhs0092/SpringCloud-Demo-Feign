package com.github.yhs0092.demo.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.yhs0092.demo.client.serverintf.EntityPost;
import com.github.yhs0092.demo.client.serverintf.HelloServiceIntf;

@RestController
@RequestMapping("/client")
public class ClientConsoleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ClientConsoleService.class);

  @Autowired
  @Qualifier("helloServiceIntfTextPlain")
  private HelloServiceIntf helloServiceIntfTextPlain;

  @Autowired
  @Qualifier("helloServiceIntfJackson")
  private HelloServiceIntf helloServiceIntfJackson;

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public String getHello(@RequestParam(value = "name") String name) {
    LOGGER.info("getHello() is called, name = [{}]", name);
    String response = helloServiceIntfTextPlain.get(name);
    LOGGER.info("getHello() result = [{}]", response);
    return response;
  }

  @RequestMapping(value = "/post", method = RequestMethod.POST)
  public String post(@RequestBody EntityPost param) {
    LOGGER.info("post() is called, param = [{}]", param);
    EntityPost response = helloServiceIntfJackson.post(param);
    LOGGER.info("post() result = [{}]", response);
    return response.toString();
  }
}
