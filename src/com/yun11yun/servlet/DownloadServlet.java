package com.yun11yun.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接受参数
        String filename = request.getParameter("filename");

        // 2. 设置Content-Type, Content-Disposition
        String contentType = this.getServletContext().getMimeType(filename);

        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Disposition","attachment; filename="+ filename + "");

        // 3. 服务器把文件发送给浏览器
        byte[] data = new byte[1024];
        int length = -1;
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/resources/" + filename);
        InputStream in = new FileInputStream(realPath);
        ServletOutputStream outputStream = response.getOutputStream();
        while ((length = in.read(data)) != -1) {
            outputStream.write(data);
            outputStream.flush();
        }
    }
}
