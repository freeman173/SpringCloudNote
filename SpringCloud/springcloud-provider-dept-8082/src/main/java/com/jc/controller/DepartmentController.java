package com.jc.controller;


import com.jc.pojo.Department;
import com.jc.service.DeptService;
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


    @GetMapping("/dept/select")
    public List<Department> selectAll(){

        return deptService.selectAll();
    }

    @GetMapping("/dept/select/{id}")
    public Department selectAll(@PathVariable("id") int id){

        return deptService.selectById(id);
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
