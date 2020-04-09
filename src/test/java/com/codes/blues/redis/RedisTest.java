package com.codes.blues.redis;

import com.codes.blues.BaseTest;
import com.codes.blues.dao.user.model.User;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Duration;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedisTest extends BaseTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> myTemplate;
 
    @Test
    public void testStringRedis() throws Exception {
        stringRedisTemplate.opsForValue().set("aa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aa"));
    }
    
    /**
     * 
     * 添加测试数据到redis
     * @return void
     * @author linzg
     * @date 2020/3/18 16:31
     */
    @Test
    public void testRedis1AddUser() {
        User user = new User();
        user.setId(999);
        user.setUsername("测试样例");
        user.setBirthday(new Date());
        myTemplate.opsForValue().set("userTest", user);
        User userResult = (User) myTemplate.opsForValue().get("userTest");
        Assert.assertEquals("测试样例", userResult.getUsername());
    }

    /**
     *
     * 添加测试数据到redis
     * @return void
     * @author linzg
     * @date 2020/3/18 16:31
     */
    @Test
    public void testRedis2RemoveUser() {
        Assert.assertTrue(myTemplate.delete("userTest"));
        User user = (User) myTemplate.opsForValue().get("userTest");
        Assert.assertNull(user);
    }

    /**
     * 
     * 测试redis过期时间
     * @return void
     * @author linzg
     * @date 2020/3/18 15:57
     */
    @Test
    public void testRedisExpired() throws InterruptedException {
        User user = new User();
        user.setId(666);
        user.setUsername("测试过期设置样例");
        user.setBirthday(new Date());
        myTemplate.opsForValue().set("userExpiredTest", user, Duration.ofMillis(100));
        User userResult = (User) myTemplate.opsForValue().get("userExpiredTest");
        Assert.assertEquals("测试过期设置样例", userResult.getUsername());
        Thread.sleep(1000L);
        User newResult = (User) myTemplate.opsForValue().get("userExpiredTest");
        Assert.assertNull(newResult);
    }
}