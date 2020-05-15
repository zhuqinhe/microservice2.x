package com.test.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-bookmark", fallback = HystrixClientFallback.class)
public interface BookmarkFeignClient {
  @RequestMapping(value = "/v2/bookmark/list", method = RequestMethod.GET)
  public Object getBookmarkList(@RequestParam("userid")String userid,@RequestParam("synchronize")boolean synchronize);
}