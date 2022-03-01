package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.mtonon.siagen.domain.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nome;

	private String login;

	private String email;

	private LocalDateTime dataCadastramento;

	private Integer status;

	private boolean emailVerificado;

	private String codigoValidacao;

	private LocalDateTime dataUltimoAcesso;

	private LocalDateTime dataAlteracao;
	
	private Integer perfilId;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario obj) {
		this.nome = obj.getNome();
		this.login = obj.getLogin();
		this.email = obj.getEmail();
		this.dataCadastramento = obj.getDataCadastramento();
		this.status = obj.getStatus().getCodigo();
		this.emailVerificado = obj.isEmailVerificado();
		this.codigoValidacao = obj.getCodigoValidacao();
		this.dataUltimoAcesso = obj.getDataUltimoAcesso();
		this.dataAlteracao = obj.getDataAlteracao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public void setDataCadastramento(LocalDateTime dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

	
}
