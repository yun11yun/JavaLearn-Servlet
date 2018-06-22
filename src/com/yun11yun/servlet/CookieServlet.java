package com.yun11yun.servlet;

import com.yun11yun.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;


public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        Cookie[] cookies = request.getCookies();

        Cookie cookie = CookieUtils.findCookie(cookies, "history");

        if (cookie == null) {
            Cookie ncookie = new Cookie("history", id);
            response.addCookie(cookie);
        } else {
            String value = cookie.getValue();
            String[] ids = value.split("-");
            LinkedList<String> list = new LinkedList <>(Arrays.asList(ids));

            if (list.contains(id)) {
                list.remove(id);
                list.addFirst(id);
            } else {

                if (list.size() >= 3) {
                    list.removeLast();
                    list.addFirst(id);
                } else {
                    list.addFirst(id);
                }
            }

            StringBuffer sb = new StringBuffer();
            for (String s : list) {
                sb.append(s).append("-");
            }
        }
    }
}
