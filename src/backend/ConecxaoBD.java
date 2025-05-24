package backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConecxaoBD {
	public Connection connection = null;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String BDNAME = "ControleDePonto";
	private final String URL = "jdbc:mysql://localhost:3306/" + BDNAME;
	private final String LOGIN = "root";
	private final String SENHA = "123456";
	

   public boolean getConnection() {
	   try {
		   Class.forName(DRIVER);
		   connection = (Connection) DriverManager.getConnection(URL, LOGIN, SENHA);
		   System.out.println("Conectado com sucesso!");
		   return true;
	   } catch (ClassNotFoundException e) {
		   System.out.println("Driver não encontrado "+ e.getMessage());
		  
		   return false;
	   } catch (SQLException e) {
		   System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		  
		   return false;
	   } 
	   
   }
   
   public void closeConnection() throws SQLException {
	   try {
		   if (connection != null) {
			   connection.close();
			   System.out.println("Conexão fechada com sucesso!");
		   }
	   } catch (SQLException e) {
		System.out.println("Erro ao fechar a conexão: " + e.getMessage());
		
	}
   }

}
