package com.cssisst.controller;

import com.cssisst.entity.Inspection;
import com.cssisst.service.IInspecyionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/inspection")
public class IIspectionController {
    @Resource
    private IInspecyionService iInspecyionService;

    @RequestMapping("/insectionlist")
    public String insectionlist(@RequestParam("adminname") String adminname, HttpServletRequest request){
        List<Inspection> allInspection = iInspecyionService.getAllInspection();
        request.getSession().setAttribute("inspections",allInspection);
        request.getSession().setAttribute("adminname",adminname);
        return "inspection-list.jsp";
    }
    @RequestMapping("/inspectionadd")
    public String inspectionadd(String person,String itype,
                                String conductor,String party,String iresult,String memo,HttpServletRequest request){
        DateFormat dateFormat=new SimpleDateFormat("yy-MM-DD HH;mm;ss");
        Calendar calendar=Calendar.getInstance();
        String cur=dateFormat.format(calendar.getTime());
        Inspection inspection=new Inspection(0,person,itype,cur,conductor,party,iresult,memo);
        iInspecyionService.saveinspection(inspection);
        List<Inspection> allInspection = iInspecyionService.getAllInspection();
        request.getSession().setAttribute("inspections",allInspection);
        return "inspection-list.jsp";
    }
    @RequestMapping("/inspectiondel")
    public String inspectiondel(@RequestParam(value = "id") int id,HttpServletRequest request){
        iInspecyionService.delete(id);
        List<Inspection> allInspection = iInspecyionService.getAllInspection();
        request.getSession().setAttribute("inspections",allInspection);
        return "inspection-list.jsp";
    }
    @RequestMapping("/inspectionedit")
    public String inspectionedit(@RequestParam(value = "id")int id, HttpServletRequest request){
        Inspection inspectionById = iInspecyionService.getInspectionById(id);
        request.getSession().setAttribute("inspection",inspectionById);
        return "inspection-edit.jsp";
    }
    @RequestMapping("/finishinspection")
    public String finishinspection(String person,String itype,String itime,
                                   String conductor,String party,String iresult,String memo,int id,HttpServletRequest request){
        Inspection inspectionById = iInspecyionService.getInspectionById(id);
        inspectionById.setPerson(person);
        inspectionById.setItime(itime);
        inspectionById.setMemo(memo);
        inspectionById.setParty(party);
        inspectionById.setConductor(conductor);
        inspectionById.setIresult(iresult);
        inspectionById.setItype(itype);
        iInspecyionService.updateinspection(inspectionById);
        List<Inspection> allInspection = iInspecyionService.getAllInspection();
        request.getSession().setAttribute("inspections",allInspection);
        return "inspection-list.jsp";
    }
}
