package com.jc;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


//启动类
@SpringBootApplication
//开启监控功能
@EnableHystrixDashboard
public class DashBoard9001 {

    public static void main(String[] jc){
        SpringApplication.run(DashBoard9001.class,jc);
    }




}
