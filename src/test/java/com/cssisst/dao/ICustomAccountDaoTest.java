package com.cssisst.dao;

import com.cssisst.entity.CustomAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class ICustomAccountDaoTest {

    @Resource
    private ICustomAccountDao iCustomAccountDao;
    @Test
    public void getALLcustomAccount() {
        List<CustomAccount> alLcustomAccount = iCustomAccountDao.getALLcustomAccount();
        System.out.println(alLcustomAccount);
    }

    @Test
    public void save() {
        CustomAccount customAccount=new CustomAccount(0,"cus","123456","asdjk","但是尽快");
        iCustomAccountDao.save(customAccount);
    }

    @Test
    public void delete() {
        iCustomAccountDao.delete(11);
    }

    @Test
    public void update() {
        CustomAccount customAccount=new CustomAccount(5,"cus","123456","asdjk","但是尽快");
        iCustomAccountDao.update(customAccount);
    }

    @Test
    public void getCustomAccountById() {
        CustomAccount s = iCustomAccountDao.getCustomAccountById(1);
        System.out.println(s);
    }

    @Test
    public void getCustomAccountBynp() {
    }
}