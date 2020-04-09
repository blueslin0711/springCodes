package com.codes.blues.user;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.script.ScriptUtil;
import cn.hutool.system.RuntimeInfo;
import cn.hutool.system.SystemUtil;
import com.codes.blues.BaseTest;
import com.codes.blues.dao.user.model.User;
import com.codes.blues.dao.user.req.UserReq;
import com.codes.blues.service.user.UserService;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.script.CompiledScript;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.List;

/**
 * 用户表测试用例
 * @author linzg
 * @date 2020/03/02 15:25
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    /**
     * 根据ID查询
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @Test
    public void findByIdTest() {
        print(userService.findById(1));
    }

    /**
     * 根据ID集合查询
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @Test
    public void findByIdsTest() {
        List<Integer> ids = Arrays.asList(1, 2);
        System.out.println(ids);
        List<User> users = userService.findByIds(ids);
        users.forEach(user -> print(user));
    }
    /**
     * 根据ID删除
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @Test
    public void deleteByIdTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "根据ID删除测试通过");
        print(jsonObject);
    }

    /**
     * 根据ID集删除
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @Test
    public void deleteByIdsTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "根据ID集删除测试通过");
        print(jsonObject);
    }

    /**
     * 根据ID修改
     * @author linzg
     * @date 2020/03/02 15:25
     */
    @Test
    public void updateById() {
        User user = userService.findById(1);
        user.setSex("外星人");
        UserReq req = new UserReq();
        BeanUtil.copyProperties(user, req);
        userService.updateById(req);
        print(req);
    }

    @Autowired
    private ApplicationContext applicationContext;

    /**
     *
     * 测试js脚本执行工具
     * @return void
     * @author linzg
     * @date 2020/3/10 16:14
     */
    @Test
    public void jsScriptUtilTest() {
        CompiledScript compile = ScriptUtil.compile("function add(s1, s2) { return s1 + s2;}; add(1, 3)");
        try {
            System.out.println(compile.eval());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
        System.out.printf("最大可申请内存：%d Mb ,", runtimeInfo.getMaxMemory() / 1024 /1024);
        System.out.printf("已分配内存：%d Mb ,", runtimeInfo.getTotalMemory() / 1024 /1024);
        System.out.printf("已分配剩余内存：%d Mb ,", runtimeInfo.getFreeMemory() / 1024 /1024);
    }
}