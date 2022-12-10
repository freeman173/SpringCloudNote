package com.jc.mapper;


import com.jc.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentDao {

    public List<Department> selectAll();

//    @Param注解指定key，然后使用该key
    public Department selectById(@Param("id") int id);


}
