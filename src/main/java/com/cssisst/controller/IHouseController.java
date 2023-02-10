package com.cssisst.controller;

import com.cssisst.entity.House;
import com.cssisst.service.IHouseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/house")
public class IHouseController {
    @Resource
    private IHouseService iHouseService;
    @RequestMapping("/userhouselsit")
    public String usholist(@RequestParam(value = "ownerid") String ownerid, HttpServletRequest request){
        List<House> houseByOwnerid = iHouseService.getHouseByOwnerid(ownerid);
        request.getSession().setAttribute("houses",houseByOwnerid);
        return "user-house-list.jsp";
    }
    @RequestMapping("/adminhouselist")
    public String adminhouselist(@RequestParam("adminname") String adminname,HttpServletRequest request){
        List<House> allHouse = iHouseService.getAllHouse();
        request.getSession().setAttribute("houses",allHouse);
        request.getSession().setAttribute("adminname",adminname);
        return "house-list.jsp";
    }
    @RequestMapping("/houseAdd")
    public String houseAdd(String num,String dep,String type,String area,String sell,String unit,
                           String floor,String direction,String ownerid,String memo,HttpServletRequest request){
        System.out.println("jdaksd");
        House house=new House(0,num,dep,type,area,sell,unit,floor,direction,memo,ownerid);
        iHouseService.add(house);
        List<House> allHouse = iHouseService.getAllHouse();
        request.getSession().setAttribute("houses",allHouse);
        return "house-list.jsp";
    }
    @RequestMapping("/houseDelete")
    public String houseDelete(@RequestParam("id") int id,HttpServletRequest request){
        iHouseService.delete(id);
        List<House> allHouse = iHouseService.getAllHouse();
        request.getSession().setAttribute("houses",allHouse);
        return "house-list.jsp";
    }
    @RequestMapping("/houseedit")
    public String houseedit(@RequestParam("id") int id,HttpServletRequest request){
        House byId = iHouseService.findById(id);
        request.getSession().setAttribute("house",byId);
        return "house-edit.jsp";
    }
    @RequestMapping("/finshhouseedit")
    public String finshhouseedit(String num,String dep,String type,String area,String sell,String unit,
            String floor,String direction,String ownerid,String memo,int id,HttpServletRequest request){
        House byId = iHouseService.findById(id);
        byId.setArea(area);
        byId.setDep(dep);
        byId.setMemo(memo);
        byId.setFloor(floor);
        byId.setDirection(direction);
        byId.setNum(num);
        byId.setOwnerid(ownerid);
        byId.setSell(sell);
        byId.setType(type);
        byId.setUnit(unit);
        iHouseService.update(byId);
        List<House> allHouse = iHouseService.getAllHouse();
        request.getSession().setAttribute("houses",allHouse);
        return "house-list.jsp";
    }
}
