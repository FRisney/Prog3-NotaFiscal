package com.github.frisney.nfe.web.view.components;

import com.github.frisney.nfe.domain.Cliente;
import com.github.frisney.nfe.web.view.IView;
import com.github.frisney.nfe.web.view.ViewComponent;

import java.util.List;

public class ClientesListViewComponent extends ViewComponent {
    private final List<Cliente> clientes;

    public ClientesListViewComponent(List<Cliente> clientes) {
        super("cli_list_item");
        this.clientes = clientes;
    }

    @Override
    public IView render() {
        String template = html;
        html = "";
        for (var cli : clientes){
            params.clear();
            params.put("id",cli.getId());
            params.put("nome",cli.getNome());
            params.put("documento",cli.getDocumento());
            html += render(template,params);
        }
        return this;
    }
}
