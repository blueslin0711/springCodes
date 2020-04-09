package com.codes.blues.service.user;

import com.codes.blues.dao.user.model.User;
import com.codes.blues.dao.user.req.UserReq;

import java.util.List;

/**
 * user业务接口定义
 * @author linzg
 * @date 2020/03/02 15:25
 */
public interface UserService {

    /**
     * 根据ID查询
     * @author linzg
     * @date 2020/03/02 15:25
     */
    User findById(Integer id);

    /**
     * 根据ID集查询
     * @author linzg
     * @date 2020/03/02 15:25
     */
    List<User> findByIds(List<Integer> ids);

    /**
     * 创建
     * @author linzg
     * @date 2020/03/02 15:25
     */
    Integer create(UserReq req);

    /**
     * 根据ID删除
     * @author linzg
     * @date 2020/03/02 15:25
     */
    void deleteById(Integer id);

    /**
     * 根据ID集删除
     * @author linzg
     * @date 2020/03/02 15:25
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID更新
     * @author linzg
     * @date 2020/03/02 15:25
     */
    void updateById(UserReq req);

}