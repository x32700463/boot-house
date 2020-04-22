package com.etoak.bean;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class House {
    private Integer id ;
    @NotNull(message = "省份必填")
    private Integer province;
    @NotNull(message="市必填")
    private Integer city;
    @NotNull(message = "区县必填")
    private Integer area;
    //所在区县名称
    private String areaName;
    //租赁方式
    @NotNull(message = "租赁方式必填")
    @NotBlank(message = "租赁方式不能为空")
    private String rentMode;
    //朝向
    private String orientation;
    private String houseType;
    @NotNull(message = "租金必填")
    @Max(value = 100000,message = "租金不能超过10万")
    @Min(value = 100,message = "租金不能少于100")
    private Integer rental;
    @NotNull(message = "地址不能为空")
    @NotBlank
    private String address;
    private String pic;
    private String publishTime;
}
