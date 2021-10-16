package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "unidade_saude_endereco")
public class EnderecoUnidadeSaude implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "use_codigo")
	private Integer id;
	
	@Column(name = "use_logradouro")
	private String logradouro;
	
	@Column(name = "use_numero")
	private String numero;
	
	@Column(name = "use_complemento")
	private String complemento;
	
	@Column(name = "use_bairro")
	private String bairro;
	
	@Column(name = "use_cep")
	private String cep;

	@ManyToOne
	@JoinColumn(name = "use_cidade_codigo")
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name = "use_unidade_saude_codigo")
	private UnidadeSaude unidadeSaude;
	
	public EnderecoUnidadeSaude() {
	}

	public EnderecoUnidadeSaude(Integer id, String logradouro, String numero, String complemento, String bairro,
			String cep, Cidade cidade, UnidadeSaude unidadeSaude) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.unidadeSaude = unidadeSaude;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public UnidadeSaude getUnidadeSaude() {
		return unidadeSaude;
	}

	public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
		this.unidadeSaude = unidadeSaude;
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
		EnderecoUnidadeSaude other = (EnderecoUnidadeSaude) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
