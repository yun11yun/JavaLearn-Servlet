package com.yun11yun.servlet;

import com.yun11yun.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAKey;
import java.sql.SQLException;
import java.util.List;

public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=utf-8");

        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        try {

            PrintWriter writer = response.getWriter();

            List<String> list = new SearchService().searchKeysWith(text);

            if (list == null) {
                writer.write("");
            } else {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    builder.append(list.get(i));
                    if (i != list.size() - 1) {
                        builder.append("-");
                    }
                }
                writer.write(builder.toString());
            }
            writer.flush();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
