package com.atguigu.yygh.hosp;/*
@author cz
@create 2021-03-15 13:46 
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class,args);
        StringBuilder sb=new StringBuilder();
    }


}
