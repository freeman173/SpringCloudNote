package com.jc.service;

import com.jc.pojo.Department;

import java.util.List;

public interface DeptService {

    public List<Department> selectAll();
    public Department selectById(int id);

}
