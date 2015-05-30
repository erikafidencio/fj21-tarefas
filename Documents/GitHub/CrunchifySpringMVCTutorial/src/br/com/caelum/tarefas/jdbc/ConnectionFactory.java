package br.com.caelum.tarefas.jdbc;
import java.sql.*;
public class ConnectionFactory {
	Connection con;  
	public Connection getConnection(){
		System.out.println("Conectando ao banco");  
        try {  
  
            Class.forName("org.postgresql.Driver");  
            con = DriverManager.getConnection(  
                    "jdbc:postgresql://localhost:5433/banco", "postgres", "root"); 
           System.out.println("Banco conectado!");
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return con;  
	}
}