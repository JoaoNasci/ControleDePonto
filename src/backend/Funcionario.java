package backend;

public class Funcionario {
	private long CPF;
	private String Nome;
	private String Email;
	private String Senha;
	private String Setor;
	private String Cargo;
	private int tipo;
	
	
	public Funcionario() {}
	public Funcionario(int cpf,String nome,String email, String senha, String setor, String cargo, int tipo) {
		this.setCPF(cpf);
		this.setEmail(email);
		this.setSenha(senha);
		this.setNome(nome);
		this.setSetor(setor);
		this.setCargo(cargo);
		this.setTipo(tipo);
		
	}
	
	public long getCPF() {
		return this.CPF;
	}
	public void setCPF(long cpf) {
		this.CPF = cpf;
	}
	public String getNome() {
		return this.Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
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
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
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
