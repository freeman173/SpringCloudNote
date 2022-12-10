package com.jc.service;


import com.jc.pojo.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//服务降级时，调用这个类
@Component
public class DepartmentClientServiceFallbackFactory implements FallbackFactory {


    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {

            public List<Department> selectAll() {
                return null;
            }

            public Department selectById(int id) {
                return new Department()
                        .setId(id)
                        .setName("降级服务开启")
                        .setDbSource("no data");
            }
        };
    }
}
