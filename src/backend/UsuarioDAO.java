package backend;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuarioDAO {
	
   public void insertFuncionario(Funcionario funcionario) {
	   String sql = "INSERT INTO Funcionarios (nome, cpf, cargo, turno) VALUES (?, ?, ?, ?)";
	   ConecxaoBD bd = new ConecxaoBD();
	   if (bd.getConnection()) {
	   try {
		   PreparedStatement stmt =  ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setString(1, funcionario.getNome());
		   stmt.setInt(2, funcionario.getCPF());
		   stmt.setString(3, funcionario.getCargo());
		   stmt.setString(4, funcionario.getTurno().name());
		   stmt.executeUpdate();
		   System.out.println("Funcionário inserido com sucesso!");
		   stmt.close();
		   bd.closeConnection();
	   } catch (SQLException e) {
		   System.out.println("Erro ao inserir funcionário: " + e.getMessage());
		   e.printStackTrace();
	   	}
	   }
   }
   
   public void insertPonto(Ponto ponto) {
	   String sql = "INSERT INTO Registro_Ponto (dia, hora_entrada, hora_saida) VALUES (?, ?, ?)";
	   ConecxaoBD bd = new ConecxaoBD();
	   if(bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setDate(1, Date.valueOf(ponto.getData()));
		   stmt.setTime(2, ponto.getHoraEntrada());
		   stmt.setTime(3, ponto.getHoraSaida());
	   } catch (SQLException e) {
		   System.out.println("Erro ao inserir ponto: " + e.getMessage());
		   e.printStackTrace();
	   }
	   }
   }
   
   

   

}
