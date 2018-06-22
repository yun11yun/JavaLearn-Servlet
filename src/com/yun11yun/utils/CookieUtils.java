package com.yun11yun.utils;

import javax.servlet.http.Cookie;
import java.util.Objects;

public class CookieUtils {

    public static Cookie findCookie(Cookie[] cookies, String cookieName) {
        if (cookies == null || cookieName == null) {
            return null;
        } else {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (Objects.equals(cookieName, cookie.getName())) {
                    return cookie;
                }
            }
            return null;
        }
    } 
}
