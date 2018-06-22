package com.yun11yun.servlet;

import com.yun11yun.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("在第一次请求时创建LoginServlet实例");

        String param = config.getInitParameter("param");
        System.out.println(param);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);
    }

    @Override
    public void destroy() {
        System.out.println("在服务器退出时销毁LoginServlet实例");
    }
}
