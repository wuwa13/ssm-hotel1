package com.cssisst.service.impl;

import com.cssisst.dao.IInspectionDao;
import com.cssisst.entity.Inspection;
import com.cssisst.service.IInspecyionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IIspectionServiceImpl implements IInspecyionService {
    @Resource
    private IInspectionDao iInspectionDao;
    @Override
    public List<Inspection> getAllInspection() {
        List<Inspection> allInspection = iInspectionDao.getAllInspection();
        return allInspection;
    }

    @Override
    public void saveinspection(Inspection i) {
        iInspectionDao.save(i);
    }

    @Override
    public void delete(int id) {
        iInspectionDao.delete(id);
    }

    @Override
    public Inspection getInspectionById(int id) {
        Inspection inspectionById = iInspectionDao.getInspectionById(id);
        return inspectionById;
    }

    @Override
    public void updateinspection(Inspection i) {
        iInspectionDao.updateinspection(i);
    }
}
