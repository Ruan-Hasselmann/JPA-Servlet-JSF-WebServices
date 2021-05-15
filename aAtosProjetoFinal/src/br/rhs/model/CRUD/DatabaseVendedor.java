package br.rhs.model.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import br.rhs.model.Vendedor;

public class DatabaseVendedor {

   public static Statement stmt;
   public static Connection conn;
   public static ResultSet rs;
   public static PreparedStatement pstmt;

   public static Connection getConnection(){  
       try{  
           Class.forName("com.mysql.jdbc.Driver");     
           String url ="jdbc:mysql://127.0.0.1:3306/crediario";
           String usuario = "root";
           String senha = "6518";
           conn = DriverManager.getConnection(url,usuario,senha);  
       } catch(Exception sqlException) {  
           sqlException.printStackTrace();
       }  
       return conn;
   }

   public static String salvar(Vendedor vendedor) {
       int status = 0;
       String redirecionamentoNavegacao = "";
       
       if (vendedor.getNome().isEmpty() ) {
    	   System.out.println("Não digitou um nome na view de cadastro");
    	   status = 0;
       }
       else { 
	       try {      
	           pstmt = getConnection().prepareStatement("insert into vendedor (nome, cpf, rg, celular, telefone, cep, rua, bairro, cidade, uf, numeroCasa) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");         
	           pstmt.setString(1, vendedor.getNome());
	           pstmt.setString(2, vendedor.getCpf());
	           pstmt.setString(3, vendedor.getRg());
	           pstmt.setString(4, vendedor.getCelular());
	           pstmt.setString(5, vendedor.getTelefone());
	           pstmt.setString(6, vendedor.getCep());
	           pstmt.setString(7, vendedor.getRua());
	           pstmt.setString(8, vendedor.getBairro());
	           pstmt.setString(9, vendedor.getCidade());
	           pstmt.setString(10, vendedor.getUf());
	           pstmt.setInt(11, vendedor.getNumeroCasa());
	 
	           status = pstmt.executeUpdate();
	           conn.close();
	       } catch(Exception sqlException) {
	           sqlException.printStackTrace();
	       }
       }
       if(status !=0) {
    	   redirecionamentoNavegacao = " Cadastrado com sucesso!";
       } else {
    	   redirecionamentoNavegacao = " Já cadastrado";
       }
       return redirecionamentoNavegacao;
   }
}