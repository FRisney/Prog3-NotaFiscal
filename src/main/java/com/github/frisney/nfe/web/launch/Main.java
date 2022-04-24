package com.github.frisney.nfe.web.launch;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

class Main {
    public static void main(String[] args) throws ServletException, LifecycleException {
        var servletsPath = new File(
                "src/main/java/com/github/frisney/nfe"
        ).getAbsolutePath();
        System.out.println(servletsPath);

        Tomcat server = new Tomcat();
        server.setPort(8080);

        StandardContext ctx = (StandardContext) server.addWebapp("/",servletsPath);
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        server.start();
        server.getServer().await();
    }
}