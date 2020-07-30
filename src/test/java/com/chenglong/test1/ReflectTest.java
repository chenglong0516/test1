package com.chenglong.test1;

import org.springframework.boot.test.context.SpringBootTest;
/*
反射学习
 */
public class ReflectTest {

    public static void main(String[] args) {
        Test1();
    }
    /*
    获取字节码对象class
     */
    public static void Test1(){
        Person person = new Person();
        Class personClass = person.getClass();
        System.out.println("通过getClass获取class对象：" + personClass);
    }
}
