package com.york.nacos.consumer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
//import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.york.nacos.service.IProvice;

@RestController
public class TestController {

	@Resource
    private RestTemplate restTemplate;
	@Resource
	private IProvice provice;
    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://nacos-provider/echo/" + str, String.class);
    }
    @GetMapping("/echo2/{str}")
    public String echo2(@PathVariable String str) {
        return provice.echo(str);
    }
    @GetMapping(value = "/getPhone")
    @SentinelResource(value = "getPhone",blockHandler = "exceptionHandler", fallback = "fallback")
    public String hello() {
        return "Hello Sentinel";
    }
    // 降级处理
    public String fallback(Integer id) {
        return "服务降级,id="+id ;
    }
    // 异常处理
    public String exceptionHandler(Integer id,BlockException be) {
        be.printStackTrace();
        return "服务抛异常,id="+id ;
    }
}
