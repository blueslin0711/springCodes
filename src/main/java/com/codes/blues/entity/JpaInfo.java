package com.codes.blues.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/11 16:44
 * @description：jpa测试对象
 */
@Entity
@Data
public class JpaInfo implements Serializable {

    private static final long serialVersionUID = -2967001539474301158L;
    @Id
    @GenericGenerator(name = "jpaInfo-uuid", strategy = "uuid")
    @GeneratedValue(generator = "jpaInfo-uuid")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;

    private Date birthDay;

    private int age;
}
