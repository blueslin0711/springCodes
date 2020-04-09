package com.codes.blues.api.user;

import com.codes.blues.api.BaseController;
import com.codes.blues.core.model.R;
import com.codes.blues.dao.user.model.User;
import com.codes.blues.dao.user.req.UserReq;
import com.codes.blues.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户表
 * @author linzg
 * @date 2020/03/02 15:25
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 根据ID查询
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @GetMapping("/{id}")
    public R<User> findById(@PathVariable Integer id) {
        return R.data(userService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @GetMapping("/batch/{ids}")
    public R<List<User>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            return R.data(userService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @PostMapping("/create")
    public R create(UserReq req) {
        return R.data(userService.create(req));
    }

    /**
     * 根据ID删除
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return R.success();
    }

    /**
     * 根据ID集删除
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @GetMapping("/delete/batch/{ids}")
    public R deleteByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
              idList.add(Integer.valueOf(id.trim()));
            }
            userService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @PostMapping("/update")
    public R updateById(UserReq req) {
        userService.updateById(req);
        return R.success();
    }

}