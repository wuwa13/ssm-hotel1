package com.cssisst.dao;

import com.cssisst.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAdminDao {
	List<Admin> getAllAdmin();
	void save(Admin a); 
	
	Admin getAdminByName(String name);
	Admin getAdminBynp(@Param("name") String name, @Param("password") String password);
	Admin getAdminById(int id);
	void update(Admin a);
	
	void delete(int id);
	
}	
