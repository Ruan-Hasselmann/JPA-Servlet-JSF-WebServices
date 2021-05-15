package br.rhs.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.rhs.controller.CadastroCliente;
import br.rhs.model.Cliente;
import br.rhs.model.CRUD.DatabaseCliente;
 
@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean {
	
	public String cadastrarCliente(String nome, String cpf, String rg, String celular, String telefone, String cep, String rua, int numeroCasa, String bairro, String cidade, String uf, String total, String data) {
		CadastroCliente cadastroCliente = new CadastroCliente();
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setCelular(celular);
		cliente.setTelefone(telefone);
		cliente.setCep(cep);
		cliente.setRua(rua);
		cliente.setNumeroCasa(numeroCasa);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setUf(uf);
		cliente.setTotal(total);
		cliente.setDataCobranca(data);
		cliente.setPago((float) 0);
		cliente.setRestante(Float.parseFloat(total));

		return cadastroCliente.salvar(cliente);
	}
	
	public String atualizarPagamento(Float pago, String dataCobranca, int idCliente) {
		CadastroCliente cadastroCliente = new CadastroCliente();
		Cliente cliente = new Cliente();
		cliente = DatabaseCliente.buscar(idCliente);
		float rest = cliente.getRestante();
		float total= rest-pago;
		float pago1 = cliente.getPago();
		pago1 = pago1 + pago;
		
		cliente.setPago(pago1);
		cliente.setRestante(total);
		cliente.setDataCobranca(dataCobranca);
		
		return cadastroCliente.atualizar(cliente);
	}
	
	public String listarClientesData(String dataCobranca) {
		CadastroCliente cadastroCliente = new CadastroCliente();
		return cadastroCliente.listarCliente(dataCobranca)+" ";
	}
}
