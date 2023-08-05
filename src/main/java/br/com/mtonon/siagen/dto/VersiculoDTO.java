package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.mtonon.siagen.domain.Versiculo;

public class VersiculoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message = "O campo Livro é de preenchimento obrigatório!")
	private String livro;
	
	@NotBlank(message = "O campo Versículo é de preenchimento obrigatório!")
	private String versiculo;
	
	public VersiculoDTO() {
	}

	public VersiculoDTO(Versiculo obj) {
		this.id = obj.getId();
		this.livro = obj.getLivro();
		this.versiculo = obj.getVersiculo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public String getVersiculo() {
		return versiculo;
	}

	public void setVersiculo(String versiculo) {
		this.versiculo = versiculo;
	}
}
