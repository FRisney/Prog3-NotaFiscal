package com.github.frisney.nfe.web.servlet;

import com.github.frisney.nfe.web.view.PageView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(
        name = "home",
        urlPatterns = {"/home"}
)
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("[" + (new Date()) + "] HomeServlet.doGet");
        var view = new PageView("home").render();
        resp.getWriter().print(view);
    }
}
