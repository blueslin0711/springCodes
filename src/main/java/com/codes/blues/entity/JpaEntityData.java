package com.codes.blues.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/12 13:06
 * @description：
 */
@Entity
@Data
public class JpaEntityData implements Serializable {

    private static final long serialVersionUID = 3420336634407251429L;
    @Id
    @GeneratedValue
    private int pId;

    @Column(length = 20, unique = true)
    private String name;

    @Column(nullable = true)
    private String address;

    private Date saveTime;
}
