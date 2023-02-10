package com.cssisst.dao;

import com.cssisst.entity.Notice;

import java.util.List;

public interface INoticeDao {
	List<Notice> FindAll();
	Notice findById(int id);
	void Add(Notice n);
	void updatenotice(Notice n);
	void Delete(int id);
}
