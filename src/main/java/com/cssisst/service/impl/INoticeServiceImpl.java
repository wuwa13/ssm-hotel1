package com.cssisst.service.impl;

import com.cssisst.dao.INoticeDao;
import com.cssisst.entity.Notice;
import com.cssisst.service.IAdminService;
import com.cssisst.service.INoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class INoticeServiceImpl implements INoticeService {
    @Resource
    private INoticeDao iNoticeDao;
    @Override
    public List<Notice> FindAll() {
        List<Notice> notices = iNoticeDao.FindAll();
        return notices;
    }

    @Override
    public void addNotice(Notice n) {
        iNoticeDao.Add(n);
    }

    @Override
    public void admindel(int id) {
        iNoticeDao.Delete(id);
    }

    @Override
    public Notice noticeQueryById(int id) {
        Notice select = iNoticeDao.findById(id);
        return select;
    }

    @Override
    public void noticeUpdate(Notice notice) {
        iNoticeDao.updatenotice(notice);

    }
}
