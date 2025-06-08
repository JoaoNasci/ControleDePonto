package backend;

import java.sql.Time;
import java.time.LocalDate;



public class Ponto {
	
	private Funcionario funcionario;
	private LocalDate data;
	private Time horaEntrada;
	private Time horaEntradaIntervalo;
	private Time horaSaidaIntervalo;
	private Time horaSaida;
	
	public Ponto() {}
	
	public Ponto(Funcionario funcionario,String data, String Entrada,String intervalo, String saidaIntervalo, String Saida) {
		this.setFuncionario(funcionario); 
		this.setData(LocalDate.parse(data));
		this.setHoraEntrada(Time.valueOf(Saida));
		this.setHoraEntradaIntervalo(Time.valueOf(intervalo));
		this.setHoraSaidaIntervalo(Time.valueOf(saidaIntervalo));
		this.setHoraSaida(Time.valueOf(Saida));
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
	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Time getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Time horaSaida) {
		this.horaSaida = horaSaida;
	}
	public Time getHoraEntradaIntervalo() {
		return horaEntradaIntervalo;
	}

	public void setHoraEntradaIntervalo(Time EntradaIntervalo) {
		this.horaEntradaIntervalo = EntradaIntervalo;
	}

	public Time getHoraSaidaIntervalo() {
		return horaSaidaIntervalo;
	}

	public void setHoraSaidaIntervalo(Time SaidaIntervalo) {
		this.horaSaidaIntervalo = SaidaIntervalo;
	}
	
	public void alterarPonto(long cpf,String Entrada, String intervalo, String saidaIntervalo, String Saida) {
		
		if (this.funcionario.getCPF() != cpf) {
		
			System.out.println("CPF do funcionário não corresponde ao ponto registrado.");
			
		}else {
			this.setHoraEntrada(Time.valueOf(Entrada));
			this.setHoraEntradaIntervalo(Time.valueOf(intervalo));
			this.setHoraSaidaIntervalo(Time.valueOf(saidaIntervalo));
			this.setHoraSaida(Time.valueOf(Saida));
			System.out.println("Ponto alterado com sucesso!");
		}
		
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
