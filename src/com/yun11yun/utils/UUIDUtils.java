package com.yun11yun.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getUUIDFileName(String origin) {
        if (origin == null) {
            return null;
        }
        return getUUID() + origin;
    }
}
