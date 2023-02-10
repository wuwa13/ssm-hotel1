package com.cssisst.controller;

import com.cssisst.entity.CustomAccount;
import com.cssisst.entity.Notice;
import com.cssisst.service.ICustomoAccountService;
import com.cssisst.service.INoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class INoticeController {
    @Resource
    private INoticeService iNoticeService;
//    @Resource
//    private ICustomoAccountService iCustomoAccountService;
    @RequestMapping("/list")
    public String noticelist(HttpServletRequest request){
        List<Notice> notices = iNoticeService.FindAll();
        if (notices!=null){
            request.getSession().setAttribute("notice",notices);
            return "notice-list.jsp";
        }
       return null;
    }

    @RequestMapping("/usernotice")
    public String noticeView( HttpServletRequest request){
        List<Notice> notices = iNoticeService.FindAll();
        request.getSession().setAttribute("notice",notices);
        return "redirect:user-notice-list.jsp";
    }

    @RequestMapping("/add")
    public String noticeadd(String title,String ndate, String uper,String content,HttpServletRequest request){
        System.out.println(title);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        ndate=formatter.format(date);
        System.out.println(ndate);
        Notice notices=new Notice(0,content,ndate,title,uper);
        iNoticeService.addNotice(notices);

        List<Notice> notice = iNoticeService.FindAll();
        request.getSession().setAttribute("notice",notice);
        return "notice-list.jsp";
    }
    @RequestMapping("/noticelist")
    public String adminnoticelist(@RequestParam("adminname") String adminname, HttpServletRequest request){
        List<Notice> notices = iNoticeService.FindAll();
        request.getSession().setAttribute("notices",notices);
        request.getSession().setAttribute("adminname",adminname);
        return "notice-list.jsp";
    }
    @RequestMapping("/adminnoticeadd")
    public String adminnoticeadd(String title,String uper,String content,HttpServletRequest request){
        DateFormat dateFormat=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        Calendar cal=Calendar.getInstance();
        String cur=dateFormat.format(cal.getTime());
        Notice notice=new Notice(0,content,cur,title,uper);
        iNoticeService.addNotice(notice);
        List<Notice> notices = iNoticeService.FindAll();
        request.getSession().setAttribute("notices",notices);
        return "notice-list.jsp";
    }
    @RequestMapping("/admindel")
    public String admindel(@RequestParam(value = "id") int id,HttpServletRequest request){
        iNoticeService.admindel(id);
        List<Notice> notices = iNoticeService.FindAll();
        request.getSession().setAttribute("notices",notices);
        return "notice-list.jsp";
    }

    @RequestMapping("/noticeedit")
    public String noticeedit(@RequestParam(value = "id") int id,HttpServletRequest request){
        Notice notice = iNoticeService.noticeQueryById(id);
        request.getSession().setAttribute("notices",notice);
        return "notice-edit.jsp";
    }
    @RequestMapping("/finishedit")
    public String finishedit(String title,String ndate,String uper,String content,int id,HttpServletRequest request){
        Notice notice = iNoticeService.noticeQueryById(id);
        notice.setTitle(title);
        notice.setNdate(ndate);
        notice.setUper(uper);
        notice.setContent(content);
        iNoticeService.noticeUpdate(notice);
        List<Notice> notices = iNoticeService.FindAll();
        request.getSession().setAttribute("notices",notices);
        return "notice-list.jsp";
    }
}
