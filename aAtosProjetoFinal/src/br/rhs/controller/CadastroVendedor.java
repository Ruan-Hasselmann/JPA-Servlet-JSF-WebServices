package br.rhs.controller;

import br.rhs.model.Vendedor;
import br.rhs.model.CRUD.DatabaseVendedor;

public class CadastroVendedor {

    public String salvar(Vendedor vendedor) {
        return DatabaseVendedor.salvar(vendedor);
    }	
}



























