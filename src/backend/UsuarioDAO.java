package backend;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	

   public void IncluirSolicitacao(String Nome, String data, String motivo) {
	   String sql = "call incluirSolicitacao(?,?,?)";
	   ConecxaoBD bd = new ConecxaoBD();
	   if(bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setString(1, Nome);
		   stmt.setDate(2, Date.valueOf(data));
		   stmt.setString(3, motivo);
		   
		   stmt.executeUpdate();
		   System.out.println("Solicitação de ponto incluída com sucesso!");
		   stmt.close();
	   } catch (SQLException e) {
		   System.out.println("Erro ao incluir solicitação: " + e.getMessage());
		   e.printStackTrace();
	   }
	   }
	   
   }
   
   public void ExcluirRegistro(String Nome, String data) {
	   String sql = "call excluir(?,?)";
	   ConecxaoBD bd = new ConecxaoBD();
	   if(bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setString(1, Nome);
		   stmt.setDate(2, Date.valueOf(data));
		   
		   stmt.executeUpdate();
		   System.out.println("Funcionário excluído com sucesso!");
		   stmt.close();
	   } catch (SQLException e) {
		   System.out.println("Erro ao excluir ponto: " + e.getMessage());
		   e.printStackTrace();
	   }
	   }
   }
   
   public void InserirFuncioRegistro(Funcionario funcionario,Ponto ponto) {
	   String sql = "call inclusao(?,?,?,?,?,?,?,?,?,?,?,?)";
	   ConecxaoBD bd = new ConecxaoBD();
	   if(bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setLong(1, funcionario.getCPF());
		   stmt.setString(2, funcionario.getNome());
		   stmt.setString(3, funcionario.getEmail());
		   stmt.setString(4, funcionario.getSenha());
		   stmt.setString(5, funcionario.getCargo());
		   stmt.setString(6, funcionario.getSetor());
		   stmt.setInt(7, funcionario.getTipo());
		   stmt.setDate(8, Date.valueOf(ponto.getData()));
		   stmt.setTime(9, ponto.getHoraEntrada());
		   stmt.setTime(10, ponto.getHoraEntradaIntervalo());
		   stmt.setTime(11, ponto.getHoraSaidaIntervalo());
		   stmt.setTime(12, ponto.getHoraSaida());
		   
		   
		   stmt.executeUpdate();
		   System.out.println("Funcionário inserido com sucesso!");
		   stmt.close();
	   } catch (SQLException e) {
		   System.out.println("Erro ao inserir ponto: " + e.getMessage());
		   e.printStackTrace();
	   }
	   }
   }
   
   public void EditarRegistro(String nome, String data, String horaEntrada, String horaEntradaIntervalo, String horaSaidaIntervalo, String horaSaida) {
	   String sql = "call alterar(?,?,?,?,?,?)";
	 
	   ConecxaoBD bd = new ConecxaoBD();
	   if(bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setString(1, nome);
		   stmt.setDate(2, Date.valueOf(data));
		   stmt.setTime(3, Time.valueOf(horaEntrada));
		   stmt.setTime(4, Time.valueOf(horaEntradaIntervalo));
		   stmt.setTime(5, Time.valueOf(horaSaidaIntervalo));
		   stmt.setTime(6, Time.valueOf(horaSaida));
		   
		   stmt.executeUpdate();
		   System.out.println("Funcionário alterado com sucesso!");
		   stmt.close();
	   } catch (SQLException e) {
		   System.out.println("Erro ao inserir ponto: " + e.getMessage());
		   e.printStackTrace();
	   }
	   }
   }
   
   public ResultSet autenticarUsuario(String email, String senha) {
	   String sql = "SELECT * FROM Funcionarios WHERE email = ? AND senha = ?";
	   ConecxaoBD bd = new ConecxaoBD();
	   
	   if (bd.getConnection()) {
		   try {
			   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
			   stmt.setString(1, email);
			   stmt.setString(2, senha);
			   
			   ResultSet rs = stmt.executeQuery();
			   return rs;
		   } catch (SQLException e) {
			   System.out.println("Erro ao autenticar: " + e.getMessage());
			   e.printStackTrace();
			   return null;
		   }
		    
	   }else {
		   System.out.println("Erro ao conectar ao banco de dados.");
		   return null;
	   }
	  
   }
   
   
 

}
