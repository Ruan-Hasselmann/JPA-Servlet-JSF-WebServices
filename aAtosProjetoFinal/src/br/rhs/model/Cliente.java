package br.rhs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	private int idCliente;
	private String nome;
	private String cpf;
	private String rg;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;	
	private int numeroCasa;
	private String dataCobranca;
	private String total;
	private String celular;
	private String telefone;
	private Float pago;
	private Float restante;

	
	@Id
	@Column(name = "idCliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getDataCobranca() {
		return dataCobranca;
	}
	public void setDataCobranca(String dataCobranca) {
		this.dataCobranca = dataCobranca;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Float getPago() {
		return pago;
	}
	public void setPago(Float pago) {
		this.pago = pago;
	}
	public Float getRestante() {
		return restante;
	}
	public void setRestante(Float restante) {
		this.restante = restante;
	}
	
	public String getInfo() {
	    return "ID: " + getIdCliente() + " Nome: " + getNome() + " Cpf: " + getCpf() + " Data da Cobrança: " + getDataCobranca() + " Total: " + getTotal() + " Valor pago: " + getPago() + " Restante: " + getRestante();
	}
}
