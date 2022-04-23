package com.github.frisney.nfe_web.servlet;

import com.github.frisney.nfe_web.view.PageView;
import com.github.frisney.nfe_web.view.ViewComponent;

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
        var out = resp.getWriter();
        System.out.println("[" + (new Date()) + "] HomeServlet.doGet");
        var view = new PageView("home")
                .pushParam("lol", new ViewComponent("bold").pushParam("val","teste render").render())
                .pushParam("num", 100);
        out.print(view.render());
    }
}
