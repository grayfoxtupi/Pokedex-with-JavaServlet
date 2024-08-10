package pack;

import org.bson.types.Binary;

public class Register {
	
	Register(String nome,String tipo, Binary dados){
		super();
		
		this.nome = nome;
		this.tipo = tipo;
		this.dados = dados;
	}
	
	private String nome;
	private String tipo;
	private Binary dados;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Binary getDados() {
		return dados;
	}
	public void setDados(Binary dados) {
		this.dados = dados;
	}
}
