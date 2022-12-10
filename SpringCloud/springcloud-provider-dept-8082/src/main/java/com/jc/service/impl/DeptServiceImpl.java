package com.jc.service.impl;

import com.jc.mapper.DepartmentDao;
import com.jc.pojo.Department;
import com.jc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> selectAll() {
        return  departmentDao.selectAll();
    }

    public Department selectById(int id) {
        return departmentDao.selectById(id);
    }

}
