package com.jc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//启动类
@SpringBootApplication
@EnableConfigServer
public class ConfigServer9303 {

    public static void main(String[] jc){
        SpringApplication.run(ConfigServer9303.class,jc);
    }




}
