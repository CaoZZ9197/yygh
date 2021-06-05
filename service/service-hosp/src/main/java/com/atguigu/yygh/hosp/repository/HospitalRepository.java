package com.atguigu.yygh.hosp.repository;/*
@author cz
@create 2021-04-23 19:57 
*/

import com.atguigu.yygh.model.hosp.Hospital;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository  {
    //if exist
    Hospital getHospitalByHoscode(String hoscode);
}
