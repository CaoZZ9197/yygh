package com.atguigu.yygh.cmn.service;/*
@author cz
@create 2021-03-15 14:28 
*/

import com.atguigu.yygh.cmn.Dict;
import com.atguigu.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface DictService extends IService<Dict> {

    List<Dict> findChildData(Long id);

}
