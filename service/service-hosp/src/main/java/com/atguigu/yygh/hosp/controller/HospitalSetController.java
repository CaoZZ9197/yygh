package com.atguigu.yygh.hosp.controller;/*
@author cz
@create 2021-03-15 14:33 
*/

import com.atguigu.yygh.common.exception.YyghException;
import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.common.utils.MD5;
import com.atguigu.yygh.hosp.service.HospitalSetService;
import com.atguigu.yygh.model.hosp.HospitalSet;
import com.atguigu.yygh.vo.hosp.HospitalSetQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    //注入服务
    @Autowired
    private HospitalSetService hospitalSetService;

    @GetMapping("findAll")
    public Result<List<HospitalSet>> findAllHospitalSet(){
        List<HospitalSet> list = hospitalSetService.list(); //这里可以选择直接return 但是不便于调试查看等，因此分步骤返回。
        return Result.ok(list);
    }

    @DeleteMapping("{id}")
    public Result removeHospSet(@PathVariable Long id){
        boolean flag = hospitalSetService.removeById(id);
        if (flag)
            return Result.ok();
        else
            return Result.fail();
    }

    //条件查询分页
    @PostMapping("findPage/{current}/{limit}")
    public Result<Page<HospitalSet>> findPageHospSet(@PathVariable long current, //当前页
                                  @PathVariable long limit, //显示数量
                                  @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo){ //使用json格式传数据，false表示可以为空
        //创建page对象
        Page<HospitalSet> page =new Page<>(current,limit);

        //构建条件
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        String hosname = hospitalSetQueryVo.getHosname();
        String hoscode = hospitalSetQueryVo.getHoscode();
        if (!StringUtils.isEmpty(hosname)){
            wrapper.like("hosname",hospitalSetQueryVo.getHosname());
        }
        if (!StringUtils.isEmpty(hoscode)){
            wrapper.eq("hoscode", hospitalSetQueryVo.getHoscode());
        }

        Page<HospitalSet> hospitalSetPage = hospitalSetService.page(page,wrapper);
        return Result.ok(hospitalSetPage);
    }

    //添加医院设置
    @PostMapping("saveHospitalSet")
    public Result saveHospitalSet(@RequestBody HospitalSet hospitalSet){
        //设置 状态1 使用 0不能使用
        hospitalSet.setStatus(1);
        //签名密钥
        Random random = new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis()+""+random.nextInt(1000)));

        boolean save = hospitalSetService.save(hospitalSet);
        if (save)
            return Result.ok();
        else
            return Result.fail();
    }


    //根据ID获取医院设置
    @GetMapping("getHospitalSet/{id}")
    public Result<HospitalSet> getHospitalSet(@PathVariable Long id){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }

    //修改医院设置
    @PostMapping("updateHospitalSet")
    public Result updateHospitalSet(@RequestBody HospitalSet hospitalSet){
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if (flag)
            return Result.ok();
        else
            return Result.fail();
    }

    //批量删除医院接口
    @DeleteMapping("batchRemove")
    public Result batchRemoveHospitalSet(@RequestBody List<Long> ids){
        boolean flag = hospitalSetService.removeByIds(ids);
        if (flag)
            return Result.ok();
        else
            return Result.fail();
    }

    //医院设置锁定和解锁
    @PutMapping("lockHospitalSet/{id}/{status}")
    public  Result lockHospitalSet(@PathVariable Long id,
                                   @PathVariable Integer status){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        hospitalSet.setStatus(status);
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if (flag)
            return Result.ok();
        else
            return Result.fail();
    }

    //发送签名密钥
    @PutMapping("sendKey/{id}")
    public  Result sendKey(@PathVariable Long id){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        //
        return Result.ok();
    }


}
