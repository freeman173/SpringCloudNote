package com.jc;



import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


//启动类
@SpringBootApplication
//开启服务注册功能
@EnableEurekaClient
//开启服务发现功能
@EnableDiscoveryClient
public class DeptProvider8081 {

    public static void main(String[] jc){
        SpringApplication.run(DeptProvider8081.class,jc);
    }




}
