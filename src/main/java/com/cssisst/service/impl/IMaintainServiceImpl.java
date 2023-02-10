package com.cssisst.service.impl;

import com.cssisst.dao.IMaintainDao;
import com.cssisst.entity.Maintain;
import com.cssisst.service.IMaintainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IMaintainServiceImpl implements IMaintainService  {
    @Resource
    private IMaintainDao iMaintainDao;

    @Override
    public List<Maintain> iMainGetAllMaintain() {
        List<Maintain> allMaintain = iMaintainDao.getAllMaintain();
        return allMaintain;
    }

    @Override
    public List<Maintain> iMainGetMaintainByMaintainer(String maintainer) {
        List<Maintain> maintainByMaintainer = iMaintainDao.getMaintainByMaintainer(maintainer);
        return maintainByMaintainer;
    }

    @Override
    public Maintain getMaintainMaintainer(String maintainer) {
        Maintain maintainMaintainer = iMaintainDao.getMaintainMaintainer(maintainer);
        return maintainMaintainer;
    }

    @Override
    public Maintain getMaintainById(int id) {
        Maintain maintainById = iMaintainDao.getMaintainById(id);
        return maintainById;
    }

    @Override
    public void save(Maintain a) {
        iMaintainDao.save(a);
    }

    @Override
    public void del(int id) {
        iMaintainDao.delete(id);
    }

    @Override
    public void updatemain(Maintain maintain) {
        iMaintainDao.updatemain(maintain);
    }
}
