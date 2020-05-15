package com.test.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;




@Component
public class HystrixClientFallback implements BookmarkFeignClient {

  @Override
  public Object getBookmarkList(String userid,boolean synchronize) {
	  String message = "网络繁忙， 请稍后再试";
      return message;
  }
}