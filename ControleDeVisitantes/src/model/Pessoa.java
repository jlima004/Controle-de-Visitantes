package model;

public class Pessoa {

	private String nome;
	private String telefone;
	private String email;
	
	private int id;

	public Pessoa(String nome, String email) {

		this.nome = nome;
		this.email = email;
	}
	
	


	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}
	
	

}
