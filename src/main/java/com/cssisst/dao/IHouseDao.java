package com.cssisst.dao;

import com.cssisst.entity.House;

import java.util.List;



public interface IHouseDao {
	List<House> getAllHouse();
	void add(House h);
	void update(House h);
	void delete(int id);
	List<House> getHouseByOwnerid(String oid);
	House findById(int id);
}
