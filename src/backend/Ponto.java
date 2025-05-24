package backend;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Ponto {
	
	private Funcionario funcionario;
	private LocalDate data;
	private Time horaEntrada;
	private Time horaSaida;
	
	public Ponto(Funcionario funcionario, String horaEntrada, String horaSaida) {
		this.setFuncionario(funcionario); 
		this.setData(LocalDate.now());
		this.setHoraEntrada(horaEntrada);
		this.setHoraSaida(horaSaida);
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Time getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = Time.valueOf(horaEntrada);
	}
	public Time getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = Time.valueOf(horaSaida);
	}
	
	
	public String Atualizacao( Funcionario funcionario, String data, String horaEntrada, String horaSaida) {
		
		if (funcionario == null || data == null || horaEntrada == null || horaSaida == null) {
			return "Erro: Dados inválidos.";
		} else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			this.setFuncionario(funcionario);
			this.setData(LocalDate.parse(data, formatter));
			this.setHoraEntrada(horaEntrada);
			this.setHoraSaida(horaSaida);
			return "Dados atualizados com sucesso.";
		}
		
	}
	
	
	@Override
	public String toString() {
		String str;
		str  = "Numero de Cadastro: " + funcionario.getCPF() + "\n";
		str += "Funcionario: " + funcionario.getNome() + "\n";
		str += "Data: " + data + "\n";
		str += "Hora de entrada: " + horaEntrada + "\n";
		str += "Hora de saida: " + horaSaida + "\n";
		return str;
		
	}
	
}
