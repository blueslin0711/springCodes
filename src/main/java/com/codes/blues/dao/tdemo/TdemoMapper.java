package com.codes.blues.dao.tdemo;

import com.codes.blues.dao.tdemo.model.Tdemo;
import com.codes.blues.dao.tdemo.model.TdemoWrapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TdemoMapper {
    int countByExample(TdemoWrapper example);

    int deleteByExample(TdemoWrapper example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tdemo record);

    int insertSelective(Tdemo record);

    List<Tdemo> selectByExample(TdemoWrapper example);

    Tdemo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tdemo record, @Param("example") TdemoWrapper example);

    int updateByExample(@Param("record") Tdemo record, @Param("example") TdemoWrapper example);

    int updateByPrimaryKeySelective(Tdemo record);

    int updateByPrimaryKey(Tdemo record);

    List<Tdemo> selectAll(Integer id);
}