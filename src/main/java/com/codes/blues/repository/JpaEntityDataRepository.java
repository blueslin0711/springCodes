package com.codes.blues.repository;

import com.codes.blues.entity.JpaEntityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaEntityDataRepository extends JpaRepository<JpaEntityData, Integer> {

    JpaEntityData save(JpaEntityData jpaEntityData);

    List<JpaEntityData> findAll();

    void deleteById(Integer integer);

    JpaEntityData findByName(String name);

    @Query(value = "SELECT ji.id, ji.name, jed.address, jed.p_id, jed.save_time FROM jpa_info ji INNER JOIN jpa_entity_data jed ON jed. NAME = ji. NAME WHERE ji.name = :name", nativeQuery = true)
    List<Object[]> selectEntityData(@Param("name") String name);

}
