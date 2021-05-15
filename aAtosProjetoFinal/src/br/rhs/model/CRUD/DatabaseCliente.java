package br.rhs.model.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import br.rhs.model.Cliente;

public class DatabaseCliente {

   public static Statement stmt;
   public static Connection conn;
   public static ResultSet rs;
   public static PreparedStatement pstmt;

   public static Connection getConnection(){  
       try{  
           Class.forName("com.mysql.jdbc.Driver");     
           String url ="jdbc:mysql://127.0.0.1:3306/projeto";
           String usuario = "root";
           String senha = "6518";
           conn = DriverManager.getConnection(url,usuario,senha);  
       } catch(Exception sqlException) {  
           sqlException.printStackTrace();
       }  
       return conn;
   }

   
   public static String getListaClientes(String dataCobranca) {
       List<Cliente> clienteList = new ArrayList<Cliente>();
       try {
           stmt = getConnection().createStatement();    
           rs = stmt.executeQuery("select * from cliente where dataCobranca = '" + dataCobranca + "'");
           while(rs.next()) {  
               Cliente cliente = new Cliente(); 
               cliente.setIdCliente(rs.getInt("idCliente"));  
               cliente.setNome(rs.getString("nome"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setRg(rs.getString("rg"));
               cliente.setCep(rs.getString("cep"));
               cliente.setRua(rs.getString("rua"));
               cliente.setBairro(rs.getString("bairro"));
               cliente.setCidade(rs.getString("cidade"));
               cliente.setUf(rs.getString("uf"));
               cliente.setNumeroCasa(rs.getInt("numeroCasa"));
               cliente.setDataCobranca(rs.getString("dataCobranca"));
               cliente.setTotal(rs.getString("total"));
               cliente.setCelular(rs.getString("celular"));
               cliente.setTelefone(rs.getString("telefone"));
               cliente.setPago(rs.getFloat("pago"));
               cliente.setRestante(rs.getFloat("restante"));
               clienteList.add(cliente);
           }   
           conn.close();
       } catch(Exception sqlException) {
           sqlException.printStackTrace();
       }
       String[] info = new String[clienteList.size()];
       int i = 0;
       for (Cliente c : clienteList) {
    	   info[i] = c.getInfo();
    	   i++;
	   }
       if(clienteList.size()==0) {
    	   return "Nenhum cliente encontrado na data digitada";
       }
       return Arrays.toString(info);
   }

  
   public static String salvar(Cliente cliente) {
       int status = 0;
       String redirecionamentoNavegacao = "";
       
       if (cliente.getNome().isEmpty() ) {
    	   System.out.println("Não digitou um nome na view de cadastro");
    	   status = 0;
       }
       else { 
	       try {      
	           pstmt = getConnection().prepareStatement("insert into cliente (nome, cpf, rg, cep, rua, bairro, cidade, uf, numeroCasa, dataCobranca, total, celular, telefone, pago, restante) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");         
	           pstmt.setString(1, cliente.getNome());
	           pstmt.setString(2, cliente.getCpf());
	           pstmt.setString(3, cliente.getRg());
	           pstmt.setString(4, cliente.getCep());
	           pstmt.setString(5, cliente.getRua());
	           pstmt.setString(6, cliente.getBairro());
	           pstmt.setString(7, cliente.getCidade());
	           pstmt.setString(8, cliente.getUf());
	           pstmt.setInt(9, cliente.getNumeroCasa());
	           pstmt.setString(10, cliente.getDataCobranca());
	           pstmt.setString(11, cliente.getTotal());
	           pstmt.setString(12, cliente.getCelular());
	           pstmt.setString(13, cliente.getTelefone());
	           pstmt.setFloat(14, cliente.getPago());
	           pstmt.setFloat(15, cliente.getRestante());
	 
	           status = pstmt.executeUpdate();
	           conn.close();
	       } catch(Exception sqlException) {
	           sqlException.printStackTrace();
	       }
       }
       if(status !=0) {
    	   redirecionamentoNavegacao = cliente.getNome() + " Cadastrado com sucesso!";
       } else {
    	   redirecionamentoNavegacao = "ERRO AO CADASTRAR CLIENTE";
       }
       return redirecionamentoNavegacao;
   }   
   
   public static String atualizar(Cliente cliente) {
       try {
           pstmt = getConnection().prepareStatement("update cliente set dataCobranca=?, pago=?, restante=? where idCliente=?");    
           pstmt.setString(1, cliente.getDataCobranca());  
           pstmt.setFloat(2, cliente.getPago());  
           pstmt.setFloat(3, cliente.getRestante());  
           pstmt.setInt(4, cliente.getIdCliente());  
           pstmt.executeUpdate();
           conn.close();            
       } catch(Exception sqlException) {
           sqlException.printStackTrace();
       }
       return " Atualizado com sucesso!";
   }
   
   public static Cliente buscar(int idCliente) {
	   Cliente cliente = new Cliente();

       try {
           stmt = getConnection().createStatement();    
           rs = stmt.executeQuery("select * from cliente where idCliente = " + idCliente);    
           if(rs != null) {
               rs.next();
               cliente = new Cliente(); 
               cliente.setIdCliente(rs.getInt("idCliente"));  
               cliente.setNome(rs.getString("nome"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setRg(rs.getString("rg"));
               cliente.setCep(rs.getString("cep"));
               cliente.setRua(rs.getString("rua"));
               cliente.setBairro(rs.getString("bairro"));
               cliente.setCidade(rs.getString("cidade"));
               cliente.setUf(rs.getString("uf"));
               cliente.setNumeroCasa(rs.getInt("numeroCasa"));
               cliente.setDataCobranca(rs.getString("dataCobranca"));
               cliente.setTotal(rs.getString("total"));
               cliente.setCelular(rs.getString("celular"));
               cliente.setTelefone(rs.getString("telefone"));
               cliente.setPago(rs.getFloat("pago"));
               cliente.setRestante(rs.getFloat("restante"));
           }
           conn.close();
       } catch(Exception sqlException) {
           sqlException.printStackTrace();
       }
       return cliente;
   }
}