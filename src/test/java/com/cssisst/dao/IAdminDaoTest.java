package com.cssisst.dao;

import com.cssisst.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class IAdminDaoTest {
@Resource
private IAdminDao iAdminDao;
    @Test
    public void getAllAdmin() {
    }

    @Test
    public void save() {
        Admin admin=new Admin(0,"ji","789456","男",20,"5895126","da","sad","fafe");
        iAdminDao.save(admin);
    }

    @Test
    public void getAdminById() {
        Admin adminById = iAdminDao.getAdminById(1);
        System.out.println(adminById.getMemo());
        System.out.println(adminById.getPassword());

    }

    @Test
    public void getAdminBynp() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {

    }
}