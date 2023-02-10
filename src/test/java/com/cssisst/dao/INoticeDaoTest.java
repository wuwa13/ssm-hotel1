package com.cssisst.dao;

import com.cssisst.entity.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class INoticeDaoTest {
@Resource
private INoticeDao iNoticeDao;
    @Test
    public void findAll() {

        List<Notice> notices = iNoticeDao.FindAll();
        System.out.println(notices);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String s=formatter.format(date);
        System.out.println(s);
    }

    @Test
    public void select() {

        Notice n1I1akCZUt = iNoticeDao.findById(2);
        System.out.println(n1I1akCZUt);
    }

    @Test
    public void add() {
        Notice notice=new Notice(0,"sad","asd","SAd","打赏");
        iNoticeDao.Add(notice);

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}