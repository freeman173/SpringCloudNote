package com.jc;



import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


//启动类
@SpringBootApplication
//开启服务注册功能
@EnableEurekaClient
//开启服务发现功能
@EnableDiscoveryClient
//添加熔断功能的支持
@EnableCircuitBreaker
public class DeptProvider8086 {

    public static void main(String[] jc){
        SpringApplication.run(DeptProvider8086.class,jc);
    }

    //    与dashboard相关的配置
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        return servletRegistrationBean;

    }


}
