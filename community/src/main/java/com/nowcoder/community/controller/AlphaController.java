package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * ClassName:AlphaController
 * PackageIntelliJ IDEA
 * Description:
 *
 * @Author Lumy
 * Create 2024/6/8 15:40
 * @Version 1.0
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot.";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return  alphaService.find();
    }
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
//        获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ":"+value);
        }
//        System.out.println(request.getParameter("code"));
        System.out.println(request.getParameter("name"));
//        返回响应数据
        response.setContentType("text/html;charset = utf-8");
        try{
            PrintWriter writer = response.getWriter();
            {
                writer.write("<h1>牛客网</h1>");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    // GET请求
    // /student?current =1&limit =20
    @RequestMapping(path ="/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "20") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    // /students/123
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }
    //POST请求
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // 响应html数据
    @RequestMapping(path ="/teacher", method = RequestMethod.GET)
    public ModelAndView getYeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age","67");
        mav.setViewName("/demo/view");
        return mav ;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age","100");
        return "/demo/view";
    }
    // 响应JSON数据(JSON)
    // JAVA对象 -> JSON字符串 ->JS对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    // 不加默认返回为html
    @ResponseBody
    public Map<String, Object> getEmp(){
        Map<String, Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",8000);
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    // 不加默认返回为html
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        List< Map<String, Object> > list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",8000);
        list.add(new HashMap(emp));

        emp.put("name","李四");
        emp.put("age",45);
        emp.put("salary",8020);
        list.add(new HashMap(emp));

        emp.put("name","王五");
        emp.put("age",70);
        emp.put("salary",80450);
        list.add(new HashMap(emp));

        return list;
    }







}
