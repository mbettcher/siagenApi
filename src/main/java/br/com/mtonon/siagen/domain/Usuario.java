package br.com.mtonon.siagen.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.mtonon.siagen.domain.enums.Status;

@Entity(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_codigo")
	private Integer id;
	
	@Column(name = "usu_nome", nullable = false, unique = true)
	private String nome;
	
	@Column(name = "usu_cpf", nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "usu_login", nullable = false)
	private String login;
	
	@Column(name = "usu_senha", nullable = false)
	private String senha;
	
	@Column(name = "usu_email", nullable = false)
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "usu_data_cadastramento")
	private LocalDateTime dataCadastramento;
	
	@Column(name = "usu_status")
	private Integer status;
	
	@Column(name = "usu_email_verificado", columnDefinition = "BOOLEAN", nullable = false)
	private boolean emailVerificado;
	
	@Column(name = "usu_codigo_validacao")
	private String codigoValidacao;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "usu_ultimo_acesso")
	private LocalDateTime dataUltimoAcesso;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "usu_data_alteracao")
	private LocalDateTime dataAlteracao;
	
	@ManyToOne
	@JoinColumn(name = "usu_perfil_codigo")
	private Perfil perfil;
	
	public Usuario() {
	}

	public Usuario(Integer id, String nome, String cpf, String login, String senha, String email,
			LocalDateTime dataCadastramento, Status status, boolean emailVerificado, String codigoValidacao,
			LocalDateTime dataUltimoAcesso, LocalDateTime dataAlteracao, Perfil perfil) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.dataCadastramento = dataCadastramento;
		this.status = status.getCodigo();
		this.emailVerificado = emailVerificado;
		this.codigoValidacao = codigoValidacao;
		this.dataUltimoAcesso = dataUltimoAcesso;
		this.dataAlteracao = dataAlteracao;
		this.perfil = perfil;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataCadastramento() {
		return dataCadastramento;
	}

	public void setDataCadastro(LocalDateTime dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	public Status getStatus() {
		return Status.toEnum(status);
	}

	public void setStatus(Status status) {
		this.status = status.getCodigo();
	}

	public boolean isEmailVerificado() {
		return emailVerificado;
	}

	public void setEmailVerificado(boolean emailVerificado) {
		this.emailVerificado = emailVerificado;
	}

	public String getCodigoValidacao() {
		return codigoValidacao;
	}

	public void setCodigoValidacao(String codigoValidacao) {
		this.codigoValidacao = codigoValidacao;
	}

	public LocalDateTime getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(LocalDateTime dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
