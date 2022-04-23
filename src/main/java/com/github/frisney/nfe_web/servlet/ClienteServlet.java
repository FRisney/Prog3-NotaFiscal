package com.github.frisney.nfe_web.servlet;

import com.github.frisney.nfe.repositories.ClienteRepository;
import com.github.frisney.nfe_web.view.PageView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(
        name = "clientes",
        urlPatterns = {"/clientes"}
)
public class ClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var out = resp.getWriter();
        var cliserv = new ClienteRepository();
        var cli = cliserv.all();
        System.out.println("[" + (new Date()) + "] ListaClienteServlet.doGet");
        var view = new PageView("cliente_list")
                .pushParam("msg", cli);
        if (req.getParameter("lol") != null)
            view.pushParam("code", req.getParameter("lol"));
        out.print(view.render());
    }
}
