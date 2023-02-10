package com.cssisst.dao;

import com.cssisst.entity.Inspection;

import java.util.List;



public interface IInspectionDao {
	List<Inspection> getAllInspection();
	void save(Inspection i); 
	
	Inspection getInspectionById(int id);
	void updateinspection(Inspection i);
	
	void delete(int id);

}
