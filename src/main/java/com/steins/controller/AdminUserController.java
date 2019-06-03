package com.steins.controller;

import com.steins.entity.AdminUser;
import com.steins.service.impl.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Sunny
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    private AdminUser admin=new AdminUser();

//    三者共有——关于用户信息的操作
//    ==========================AdminUser=======================================
//    登录
    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, @RequestParam("uid")Integer uid,@RequestParam("password")String password){
        //接收从数据库中查询的信息
        AdminUser existAdmin =new AdminUser() ;
        admin.setUid(uid);
        admin.setPassword(password);
        existAdmin=adminUserService.login(admin);
        //判断用户是否存在
        if(existAdmin == null){
            request.setAttribute("errMsg","登录失败");
            return "/adenglu";
        }else{
            //如果用户存在，将用户信息存到session中
            request.setAttribute("success",true);
            session.setAttribute("existAdmin", existAdmin);
            return "/admin/welcome";
        }
    }
//查看信息
    @RequestMapping("/selectAdmin")
    public String selectAdmin(HttpServletRequest request,@RequestParam("uid") Integer uid){
        admin=adminUserService.select(uid);
        request.getSession().setAttribute("admin",admin);
        return "/admin/ckxx";
    }
//  修改密码
    @RequestMapping("/update")
    public String teacherUpdate(HttpServletRequest request){
        AdminUser adminUser= (AdminUser) request.getSession().getAttribute("existAdmin");
        Integer uid =adminUser.getUid();
        String npw=request.getParameter("npw");
//        System.out.println("========="+uid);
        System.out.println("========="+adminUser.getUid());
        System.out.println("========="+npw);
        Integer flag=adminUserService.updatePW(uid,npw);
        if (flag>0){

            return "/teacher/upwsuccess";
        }
        else {
            request.setAttribute("errMsg","修改失败");
            return "/admin/upw";
        }
    }
//    安全退出
    @RequestMapping("sessionDestoryadmin")
    public String sessionDestoryadmin(HttpSession session){
        session.invalidate();
        return "redirect:/adenglu.jsp";
    }
//    =================================================================
}
