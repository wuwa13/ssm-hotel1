package com.cssisst.service;

import com.cssisst.entity.Maintain;

import java.util.List;

public interface IMaintainService {
    List<Maintain> iMainGetAllMaintain();
    List<Maintain> iMainGetMaintainByMaintainer(String maintainer);
//    List<Maintain> iMainGetMaintainByid(int id);
    Maintain getMaintainMaintainer(String maintainer);
    Maintain getMaintainById(int id);
    void save(Maintain a);

    void del(int id);
    void updatemain(Maintain maintain);
}
