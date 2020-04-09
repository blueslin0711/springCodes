package com.codes.blues.repository;

import com.codes.blues.BaseTest;
import com.codes.blues.entity.JpaEntityData;
import com.codes.blues.entity.SelectEntity;
import com.codes.blues.util.EntityUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JpaEntityDataRepositoryTest extends BaseTest {

    @Autowired
    JpaEntityDataRepository jpaEntityDataRepository;

    private static JpaEntityData jpaEntityData = new JpaEntityData();

    @Test
    public void test1Save() {
        System.out.println("save");
        jpaEntityData.setName("小白");
        jpaEntityData.setAddress("奉化");
        jpaEntityData.setSaveTime(new Date());
        JpaEntityData save = jpaEntityDataRepository.save(jpaEntityData);
        System.out.println(save);
    }

    @Test
    public void test2FindAll() {
        System.out.println("findAll");
        List<JpaEntityData> list = jpaEntityDataRepository.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void test2FindByName() {
        JpaEntityData data = jpaEntityDataRepository.findByName(jpaEntityData.getName());
        System.out.println(data);
    }

    @Test
    public void test2SelectEntityData() {
        List<Object[]> list = jpaEntityDataRepository.selectEntityData("小白");
        for(Object[] objects:list){
            System.out.println(Arrays.toString(objects));
        }
        List<SelectEntity> vos = EntityUtils.castEntity(list, SelectEntity.class);
        System.out.println(vos);
    }

    //转换实体类
    public static <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) throws Exception {
        List<T> returnList = new ArrayList<T>();
        if(CollectionUtils.isEmpty(list)){
            return returnList;
        }
        Object[] co = list.get(0);
        Class[] c2 = new Class[co.length];
        //确定构造方法
        for (int i = 0; i < co.length; i++) {
            if(co[i]!=null){
                c2[i] = co[i].getClass();
            }else {
                c2[i]=String.class;
            }
        }
        for (Object[] o : list) {
            Constructor<T> constructor = clazz.getConstructor(c2);
            returnList.add(constructor.newInstance(o));
        }
        return returnList;
    }

    @Test
    public void test3DeleteById() {
        System.out.println("deleteById");
        jpaEntityDataRepository.deleteById(jpaEntityData.getPId());
    }
}