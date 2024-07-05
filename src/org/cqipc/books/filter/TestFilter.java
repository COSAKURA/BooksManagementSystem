package org.cqipc.books.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("转码过滤器被销毁了");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 过滤规则
        System.out.println("开始过滤");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 表示放行
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始过滤器
        System.out.println("s");
    }

}
