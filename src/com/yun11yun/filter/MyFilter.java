package com.yun11yun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter(asyncSupported = true)
public class MyFilter implements Filter {
    public void destroy() {
        System.out.println("MyFilter 被销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletHttpServletRequestWrapper requestWrapper = new ServletHttpServletRequestWrapper((HttpServletRequest)req);
        chain.doFilter(requestWrapper, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("MyFilter 被创建");
    }

    private class ServletHttpServletRequestWrapper extends HttpServletRequestWrapper {

        private HttpServletRequest request;

        public ServletHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {

            String value = null;
            String method = this.request.getMethod();

            if ("get".equalsIgnoreCase(method)) {
                try {
                    value = new String(this.request.getParameter(name).getBytes("ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else if ("post".equalsIgnoreCase(method)) {
                try {
                    request.setCharacterEncoding("UTF-8");
                    value = request.getParameter(name);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            return value;
        }
    }
}
