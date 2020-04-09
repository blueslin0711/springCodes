package com.codes.blues.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SelectEntity implements Serializable {

    private static final long serialVersionUID = -5349554267665791737L;

    public SelectEntity(String id, String name, String address, int pId, Date saveTime) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.pId = pId;
        this.saveTime = saveTime;
    }

    private String id;
    private String name;
    private String address;
    private int pId;
    private Date saveTime;
}
