package com.jc.controller;


import com.jc.pojo.Department;
import com.jc.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DepartmentConsumerController {

//  使用rest风格的模板来获取数据：提供了多种远程访问http服务的方法。
    @Autowired
    private RestTemplate restTemplate;

//    未集成ribbon之前使用这个
    private static final String REST_URL_PREFIX="http://localhost:8081";
    /*
        eureka与ribbon结合之后使用这个:基于微服务的名字来访问（不需要关心这个服务来自哪个端口），
     ribbon自动帮你找服务地址！

     */
    private static final String REST_URL_PREFIX_Two="http://SPRINGCLOUD-PROVIDER-DEPT";





    @GetMapping("/consumer/department/get")
    public List<Department> get(){
        return restTemplate.getForObject(REST_URL_PREFIX_Two+"/dept/select", List.class);
//        return deptClientService.selectAll();
    }


    @GetMapping("/consumer/department/get/{id}")
    public Department get(@PathVariable("id") int id){


//把请求拼接好即可，不需要记忆啥知识点，调试反馈就行了！
        return restTemplate.getForObject(REST_URL_PREFIX_Two+"/dept/select/"+id,Department.class);
//        return deptClientService.selectById(id);

    }









}
