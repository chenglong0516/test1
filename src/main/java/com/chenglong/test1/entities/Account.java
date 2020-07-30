package com.chenglong.test1.entities;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
/*
@NotNull 对象非空
@NotBlank 字符串非空
@NotEmpty 集合非空
 */

public class Account implements Serializable {
    @NotNull
    private Integer id;

//    @NotBlank(message = "name不能为空啊")
    @NotBlank(message = "{name.notnull}") //取自validationMessages.properties
    private String name;

    @NotNull
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}