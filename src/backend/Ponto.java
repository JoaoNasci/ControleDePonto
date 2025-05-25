package backend;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Ponto {
	
	private Funcionario funcionario;
	private LocalDate data;
	private Time horaEntrada;
	private Time horaEntradaIntervalo;
	private Time horaSaidaIntervalo;
	private Time horaSaida;
	
	public Ponto(Funcionario funcionario, String Entrada,String intervalo, String saidaIntervalo, String Saida) {
		this.setFuncionario(funcionario); 
		this.setData(LocalDate.now());
		this.setHoraEntrada(Entrada);
		this.setHoraEntradaIntervalo(intervalo);
		this.setHoraSaidaIntervalo(saidaIntervalo);
		this.setHoraSaida(Saida);
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
	public Time getHoraEntradaIntervalo() {
		return horaEntradaIntervalo;
	}

	public void setHoraEntradaIntervalo(String EntradaIntervalo) {
		this.horaEntradaIntervalo = Time.valueOf(EntradaIntervalo);
	}

	public Time getHoraSaidaIntervalo() {
		return horaSaidaIntervalo;
	}

	public void setHoraSaidaIntervalo(String SaidaIntervalo) {
		this.horaSaidaIntervalo = Time.valueOf(SaidaIntervalo);
	}
	
	
	
	
	@Override
	public String toString() {
		String str;
		str  = "CPf : " + funcionario.getCPF() + "\n";
		str += "Funcionario: " + funcionario.getNome() + "\n";
		str += "Data: " + this.getData() + "\n";
		str += "Hora de entrada: " + this.getHoraEntrada() + "\n";
		str += "Hora de entrada intervalo: " + this.getHoraEntradaIntervalo() + "\n";
		str += "Hora de saida intervalo: " + this.getHoraSaidaIntervalo() + "\n";
		str += "Hora de saida: " + this.getHoraSaida() + "\n";
		return str;
		
	}

	
	
}
