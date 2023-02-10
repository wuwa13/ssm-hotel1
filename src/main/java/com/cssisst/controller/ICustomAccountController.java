package com.cssisst.controller;

import com.cssisst.entity.CustomAccount;
import com.cssisst.service.ICustomoAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/custom")
public class ICustomAccountController {
    @Resource
    private ICustomoAccountService iCustomoAccountService;

    @RequestMapping("/change")
    public String customChange(@RequestParam(value = "accountid") int accountid, HttpServletRequest request){
        System.out.println(accountid);
        CustomAccount customAccount = iCustomoAccountService.getCustomAccountById(accountid);
        request.getSession().setAttribute("customAccount",customAccount);
        return "../customAccount/user-change-passwd.jsp";
    }
    @RequestMapping("/changepwd")
    public String changePwd(@RequestParam(value = "accountid") int accountid,String password){
        CustomAccount customAccountById = iCustomoAccountService.getCustomAccountById(accountid);
        customAccountById.setPassword(password);
        iCustomoAccountService.cuUpdate(customAccountById);
        return "../customAccount/user-custom-list.jsp";
    }

    @RequestMapping("/find")
    public String find(@RequestParam(value = "accountid") int accountid,HttpServletRequest request){
        CustomAccount customAccountById = iCustomoAccountService.getCustomAccountById(accountid);
        request.getSession().setAttribute("customAccount",customAccountById);
        return "../customAccount/user-custom-list.jsp";
    }
    @RequestMapping("/listall")
    public String listall(@RequestParam("adminname")String adminname, HttpServletRequest request){
        List<CustomAccount> alLcustomAccount = iCustomoAccountService.getALLcustomAccount();
        request.getSession().setAttribute("customAccounts",alLcustomAccount);
        request.getSession().setAttribute("adminname",adminname);
        return "../customAccount/custom-list.jsp";
    }
    @RequestMapping("/customadd")
    public String customadd(String username,String password,String ownerid,String carid,HttpServletRequest request){
        CustomAccount customAccount=new CustomAccount(0,username,password,ownerid,carid);
        iCustomoAccountService.cusSave(customAccount);
        List<CustomAccount> alLcustomAccount = iCustomoAccountService.getALLcustomAccount();
        request.getSession().setAttribute("customAccounts",alLcustomAccount);
        return "../customAccount/custom-list.jsp";
    }
    @RequestMapping("/customdel")
    public String customdel(@RequestParam("accountid")int accountid,HttpServletRequest request){
        iCustomoAccountService.cuDelete(accountid);
        List<CustomAccount> alLcustomAccount = iCustomoAccountService.getALLcustomAccount();
        request.getSession().setAttribute("customAccounts",alLcustomAccount);
        return "../customAccount/custom-list.jsp";
    }
    @RequestMapping("/customedit")
    public String customedit(@RequestParam("accountid")int accountid,HttpServletRequest request){
        CustomAccount customAccountById = iCustomoAccountService.getCustomAccountById(accountid);
        request.getSession().setAttribute("customAccount",customAccountById);
        return "../customAccount/custom-edit.jsp";
    }
    @RequestMapping("/finshcustomedit")
    public String finshcustomedit(String username,String password,
                                  String ownerid,String carid,int accountid,HttpServletRequest request){
        CustomAccount customAccountById = iCustomoAccountService.getCustomAccountById(accountid);
        customAccountById.setPassword(password);
        customAccountById.setCarid(ownerid);
        customAccountById.setUsername(username);
        customAccountById.setCarid(carid);
        iCustomoAccountService.cuUpdate(customAccountById);
        List<CustomAccount> alLcustomAccount = iCustomoAccountService.getALLcustomAccount();
        request.getSession().setAttribute("customAccounts",alLcustomAccount);
        return "../customAccount/custom-list.jsp";
    }
}
