package com.yun11yun.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileUtilsTest {
    
    @Test
    public void getUploadDirWith() {
        String dir = FileUtils.getUploadDirWith("a.txt");
        System.out.println(dir);
    }
    
}