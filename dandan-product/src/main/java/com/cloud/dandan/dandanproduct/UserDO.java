package com.cloud.dandan.dandanproduct;

import lombok.Data;

@Data
public class UserDO {
    private String name;
    private Integer age;

    public UserDO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserDO() {
    }
}
