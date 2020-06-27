package com.pykj.v2.spring.framework.webmvc.servlet;

import java.io.File;

public class PYViewResolver {

    private final String DEFAULT_TEMPLATE_SUFFIX = ".html";

    private File tempateRootDir;

    public PYViewResolver(String templateRoot) {
        String tempateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        tempateRootDir = new File(tempateRootPath);
    }

    public PYView resolveViewName(String viewName) {
        if (null == viewName || "".equals(viewName.trim())) {
            return null;
        }
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFIX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFFIX);
        File templateFile = new File((tempateRootDir.getPath() + "/" + viewName).replaceAll("/+", "/"));
        return new PYView(templateFile);
    }
}
