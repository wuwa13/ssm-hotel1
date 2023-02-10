package com.cssisst.service;

import com.cssisst.entity.Notice;

import java.util.List;

public interface INoticeService {
    List<Notice> FindAll();

    void addNotice(Notice n);

    void admindel(int id);

    Notice noticeQueryById(int id);

    void noticeUpdate(Notice notice);
}
