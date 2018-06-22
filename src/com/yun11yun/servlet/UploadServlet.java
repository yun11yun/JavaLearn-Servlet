package com.yun11yun.servlet;

import com.yun11yun.utils.FileUtils;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/*

 */
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part part = request.getPart("upfile");
        long size = part.getSize();

        String filename = FileUtils.getFilenamePath(part);

        InputStream inputStream = part.getInputStream();

        // 获取输出路径
        String serverDomain = this.getClass().getClassLoader().getResource("/").toString();
        String upPath = serverDomain.substring("file:".length()) + "/upload";

        File upDir = new File(upPath);
        if (!upDir.exists()) {
            upDir.mkdirs();
        }

        OutputStream out = new FileOutputStream(upDir);

        byte[] bytes = new byte[1024];
        int length = 0;

    }

}
