package com.atguigu.yygh.cmn;/*
@author cz
@create 2021-04-19 22:02 
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.atguigu"})
public class ServoceCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServoceCmnApplication.class,args);
    }
}
