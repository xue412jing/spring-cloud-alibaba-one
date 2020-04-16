package com.york.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nacos-provider")
public interface IProvice {
//	 @RequestMapping(value = "/query2", method = RequestMethod.GET)
//	  ResponseEntity<Object> query(@RequestParam("offset") int offset, @RequestParam("limit") int limit);
	 
	 @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
	 String echo(@RequestParam("string") String str);
}
