package com.jc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


//pojo映射数据库表
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Department implements Serializable {

    private int id;
    private String name;
    private String dbSource;


}
