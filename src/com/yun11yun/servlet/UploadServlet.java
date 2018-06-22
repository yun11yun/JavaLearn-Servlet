package com.yun11yun.servlet;

import com.yun11yun.utils.FileUtils;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/*

 */
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("upfile");
        long size = part.getSize();

        String filename = FileUtils.getFilenamePath(part);

        InputStream inputStream = part.getInputStream();

        // 获取输出路径
        String filePath = FileUtils.getUploadDirWith(filename);

        File upDir = new File(filePath);
        if (!upDir.exists()) {
            upDir.mkdirs();
        }

        File upfile = new File(upDir, filename);
        OutputStream out = new FileOutputStream(upfile);

        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(bytes)) > 0) {
            out.write(bytes, 0, length);
            out.flush();
        }

        inputStream.close();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
