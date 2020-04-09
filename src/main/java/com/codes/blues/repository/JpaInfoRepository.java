package com.codes.blues.repository;

import com.codes.blues.entity.JpaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/11 16:53
 * @description：
 */
public interface JpaInfoRepository extends JpaRepository<JpaInfo, String> {

    public List<JpaInfo> findAll();

    public JpaInfo save(JpaInfo jpaInfo);

}
