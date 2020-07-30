package com.chenglong.test1;

import java.util.Objects;

public class Person {
    //私有属性
    private String name;
    //公有属性
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        super();
    }

    //私有方法
    private void method1(){
        System.err.println("method1——run");
    }
    //公有方法
    public void method2(String param){
        System.err.println("method1=2——run ："+param);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Proson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
