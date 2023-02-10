package com.cssisst.service.impl;

import com.cssisst.dao.IAdminDao;
import com.cssisst.entity.Admin;
import com.cssisst.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IAdminServiceImpl implements IAdminService {

    @Resource
    private IAdminDao iAdminDao;

    @Override
    public Admin getAdminBynp(String name, String password) {
        Admin adminBynp = iAdminDao.getAdminByName(name);
       if (adminBynp.getPassword().equals(password)){
           return adminBynp;
       }else {
           return null;
       }
    }

    @Override
    public Admin getAdminById(int id) {
        Admin adminById = iAdminDao.getAdminById(id);
        return adminById;
    }

    @Override
    public void save(Admin a) {
        iAdminDao.save(a);
    }

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> allAdmin = iAdminDao.getAllAdmin();
        return allAdmin;
    }

    @Override
    public void del(int id) {
        iAdminDao.delete(id);
    }

    @Override
    public void update(Admin a) {
        iAdminDao.update(a);
    }
}
