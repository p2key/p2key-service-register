package com.p2key.service.api.main;

import java.io.File;
import java.net.MalformedURLException;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import com.p2key.serviceapi.conf.ApplicationConfig;

public class Main {

    public static void main(String[] args) throws Exception, LifecycleException {
    	for(String arg :args) {
    		new Main().start(Integer.valueOf(arg));
    	}
    }

    public void start(int port) throws ServletException, LifecycleException, MalformedURLException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);

        Context context = tomcat.addWebapp("/", new File(".").getAbsolutePath());

        Tomcat.addServlet(context, "jersey-container-servlet", resourceConfig());
        context.addServletMapping("/*", "jersey-container-servlet");

        tomcat.start();
        tomcat.getServer().await();
    }

    private ServletContainer resourceConfig() {
        return new ServletContainer(new ResourceConfig(new ApplicationConfig().getClasses()));
    }

}