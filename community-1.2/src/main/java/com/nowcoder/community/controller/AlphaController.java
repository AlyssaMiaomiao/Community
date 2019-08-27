package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;//通常控制层要依赖业务层
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring Boot.";
    }

    @RequestMapping("/date")
    @ResponseBody
    //如果有ResponseBody，表示返回的是字符串，如果没有，表示返回的是页面
    public String getDate() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        //得到请求的方法
        System.out.println(request.getMethod());
        //输出请求路径
        System.out.println(request.getServletPath());
        //得到所有的请求参数名，遍历参数名得到参数值
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name=enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(request.getParameter("code"));
        //运用response向http中返回响应数据
        //设置返回数据类型和编码
        response.setContentType("text/html;charset=utf-8");
        //在java7之后就可以在try中创建，然后就会自动的在finally中关闭流，如果没有在这里面创建，就要自己关闭流
        try(PrintWriter writer=response.getWriter();) {
            //通过response的输出流向浏览器写数据
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Get请求：常用于向服务器获取数据
    //post请求：常用于浏览器向服务器提交数据

    //下面是get请求的例子
    @RequestMapping(path="/students",method= RequestMethod.GET)
    @ResponseBody
    //Studetns?current=3&limit=20
    //@RequestParam表示注入request中的请求参数，required=false：表示如果没有可以不注入，如果required=true，表示一定要注入
    //或者可以直接写getStudents（int current,int limit）如果请求参数名和方法的参数名一致，就可以自动收集，如果不一致，就收集不到
    public String getStudents(@RequestParam(name="current",required = false,defaultValue = "1")int current,
                              @RequestParam(name="limit",required=false,defaultValue="10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    //如果是参数值直接在路径中
    //student/123
    @RequestMapping(path="/student/{id}" ,method=RequestMethod.GET)
   @ResponseBody
    //@PathVariable通过这个注解来得到请求路径中的参数
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student ";
    }

    //下面是post请求的例子
    //在post中，只需要请求参数名和方法的参数名一致
    @RequestMapping(path = "/student", method=RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应HTML数据
    @RequestMapping(path="/teacher",method=RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",30);
        mav.setViewName("/demo/view");
        return mav;
    }
    //下面这个方法和上面的方法是功能一样的
    @RequestMapping(path="/school" ,method=RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    //响应json数据（一般在异步请求中使用）
    @RequestMapping(path="/emp",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",8000.00);
        return emp;  //ResponseBody表示要返回字符串，所以会自动将map转换成json字符串
    }

    @RequestMapping(path="/emps",method=RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",8000.00);
        list.add(emp);

        emp=new HashMap<>();
        emp.put("name","李四");
        emp.put("age",24);
        emp.put("salary",9000.00);
        list.add(emp);

        emp=new HashMap<>();
        emp.put("name","王五");
        emp.put("age",25);
        emp.put("salary",10000.00);
        list.add(emp);
        return list;  //ResponseBody表示要返回字符串，所以会自动将map转换成json字符串
    }
}
