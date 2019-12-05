package com.nevermore.spring.controller;

import com.google.gson.Gson;
import com.nevermore.spring.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping("/say")
    public String say(Model model) {
        model.addAttribute("name", "马芳今天有认真学习吗？学好了月薪过万啊！");

        return "hello";
    }

    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public String table(){
        return "redirect:/pages/table.html";
    }

    @RequestMapping("/list")
    public void getStdList(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setAge(20);
        student.setName("zhang san");
        students.add(student);
        Student student1 = new Student();
        student1.setName("li si");
        student1.setAge(22);
        students.add(student1);
        Gson gson = new Gson();
        try {
            response.getWriter().write(gson.toJson(students));
        } catch (IOException e) {
        }
    }

}
