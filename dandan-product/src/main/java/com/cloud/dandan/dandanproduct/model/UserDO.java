package com.cloud.dandan.dandanproduct.model;

public class UserDO {
    private String name;
    private Integer age;

    public UserDO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserDO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
