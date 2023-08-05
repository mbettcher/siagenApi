package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import br.com.mtonon.siagen.domain.Paciente;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@NotBlank(message = "O campo nome do paciente é obrigatório!")
	private String nome;

	@NotBlank(message = "O campo Cartão do SUS é obrigatório!")
	private String cartaoSus;

	@Past(message = "O campo Data de Nascimento deve ser uma data pretérita!")
	@NotNull(message = "O campo Data de Nascimento é obrigatório!")
	private LocalDate dataNascimento;

	@NotNull(message = "O campo Sexo é obrigatório!")
	private Integer sexo;

	@NotNull(message = "O campo Estado Civil é obrigatório!")
	private Integer estadoCivil;

	@NotBlank(message = "O campo E-mail é obrigatório!")
	@Email(message = "O E-mail informado não é válido!")
	private String email;

	@NotNull(message = "O campo Status é obrigatório!")
	private Integer status;

	@NotNull(message = "O campo Etnia é obrigatório!")
	private Integer etnia;


	public PacienteDTO() {
	}
	
	public PacienteDTO(Paciente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cartaoSus = obj.getCartaoSus();
		this.dataNascimento = obj.getDataNascimento();
		this.sexo = obj.getSexo().getCodigo();
		this.estadoCivil = obj.getEstadoCivil().getCodigo();
		this.email = obj.getEmail();
		this.status = obj.getStatus().getCodigo();
		this.etnia = obj.getEtnia().getCodigo();		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCartaoSus() {
		return cartaoSus;
	}

	public void setCartaoSus(String cartaoSus) {
		this.cartaoSus = cartaoSus;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getEtnia() {
		return etnia;
	}

	public void setEtnia(Integer etnia) {
		this.etnia = etnia;
	}

}
