package com.codes.blues.service.tdemo;

import com.codes.blues.dao.tdemo.model.Tdemo;

import java.util.List;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/3 14:12
 * @description：tdemo服务
 */
public interface TdemoService {

    Tdemo findOne(Integer id);

    List<Tdemo> findAllById(Integer id);

}
