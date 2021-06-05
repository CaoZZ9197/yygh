package com.atguigu.yygh.cmn.controller;/*
@author cz
@create 2021-04-19 22:13 
*/

import com.atguigu.yygh.cmn.Dict;
import com.atguigu.yygh.cmn.service.DictService;
import com.atguigu.yygh.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "数据字典接口")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;

    //查询子数据
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id){
        List<Dict> list =  dictService.findChildData(id);
        return Result.ok(list);
    }
}
