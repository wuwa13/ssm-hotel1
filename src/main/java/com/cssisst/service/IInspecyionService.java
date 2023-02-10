package com.cssisst.service;

import com.cssisst.entity.Inspection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


public interface IInspecyionService {

    List<Inspection> getAllInspection();
    void saveinspection(Inspection i);
    void delete(int id);
    Inspection getInspectionById(int id);
    void updateinspection(Inspection i);
}
