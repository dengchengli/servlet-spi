package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Dely
 * @Date: 2019/12/10 14:36
 */

/**
 * 定义servlet
 */

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问了servlet");
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();
        writer.println("hello world");
        System.out.println("访问servlet结束");
    }
}
