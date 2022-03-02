package br.com.mtonon.siagen.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String cpf;
	private String senha;
	
	public CredenciaisDTO() {
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
