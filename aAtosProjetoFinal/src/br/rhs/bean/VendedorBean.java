package br.rhs.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.rhs.controller.CadastroVendedor;
import br.rhs.model.Vendedor;

@ManagedBean(name="vendedorBean")
@RequestScoped
public class VendedorBean {
	    
    public String cadastrarVendedor(String nome, String cpf, String rg, String celular, String telefone, String cep, String rua, int numeroCasa, String bairro, String cidade, String uf) {
		CadastroVendedor cadastroVendedor = new CadastroVendedor();
		Vendedor vendedor = new Vendedor();
		vendedor.setNome(nome);
		vendedor.setCpf(cpf);
		vendedor.setRg(rg);
		vendedor.setCelular(celular);
		vendedor.setTelefone(telefone);
		vendedor.setCep(cep);
		vendedor.setRua(rua);
		vendedor.setNumeroCasa(numeroCasa);
		vendedor.setBairro(bairro);
		vendedor.setCidade(cidade);
		vendedor.setUf(uf);
		
		return cadastroVendedor.salvar(vendedor);
	}

}
