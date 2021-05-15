package br.rhs.controller;

import br.rhs.model.Cliente;
import br.rhs.model.CRUD.DatabaseCliente;

public class CadastroCliente {
	
    public String listarCliente(String dataCobranca) {
        return DatabaseCliente.getListaClientes(dataCobranca);
    }
     
    public String salvar(Cliente cliente) {
        return DatabaseCliente.salvar(cliente);
    }
    
    public String atualizar(Cliente cliente) {
        return DatabaseCliente.atualizar(cliente);
    }	
}
