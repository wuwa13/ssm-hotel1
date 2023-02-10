package com.cssisst.dao;

import com.cssisst.entity.Maintain;

import java.util.List;


public interface IMaintainDao {
	List<Maintain> getAllMaintain();
	void save(Maintain a); 
	Maintain getMaintainById(int id);
	Maintain getMaintainMaintainer(String maintainer);
	List<Maintain> getMaintainByMaintainer(String maintainer);
	void update(Maintain a);
	void delete(int id);
	void updatemain(Maintain maintain);
}
