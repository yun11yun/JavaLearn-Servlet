package com.yun11yun.utils;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Properties;

public class FileUtils {

    private FileUtils() {}

    // 获取存储文件的根路径
    public static String getUploadRoot() {
        URL url = FileUtils.class.getClassLoader().getResource("/");
        String serverDomain = url.toString();
        return serverDomain.substring("file:".length()) + "/upload";
    }

    // 根据文件名来获取文件存储路径
    public static String getUploadDirWith(String filename) {
        if (filename == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getUploadRoot());
        builder.append("/");
        builder.append(getFilePath(filename));

        return builder.toString();
    }

    // 从Part中获取文件名
    public static String getFilenamePath(Part part) {
        String disposition = part.getHeader("Content-Disposition");
        return disposition.substring(disposition.indexOf("filename=\"") + 10, disposition.length() - 1);
    }

    // 获取唯一文件名
    public static String getUUIDFileName(String origin) {
        return UUIDUtils.getUUIDFileName(origin);
    }

    // 使用目录分离算法获取文件路径
    private static String getFilePath(String filename) {
        int hash = filename.hashCode();

        // 第一层目录
        int first = hash & 0xf;

        // 第二层目录
        int second = hash >> 4 & 0xf;

        // 获取文件路径
        StringBuilder path = new StringBuilder();
        path.append(first);
        path.append("/");
        path.append(second);
        path.append("/");

        return path.toString();
    }
}
