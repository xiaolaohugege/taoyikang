package com.gsm.filters;

import javax.servlet.*;
import java.io.IOException;

public class SetCharacterEncodingFilter implements Filter {
    private String encoding;
    private boolean forceEncoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        String force = filterConfig.getInitParameter("forceEncoding");
        if (force != null) {
            forceEncoding = Boolean.parseBoolean(force);
        } else {
            forceEncoding = false;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (encoding != null) {
            if (forceEncoding || request.getCharacterEncoding() == null) {
                request.setCharacterEncoding(encoding);
            }
            if (forceEncoding) {
                response.setCharacterEncoding(encoding);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 清理资源（如果有）
    }
}
