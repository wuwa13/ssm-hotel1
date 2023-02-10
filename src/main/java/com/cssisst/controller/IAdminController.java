package com.cssisst.controller;

import com.cssisst.entity.Admin;
import com.cssisst.entity.CustomAccount;
import com.cssisst.service.IAdminService;
import com.cssisst.service.ICustomoAccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class IAdminController {
    @Resource
    private IAdminService iAdminService;

    @Resource
    private ICustomoAccountService iCustomoAccountService;

    @RequestMapping("/login")
    public String login(String name,String password,String usertype, HttpServletRequest request) {
        if(usertype.equals("admin")){
            Admin adminBynp = iAdminService.getAdminBynp(name, password);
            if (adminBynp==null){
                return "/login.jsp";
            }else {
               if(adminBynp.getPassword().equals(password)){

                   request.getSession().setAttribute("adminname",adminBynp.getName());
                   return "redirect:/index.jsp";
               }else {
                   return "/login.jsp";
               }
            }
        }else {
            CustomAccount customAccount = iCustomoAccountService.cuGetCustomAccountBynp(name, password);
            if(customAccount!=null) {
               if (customAccount.getPassword().equals(password)){
                   request.getSession().setAttribute("customAccount",customAccount);
                   return "redirect:/index2.jsp";
               }else {
                   return "/login.jsp";
               }
            }
            return "/login.jsp";
        }

    }
    @RequestMapping("/index")
    public String index(@RequestParam("id")int id, HttpServletRequest request){
        Admin adminById = iAdminService.getAdminById(id);
        request.getSession().setAttribute("admins",adminById);
        return "redirect:../index.jsp";
    }
    @RequestMapping("/all")
    public String getAll(@RequestParam("adminname")String adminname, HttpServletRequest request){
        List<Admin> admin = iAdminService.getAllAdmin();
        request.getSession().setAttribute("admins",admin);
        request.getSession().setAttribute("adminname",adminname);
        return "admin-list.jsp";
    }

    @RequestMapping("/save")
    public String save(String name, String password, String sex, int age, String tel,
                       String phone, String addr, String memo, HttpServletRequest request){
        Admin admin=new Admin(0,name,password,sex,age,tel,phone,addr,memo);
        iAdminService.save(admin);
        List<Admin> allAdmin = iAdminService.getAllAdmin();
        request.getSession().setAttribute("admins",allAdmin);
        return "admin-list.jsp";
    }

    @RequestMapping("/addmain")
    public String addmain(){

        return "admin-add.jsp";
    }

    @RequestMapping("/del")
    public String del(@RequestParam(value = "id") int id, HttpServletRequest request){
        System.out.println("dasdasdas");
        iAdminService.del(id);
        List<Admin> admin = iAdminService.getAllAdmin();
        request.getSession().setAttribute("admins",admin);
        return "admin-list.jsp";
    }
    @RequestMapping("/addedit")
    public String addedit(@RequestParam(value = "id") int id,HttpServletRequest request){
        Admin adminById = iAdminService.getAdminById(id);
        request.getSession().setAttribute("admins",adminById);
        return "admin-edit.jsp";
    }
    @RequestMapping("/addsaveedit")
    public String addsaveedit(@RequestParam(value = "id")int id, String password,String sex,HttpServletRequest request){
        Admin adminById = iAdminService.getAdminById(id);
        adminById.setPassword(password);
        adminById.setSex(sex);
        iAdminService.update(adminById);
        List<Admin> allAdmin = iAdminService.getAllAdmin();
        request.getSession().setAttribute("admins",allAdmin);
        return "admin-list.jsp";
    }
}
