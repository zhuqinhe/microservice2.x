/**
 * 
 */
package com.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.feign.BookmarkFeignClient;

/**
 * @Description 
 * @author hoob
 * @date 2018年11月12日下午1:39:06
 */
@RestController
@RequestMapping("/")
public class BookmarkConsumerController {

	@Resource
	private BookmarkFeignClient bookmarkFeignClient;
    @RequestMapping(value = "/v2/bookmark/list", method = RequestMethod.GET)
	public Object  getUserBookmark(@RequestParam("userid")String userid) {
		
		   return  bookmarkFeignClient.getBookmarkList(userid, false);
			 
		}
}
