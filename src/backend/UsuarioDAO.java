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
   
   public void inserir(Ponto ponto, Funcionario funcionario) {
	   String sql = "call inclusao(?,?,?,?,?,?,?,?,? )";
	   ConecxaoBD bd = new ConecxaoBD();
	   if(bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setInt(1, funcionario.getCPF());
		   stmt.setString(2, funcionario.getNome());
		   stmt.setString(3, funcionario.getCargo());
		   stmt.setString(4, funcionario.getSetor());
		   stmt.setDate(5, Date.valueOf(ponto.getData()));
		   stmt.setTime(6, ponto.getHoraEntrada());
		   stmt.setTime(7, ponto.getHoraEntradaIntervalo());
		   stmt.setTime(8, ponto.getHoraSaidaIntervalo());
		   stmt.setTime(9, ponto.getHoraSaida());
		   
		   stmt.executeUpdate();
		   System.out.println("Funcionário inserido com sucesso!");
		   stmt.close();
	   } catch (SQLException e) {
		   System.out.println("Erro ao inserir ponto: " + e.getMessage());
		   e.printStackTrace();
	   }
	   }
   }
   
   public void Alterar(Ponto ponto, Funcionario funcionario) {
	   String sql = "call alterar(?,?,?,?,?,? )";
	   ConecxaoBD bd = new ConecxaoBD();
	   if(bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setInt(1, funcionario.getCPF());
		   stmt.setDate(2, Date.valueOf(ponto.getData()));
		   stmt.setTime(3, ponto.getHoraEntrada());
		   stmt.setTime(4, ponto.getHoraEntradaIntervalo());
		   stmt.setTime(5, ponto.getHoraSaidaIntervalo());
		   stmt.setTime(6, ponto.getHoraSaida());
		   
		   stmt.executeUpdate();
		   System.out.println("Funcionário alterado com sucesso!");
		   stmt.close();
	   } catch (SQLException e) {
		   System.out.println("Erro ao inserir ponto: " + e.getMessage());
		   e.printStackTrace();
	   }
	   }
   }

   

}
