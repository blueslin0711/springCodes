package com.codes.blues.repository;

import com.codes.blues.BaseTest;
import com.codes.blues.entity.JpaInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class JpaInfoRepositoryTest extends BaseTest {

    @Autowired
    private JpaInfoRepository jpaInfoRepository;

    @Test
    public void saveTest() {
        JpaInfo jpaInfo = new JpaInfo();
        jpaInfo.setAge(10);
        jpaInfo.setName("小白");
        jpaInfo.setBirthDay(new Date());
        jpaInfo.setSex("男");
        JpaInfo saveData = jpaInfoRepository.save(jpaInfo);
        System.out.println(saveData);
    }

    @Test
    public void findAll() {
        List<JpaInfo> list = jpaInfoRepository.findAll();
        list.forEach(System.out::println);
    }
}