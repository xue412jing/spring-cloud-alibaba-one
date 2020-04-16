package com.york.nacos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
	@Value("${server.port}")
	private String dossierPath;
	@GetMapping("/echo/{string}")
    public String echo( @PathVariable String string) {
        return dossierPath+"Hello Nacos Discovery " + string;
    }
//	@GetMapping("/echo/{string}")
//    public String echo(HttpServletRequest request, @PathVariable String string) {
//        return request.getServerPort()+"Hello Nacos Discovery " + string;
//    }
}
