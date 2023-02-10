package com.cssisst.service.impl;

import com.cssisst.dao.IHouseDao;
import com.cssisst.entity.House;
import com.cssisst.service.IHouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IHouseServiceImpl implements IHouseService {
    @Resource
    private IHouseDao iHouseDao;
    @Override
    public List<House> getAllHouse() {
        List<House> allHouse = iHouseDao.getAllHouse();
        return allHouse;
    }

    @Override
    public void add(House h) {
        iHouseDao.add(h);
    }

    @Override
    public void update(House h) {
        iHouseDao.update(h);
    }

    @Override
    public void delete(int id) {
        iHouseDao.delete(id);
    }

    @Override
    public List<House> getHouseByOwnerid(String oid) {
        List<House> houseByOwnerid = iHouseDao.getHouseByOwnerid(oid);
        return houseByOwnerid;
    }

    @Override
    public House findById(int id) {
        House byId = iHouseDao.findById(id);
        return byId;
    }
}
