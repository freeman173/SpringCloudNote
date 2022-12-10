package com.jc.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


//将resttemplate注入进来
//@Configuration
//public class ConfigBean {
//
//
//    @Bean
//    @LoadBalanced//加入一个ribbon的LB功能
//    public RestTemplate getRestTemplete(){
//        return new RestTemplate();
//    }
//
//}
