package com.codes.blues.dao.user.req;

import java.util.Date;

/**
 * user通用请求参数
 * @author linzg
 * @date 2020/03/02 15:25
 */
public class UserReq {

    private Integer id;

    private String username;

    private String sex;

    private Date birthday;

    private String address;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}