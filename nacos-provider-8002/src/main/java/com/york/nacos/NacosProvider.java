package com.york.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@MapperScan("com.york.**.mapper")
public class NacosProvider {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider.class,args);
    }
}
