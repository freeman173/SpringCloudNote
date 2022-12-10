package com.jc.controller;


import com.jc.pojo.Department;
import com.jc.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DeptService deptService;

    @Autowired
//    得到具体的微服务信息的一个工具类！
    private DiscoveryClient discoveryClient;


    @GetMapping("/dept/select/{id}")
//    熔断后，就调用熔断对应的方法
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Department selectAll(@PathVariable("id") int id){

        Department department=deptService.selectById(id);

        if(department==null){
            throw new RuntimeException("不存在该用户的信息："+id);
        }

        return department;
    }


    public Department hystrixGet(@PathVariable("id") int id){

        Department department= new Department();
        department.setId(id);
        department.setName("hystrix");
        department.setDbSource("no database in mysql!");
        return department;
    }






















    @GetMapping("/dept/disc")
    public Object discovery(){
//        获取微服务列表清单
        List<String> services=discoveryClient.getServices();
        System.out.println("微服务列表："+services);

//        得到一个具体的微服务信息
        List<ServiceInstance> serviceInstances=discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");


        return discoveryClient;

    }


}
