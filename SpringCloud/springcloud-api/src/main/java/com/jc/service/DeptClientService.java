package com.jc.service;

import com.jc.pojo.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
//feign的相关注解
@FeignClient(value ="SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DepartmentClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/select")
    public List<Department> selectAll();

    @GetMapping("/dept/select/{id}")
    public Department selectById(@PathVariable("id") int id);
}
