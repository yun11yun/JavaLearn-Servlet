package com.yun11yun.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileUtilsTest {

    @Test
    public void getFilePath() {
        String filepath = FileUtils.getFilePath("a.txt");
        System.out.println(filepath);
    }
}