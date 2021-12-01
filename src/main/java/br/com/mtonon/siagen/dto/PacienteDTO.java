package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@NotBlank(message = "O campo nome do paciente é obrigatório!")
	private String nome;

	@CPF(message = "O número informado para o CPF não é válido")
	@NotBlank(message = "O campo CPF é obrigatório!")
	private String cpf;

	@NotBlank(message = "O campo RG é obrigatório!")
	private String rg;

	@NotNull(message = "O campo Emissor do RG é obrigatório!")
	private Integer emissor;

	@NotBlank(message = "O campo Cartão do SUS é obrigatório!")
	private String cartaoSus;

	@Past(message = "O campo Data de Nascimento deve ser uma data pretérita!")
	@NotBlank(message = "O campo Data de Nascimento é obrigatório!")
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

	@NotBlank(message = "O campo Endereco IP é obrigatório!")
	private String ipAddrAlteracao;

	@NotNull(message = "O campo Etnia é obrigatório!")
	private Integer etnia;

	@NotNull(message = "O campo Logradouro é obrigatório!")
	private Integer logradouro;

	@NotNull(message = "O campo Cidade é obrigatório!")
	private Integer cidadeId;

	@NotBlank(message = "O campo Telefone é obrigatório!")
	private String telefone1;

	private String telefone2;

	private String telefone3;

	private Integer historicoPaciente;

	private Integer agendamento;

	public PacienteDTO() {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Integer getEmissor() {
		return emissor;
	}

	public void setEmissor(Integer emissor) {
		this.emissor = emissor;
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

	public String getIpAddrAlteracao() {
		return ipAddrAlteracao;
	}

	public void setIpAddrAlteracao(String ipAddrAlteracao) {
		this.ipAddrAlteracao = ipAddrAlteracao;
	}

	public Integer getEtnia() {
		return etnia;
	}

	public void setEtnia(Integer etnia) {
		this.etnia = etnia;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public Integer getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Integer logradouro) {
		this.logradouro = logradouro;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getHistoricoPaciente() {
		return historicoPaciente;
	}

	public void setHistoricoPaciente(Integer historicoPaciente) {
		this.historicoPaciente = historicoPaciente;
	}

	public Integer getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Integer agendamento) {
		this.agendamento = agendamento;
	}
}
