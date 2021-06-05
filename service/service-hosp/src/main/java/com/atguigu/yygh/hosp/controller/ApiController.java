package com.atguigu.yygh.hosp.controller;/*
@author cz
@create 2021-04-23 20:00 
*/


import com.atguigu.yygh.common.helper.HttpRequestHelper;
import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.hosp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/hosp")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;

    //上传医院接口
    @PostMapping("savehospital")
    public Result saveHosp(HttpServletRequest request){
        //获取信息
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> requestMap = HttpRequestHelper.switchMap(parameterMap);
        hospitalService.save(requestMap);
        return Result.ok();

    }
}
