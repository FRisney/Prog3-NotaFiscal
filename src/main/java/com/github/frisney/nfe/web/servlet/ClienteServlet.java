package com.github.frisney.nfe.web.servlet;

import com.github.frisney.nfe.domain.Cliente;
import com.github.frisney.nfe.repositories.ClienteRepository;
import com.github.frisney.nfe.web.view.IView;
import com.github.frisney.nfe.web.view.PageView;
import com.github.frisney.nfe.web.view.components.ClientesListViewComponent;

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
        String id = req.getParameter("id");
        resp.getWriter().print((id == null) ? getClientes() : getCliente(Integer.parseInt(id)));
    }

    protected IView getCliente(Integer id) {
        Cliente cli = new ClienteRepository().byId(id);
//        Cliente cli = new Cliente("doc" + id, "nome");
//        cli.setId(id);
        return new PageView("cliente_detalhe")
                .pushParam("nome", cli.getNome())
                .pushParam("doc", cli.getDocumento())
                .pushParam("id", cli.getId())
                .render();
    }

    protected IView getClientes() {
        var cli = new ClienteRepository().all();
//        var cli = new ArrayList<Cliente>();
//        cli.add(new Cliente("doc1", "nome"));
//        cli.get(0).setId(1);
//        cli.add(new Cliente("doc2", "nome"));
//        cli.get(1).setId(2);
//        cli.add(new Cliente("doc3", "nome"));
//        cli.get(2).setId(3);
//        cli.add(new Cliente("doc4", "nome"));
//        cli.get(3).setId(4);
        System.out.println("[" + (new Date()) + "] ClienteServlet.doGet");
        if(cli.isEmpty()){
            return new PageView("cliente_vazio").render();
        }
        return new PageView("cliente_list")
                .pushParam("cli_list", new ClientesListViewComponent(cli).render())
                .render();
    }
}
