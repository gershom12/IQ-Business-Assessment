package net.iqb.ui;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;
import net.iqb.config.ApplicationConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author gershom
 */

public class WebConfiguration implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(ApplicationConfig.class);
        annotationConfigWebApplicationContext.setServletContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(annotationConfigWebApplicationContext));
        servletContext.addListener(new RequestContextListener());
        servletContext.setInitParameter("BootsFaces_THEME", "default");
        servletContext.setInitParameter("BootsFaces_USETHEME", "cerulean");
        //servletContext.setInitParameter("net.bootsfaces.blockUI", "true");
        //servletContext.setInitParameter("net.bootsfaces.defaults.renderLabel", "true");
        servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");
        servletContext.setInitParameter("primefaces.THEME", "bootstrap");

        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");

        servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE", "true");

        servletContext.setInitParameter("com.sun.faces.numberOfViewsInSession", "3");

        servletContext.setInitParameter("com.sun.faces.numberOfLogicalViews", "10");
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(annotationConfigWebApplicationContext));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }

}
