package com.tech.security.config;

import jakarta.servlet.*;

import java.io.IOException;

public class TestFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {}
}
