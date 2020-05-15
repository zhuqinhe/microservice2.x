package com.test.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-favorite", fallback = HystrixClientFallback.class)
public interface FavoriteFeignClient {
  @RequestMapping(value = "/v2/favorite/list", method = RequestMethod.GET)
  public Object getFavoritekList(@RequestParam("userid")String userid,@RequestParam("synchronize")boolean synchronize);
}