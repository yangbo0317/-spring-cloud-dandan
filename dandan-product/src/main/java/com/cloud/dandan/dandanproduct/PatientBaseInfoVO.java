package com.cloud.dandan.dandanproduct;

import lombok.Data;

@Data
public class PatientBaseInfoVO {
    /**
     *  姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 年龄
     */
    private String age;
    /**
     * 证件类型
     */
    private Integer idType;
    /**
     * 证件号
     */
    private String idNum;
    /**
     * 省份编码
     */
    private String provinceCode;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市区编码
     */
    private String cityCode;
    /**
     * 市区名称
     */
    private String cityName;
    /**
     * 区编码
     */
    private String areaCode;
    /**
     * 区名称
     */
    private String areaName;
    /**
     * 街道便秘吗
     */
    private String streetCode;
    /**
     * 街道名称
     */
    private String streetName;
    /**
     * 门牌号
     */
    private String roomNum;
}
