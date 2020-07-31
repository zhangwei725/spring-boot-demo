package com.smart.th.controller;

import com.smart.th.entity.Area;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/index")

    public String index(ModelMap modelMap, HttpServletRequest request, HttpSession session, HttpCookie cookie) {
        modelMap.addAttribute("uid", 1);
        Area area = new Area();
        modelMap.addAttribute("area", area);
        session.setAttribute("isLogin", true);
        session.setAttribute("username", "admin");
        List<Area> areaList = new ArrayList<>();
        modelMap.addAttribute("areas", areaList);
        return "home";
    }
}
