package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "versiculo", schema = "siagen_db")
public class Versiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ver_codigo")
	private Integer id;
	
	@Column(name = "ver_livro")
	private String livro;
	
	@Column(name = "ver_mensagem")
	private String versiculo;
	
	public Versiculo() {
	}

	public Versiculo(Integer id, String livro, String versiculo) {
		super();
		this.id = id;
		this.livro = livro;
		this.versiculo = versiculo;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Versiculo other = (Versiculo) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
