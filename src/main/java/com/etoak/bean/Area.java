package com.etoak.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 地区表对应的实体类
 */
@Data
public class Area implements Serializable {
    //主键
    private Integer id;
    private Integer pid;
    private String name;
    private Integer sort;
}
