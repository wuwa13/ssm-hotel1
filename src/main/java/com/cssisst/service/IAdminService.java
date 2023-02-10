package com.cssisst.service;

import com.cssisst.entity.Admin;

import java.util.List;

public interface IAdminService {

    Admin getAdminBynp(String name, String password);
    Admin getAdminById(int id);
    void save(Admin a);

    List<Admin> getAllAdmin();

    void del(int id);
    void update(Admin a);
}
