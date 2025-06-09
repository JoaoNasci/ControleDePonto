package backend;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	
   public void insertFuncionario(Funcionario funcionario) {
	   String sql = "INSERT INTO Funcionarios ( cpf, email, nome, setor, cargo) VALUES (?, ?, ?, ?, ?)";
	   ConecxaoBD bd = new ConecxaoBD();
	   if (bd.getConnection()) {
	   try {
		   PreparedStatement stmt =  ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setBigDecimal(1, new java.math.BigDecimal(funcionario.getCPF()));
		   stmt.setString(2, funcionario.getNome());
		   stmt.setString(3, funcionario.getEmail());
		   stmt.setString(4, funcionario.getSetor());
		   stmt.setString(5, funcionario.getCargo());
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
   
   public List<String> listarPontos(String Nome, Date data) {
	   String sql = "call listar_ponto_funcionario(?,?)";
	   ConecxaoBD bd = new ConecxaoBD();
	   List<String> pontos = new ArrayList<>();
	   if (bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setString(1, Nome);
		   stmt.setDate(2, data);
		   ResultSet rs = stmt.executeQuery();
		   
		   while (rs.next()) {
			   String entrada = rs.getTime("hora_entrada").toString();
			   String entradaIntervalo = rs.getTime("hora_entrada_intervalo").toString();
			   String saidaIntervalo = rs.getTime("hora_saida_intervalo").toString();
			   String saida = rs.getTime("hora_saida").toString();
			   
			   pontos.add("Entrada: "+ entrada);
			   pontos.add("Entrada Intervalo: " + entradaIntervalo);
			   pontos.add("Saída Intervalo: " + saidaIntervalo);
			   pontos.add("Saída: " + saida);
			   
		   }
		   rs.close();
		   stmt.close();
		   bd.closeConnection();
	   } catch (SQLException e) {
		   System.out.println("Erro ao listar pontos: " + e.getMessage());
		   e.printStackTrace();
	   	}
	   }
	   return pontos;
   }
   
   public void ListarFuncionarios() {
	   String sql = "SELECT * FROM Funcionarios";
	   ConecxaoBD bd = new ConecxaoBD();
	   List<Funcionario> funcionarios = new ArrayList<>();
	   if (bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   ResultSet rs = stmt.executeQuery();
		   
		   while (rs.next()) {
			   Funcionario funcionario = new Funcionario() ;
			   funcionario.setCPF(rs.getLong("cpf"));
			   funcionario.setNome(rs.getString("nome"));
			   funcionario.setEmail(rs.getString("email"));
			   funcionario.setSetor(rs.getString("setor"));
			   funcionario.setCargo(rs.getString("cargo"));
			   funcionarios.add(funcionario);
		   }
		   rs.close();
		   stmt.close();
		   bd.closeConnection();
	   } catch (SQLException e) {
		   System.out.println("Erro ao listar funcionários: " + e.getMessage());
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
   
   public void inserir( Funcionario funcionario,Ponto ponto) {
	   String sql = "call inclusao(?,?,?,?,?,?,?,?,?,?)";
	   ConecxaoBD bd = new ConecxaoBD();
	   if(bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setLong(1, funcionario.getCPF());
		   stmt.setString(2, funcionario.getNome());
		   stmt.setString(3, funcionario.getEmail());
		   stmt.setString(4, funcionario.getCargo());
		   stmt.setString(5, funcionario.getSetor());
		   stmt.setDate(6, Date.valueOf(ponto.getData()));
		   stmt.setTime(7, ponto.getHoraEntrada());
		   stmt.setTime(8, ponto.getHoraEntradaIntervalo());
		   stmt.setTime(9, ponto.getHoraSaidaIntervalo());
		   stmt.setTime(10, ponto.getHoraSaida());
		   
		   stmt.executeUpdate();
		   System.out.println("Funcionário inserido com sucesso!");
		   stmt.close();
	   } catch (SQLException e) {
		   System.out.println("Erro ao inserir ponto: " + e.getMessage());
		   e.printStackTrace();
	   }
	   }
   }
   
   public void Alterar(long cpf, String data, String horaEntrada, String horaEntradaIntervalo, String horaSaidaIntervalo, String horaSaida) {
	   String sql = "call alterar(?,?,?,?,?,?)";
	 
	   ConecxaoBD bd = new ConecxaoBD();
	   if(bd.getConnection()) {
	   try {
		   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
		   stmt.setLong(1, cpf);
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
   
   public ResultSet autenticarUsuario(Funcionario funcionario) {
	   String sql = "SELECT * FROM Funcionarios WHERE email = ? AND nome = ?";
	   ConecxaoBD bd = new ConecxaoBD();
	   
	   if (bd.getConnection()) {
		   try {
			   PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
			   stmt.setString(1, funcionario.getEmail());
			   stmt.setString(2, funcionario.getNome());
			   
			   ResultSet rs = stmt.executeQuery();
			   return rs;
		   } catch (SQLException e) {
			   System.out.println("Erro ao autenticar: " + e.getMessage());
			   e.printStackTrace();
			   return null;
		   }
		    
	   }
	   ResultSet rs = null;
	   return rs;  
   }

}
