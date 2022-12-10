package com.jc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;


//启动类
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.jc"})
public class DeptConsumerFeing8084 {

    public static void main(String[] jc){
        SpringApplication.run(DeptConsumerFeing8084.class,jc);
    }

}
