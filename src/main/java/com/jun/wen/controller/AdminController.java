package com.jun.wen.controller;

import com.jun.wen.domain.Article;
import com.jun.wen.domain.User;
import com.jun.wen.service.ArticleService;
import com.jun.wen.service.CategoryService;
import com.jun.wen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

/**
 * 后台主页
 */
    @RequestMapping("")
    public String admin(Model model){
        List<Article> articles = articleService.list();
        model.addAttribute("articles",articles);

        return "admin/index";
    }

    /**
     * 登录模块
     */
    @PostMapping("/dologin")
    public String doLogin(HttpServletResponse response, User user, Model model){
        if (userService.login(user.getUserName(),user.getPassword())){
//            Cookie cookie = new Cookie((MyInterceptor));
                    /*
                    待修改
                     */
            return "refirect:/admin";
        }else {
            model.addAttribute("error","用户名或者密码错误");
            System.out.println("failture");
            return "admin/login";
        }

    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        articleService.delete((id));
        return "redirect:/admin";

    }
}

