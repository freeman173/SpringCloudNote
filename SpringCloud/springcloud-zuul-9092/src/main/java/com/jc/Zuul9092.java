package com.jc;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


//启动类
@SpringBootApplication
//开启路由功能
@EnableZuulProxy
public class Zuul9092 {

    public static void main(String[] jc){
        SpringApplication.run(Zuul9092.class,jc);
    }




}
