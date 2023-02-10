package com.cssisst.controller;

import com.cssisst.entity.Admin;
import com.cssisst.entity.Maintain;
import com.cssisst.service.IAdminService;
import com.cssisst.service.IMaintainService;
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
@RequestMapping("/maintain")
public class IMaintainController {

    @Resource
    private IMaintainService iMaintainService;
    @RequestMapping("findmain")
    public String find(@RequestParam(value = "username") String username, HttpServletRequest request){
        List<Maintain> maintains = iMaintainService.iMainGetMaintainByMaintainer(username);
        request.getSession().setAttribute("maintains",maintains);
        return "user-maintain-list.jsp";
    }

    @RequestMapping("/add")
    public String addmain(@RequestParam(value = "username") String username,
                          String thing,String homesnumber,double tcost,String smemo,HttpServletRequest request){
        Maintain maintainMaintainer = iMaintainService.getMaintainMaintainer(username);
        maintainMaintainer.setId(0);
        maintainMaintainer.setThing(thing);
        maintainMaintainer.setHomesnumber(homesnumber);
        maintainMaintainer.setTcost(tcost);
        maintainMaintainer.setSmemo(smemo);
        iMaintainService.save(maintainMaintainer);
        List<Maintain> maintains = iMaintainService.iMainGetMaintainByMaintainer(username);
        request.getSession().setAttribute("maintains",maintains);
        return "user-maintain-list.jsp";
    }
    @RequestMapping("/del")
    public String del(@RequestParam("id") int id,@RequestParam("maintainer") String maintainer,HttpServletRequest request){
        iMaintainService.del(id);
        List<Maintain> maintains = iMaintainService.iMainGetMaintainByMaintainer(maintainer);
        request.getSession().setAttribute("maintains",maintains);
        return "user-maintain-list.jsp";
    }

    @RequestMapping("/mainlist")
    public String mainlist(@RequestParam("adminname")String adminname, HttpServletRequest request){
        List<Maintain> maintains = iMaintainService.iMainGetAllMaintain();

        request.getSession().setAttribute("adminname",adminname);
        request.getSession().setAttribute("maintains",maintains);
        return "maintain-list.jsp";
    }

    @RequestMapping("/addmain")
    public String addmain(String thing,String status,String homesnumber,
                          double tcost,double scost,String maintainer,String smemo,HttpServletRequest request){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Calendar()
        Calendar cal = Calendar.getInstance();
        String  curr=dateFormat.format(cal.getTime());

        cal.add(Calendar.DATE, 1);
        String  torr=dateFormat.format(cal.getTime());
        Maintain maintain=new Maintain(0,thing,status,homesnumber,curr,torr,tcost,scost,maintainer,smemo);
        iMaintainService.save(maintain);
        List<Maintain> maintains = iMaintainService.iMainGetAllMaintain();
        request.getSession().setAttribute("maintains",maintains);
        return "maintain-list.jsp";
    }
    @RequestMapping("/delmain")
    public String delmain(@RequestParam("id") int id,HttpServletRequest request){
        iMaintainService.del(id);
        List<Maintain> maintains = iMaintainService.iMainGetAllMaintain();
        request.getSession().setAttribute("maintains",maintains);
        return "maintain-list.jsp";
    }
    @RequestMapping("/addedit")
    public String addedit(@RequestParam("id")int id,HttpServletRequest request){
        Maintain maintainById = iMaintainService.getMaintainById(id);
        System.out.println(maintainById);
        request.getSession().setAttribute("maintain",maintainById);
        return "maintain-edit.jsp";
    }
    @RequestMapping("/finshedit")
    public String finshedit(@RequestParam("id")int id,String thing,String status,String homesnumber,
                            double tcost,double scost,String maintainer,String smemo,HttpServletRequest request){
        Maintain maintainById = iMaintainService.getMaintainById(id);
        maintainById.setThing(thing);
        maintainById.setStatus(status);
        maintainById.setHomesnumber(homesnumber);
        maintainById.setTcost(tcost);
        maintainById.setScost(scost);
        maintainById.setMaintainer(maintainer);
        maintainById.setSmemo(smemo);
        iMaintainService.updatemain(maintainById);
        List<Maintain> maintains = iMaintainService.iMainGetAllMaintain();
        request.getSession().setAttribute("maintains",maintains);
        return "maintain-list.jsp";
    }


}
