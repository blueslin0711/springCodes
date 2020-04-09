package com.codes.blues.service.tdemo.impl;

import com.codes.blues.dao.tdemo.TdemoMapper;
import com.codes.blues.dao.tdemo.model.Tdemo;
import com.codes.blues.service.tdemo.TdemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/3 14:18
 * @description：tdemoService服务实现
 */
@Service
public class TdemoServiceImpl implements TdemoService {

    @Autowired
    TdemoMapper tdemoMapper;

    @Override
    public Tdemo findOne(Integer id) {
        Tdemo data = tdemoMapper.selectByPrimaryKey(id);
        return data;
    }

    @Override
    public List<Tdemo> findAllById(Integer id) {
        return tdemoMapper.selectAll(id);
    }
}
