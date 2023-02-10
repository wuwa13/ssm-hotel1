package com.cssisst.service;

import com.cssisst.entity.House;

import java.util.List;

public interface IHouseService {
    List<House> getAllHouse();
    void add(House h);
    void update(House h);
    void delete(int id);
    List<House> getHouseByOwnerid(String oid);
    House findById(int id);
}
