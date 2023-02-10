package com.cssisst.dao;

import com.cssisst.entity.Admin;
import com.cssisst.entity.Maintain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class IMaintainDaoTest {
@Resource
private IMaintainDao iMaintainDao;
    @Test
    public void getAllMaintain() {
        List<Maintain> allMaintain = iMaintainDao.getAllMaintain();
        System.out.println(allMaintain);
    }

    @Test
    public void save() {
        Maintain maintain=new Maintain(0,"das0","das","dasjoi",
                "圣诞节哦","sdajk",20.55,33.03,"asd","dsji");
        iMaintainDao.save(maintain);
    }

    @Test
    public void getMaintainById() {
    }

    @Test
    public void getMaintainByMaintainer() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}