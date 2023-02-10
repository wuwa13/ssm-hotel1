package com.cssisst.dao;

import com.cssisst.entity.Inspection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class IInspectionDaoTest {
@Resource
private IInspectionDao iInspectionDao;
    @Test
    public void getAllInspection() {
        List<Inspection> allInspection = iInspectionDao.getAllInspection();
        System.out.println(allInspection);
    }

    @Test
    public void save() {
    }

    @Test
    public void getInspectionById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}