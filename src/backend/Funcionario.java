package backend;

public class Funcionario {
	private int CPF;
	private String Nome;
	private String Setor;
	private String Cargo;
	
	 
	public Funcionario(int cpf,String nome, String setor, String cargo) {
		this.setCPF(cpf);
		this.setNome(nome);
		this.setSetor(setor);
		this.setCargo(cargo);
		
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
	

	
@Override
public String toString() {
	String str;
	str  = "Numero de Cadastro: " + this.getCPF() + "\n";
	str += "Nome: " + this.getNome() + "\n";
	str += "Setor: " + this.getSetor() + "\n";
	str += "Cargo: " + this.getCargo() + "\n";
	return str;
}
}
