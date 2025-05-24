package backend;

public class Funcionario {
	private int CPF;
	private String Nome;
	private String Setor;
	private String Cargo;
	private Turno Turno;
	 
	public Funcionario(String nome, String setor, String cargo, Turno turno) {
		this.Nome = nome;
		this.Setor = setor;
		this.Cargo = cargo;
		this.Turno = turno;
	}
	
	public int getCPF() {
		return this.CPF;
	}
	public void setCPF(int cpf) {
		this.CPF = cpf;
	}
	public String getNome() {
		return this.Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public String getSetor() {
		return this.Setor;
	}
	public void setSetor(String setor) {
		this.Setor = setor;
	}
	public String getCargo() {
		return this.Cargo;
	}
	public void setCargo(String cargo) {
		this.Cargo = cargo;
	}
	public Turno getTurno() {
		return this.Turno;
	}
	public void setTurno(Turno turno) {
		this.Turno = turno;
	}
	
@Override
public String toString() {
	String str;
	str  = "Numero de Cadastro: " + this.getCPF() + "\n";
	str += "Nome: " + this.getNome() + "\n";
	str += "Setor: " + this.getSetor() + "\n";
	str += "Cargo: " + this.getCargo() + "\n";
	str += "Turno: " + this.getTurno() + "\n";
	return str;
}
}
