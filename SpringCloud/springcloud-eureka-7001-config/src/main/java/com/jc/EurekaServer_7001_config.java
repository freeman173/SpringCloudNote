package com.jc;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//启动类
@SpringBootApplication
//开启Eureka服务类的功能
@EnableEurekaServer
public class EurekaServer_7001_config {

    public static void main(String[] jc){
        SpringApplication.run(EurekaServer_7001_config.class,jc);
    }




}
