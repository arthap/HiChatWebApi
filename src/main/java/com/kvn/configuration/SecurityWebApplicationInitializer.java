package com.kvn.configuration;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

/**
 * Created by sevak on 9/6/16.
 */

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    @Override protected void beforeSpringSecurityFilterChain(ServletContext servletContext) { insertFilters(servletContext, new MultipartFilter()); }
}
