package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UnidadeSaudeNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Boolean ativo;
	
	@NotBlank(message = "O campo telefone é obrigatório!")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	@NotNull(message = "O campo especialidade é obrigatório!")
	private Integer especialidade1;
	private Integer especialidade2;
	private Integer especialidade3;
	private Integer especialidade4;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private Integer cidadeId;
	
	@NotNull(message = "O campo Serviço é obrigatório!")
	private Integer servico1;
	private Integer servico2;
	private Integer servico3;
	private Integer servico4;
	private Integer servico5;
	private Integer servico6;
	private Integer servico7;
	private Integer servico8;
	private Integer servico9;
	private Integer servico10;
	
	@NotNull(message = "O campo Dia de Funcionamento é obrigatório!")
	private Integer diaFuncionamento1;
	private Integer diaFuncionamento2;
	private Integer diaFuncionamento3;
	private Integer diaFuncionamento4;
	private Integer diaFuncionamento5;
	private Integer diaFuncionamento6;
	private Integer diaFuncionamento7;
	
	
	public UnidadeSaudeNewDTO() {
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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

	public Integer getEspecialidade1() {
		return especialidade1;
	}

	public void setEspecialidade1(Integer especialidade1) {
		this.especialidade1 = especialidade1;
	}

	public Integer getEspecialidade2() {
		return especialidade2;
	}

	public void setEspecialidade2(Integer especialidade2) {
		this.especialidade2 = especialidade2;
	}

	public Integer getEspecialidade3() {
		return especialidade3;
	}

	public void setEspecialidade3(Integer especialidade3) {
		this.especialidade3 = especialidade3;
	}

	public Integer getEspecialidade4() {
		return especialidade4;
	}

	public void setEspecialidade4(Integer especialidade4) {
		this.especialidade4 = especialidade4;
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

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public Integer getServico1() {
		return servico1;
	}

	public void setServico1(Integer servico1) {
		this.servico1 = servico1;
	}

	public Integer getServico2() {
		return servico2;
	}

	public void setServico2(Integer servico2) {
		this.servico2 = servico2;
	}

	public Integer getServico3() {
		return servico3;
	}

	public void setServico3(Integer servico3) {
		this.servico3 = servico3;
	}

	public Integer getServico4() {
		return servico4;
	}

	public void setServico4(Integer servico4) {
		this.servico4 = servico4;
	}

	public Integer getServico5() {
		return servico5;
	}

	public void setServico5(Integer servico5) {
		this.servico5 = servico5;
	}

	public Integer getServico6() {
		return servico6;
	}

	public void setServico6(Integer servico6) {
		this.servico6 = servico6;
	}

	public Integer getServico7() {
		return servico7;
	}

	public void setServico7(Integer servico7) {
		this.servico7 = servico7;
	}

	public Integer getServico8() {
		return servico8;
	}

	public void setServico8(Integer servico8) {
		this.servico8 = servico8;
	}

	public Integer getServico9() {
		return servico9;
	}

	public void setServico9(Integer servico9) {
		this.servico9 = servico9;
	}

	public Integer getServico10() {
		return servico10;
	}

	public void setServico10(Integer servico10) {
		this.servico10 = servico10;
	}

	public Integer getDiaFuncionamento1() {
		return diaFuncionamento1;
	}

	public void setDiaFuncionamento1(Integer diaFuncionamento1) {
		this.diaFuncionamento1 = diaFuncionamento1;
	}

	public Integer getDiaFuncionamento2() {
		return diaFuncionamento2;
	}

	public void setDiaFuncionamento2(Integer diaFuncionamento2) {
		this.diaFuncionamento2 = diaFuncionamento2;
	}

	public Integer getDiaFuncionamento3() {
		return diaFuncionamento3;
	}

	public void setDiaFuncionamento3(Integer diaFuncionamento3) {
		this.diaFuncionamento3 = diaFuncionamento3;
	}

	public Integer getDiaFuncionamento4() {
		return diaFuncionamento4;
	}

	public void setDiaFuncionamento4(Integer diaFuncionamento4) {
		this.diaFuncionamento4 = diaFuncionamento4;
	}

	public Integer getDiaFuncionamento5() {
		return diaFuncionamento5;
	}

	public void setDiaFuncionamento5(Integer diaFuncionamento5) {
		this.diaFuncionamento5 = diaFuncionamento5;
	}

	public Integer getDiaFuncionamento6() {
		return diaFuncionamento6;
	}

	public void setDiaFuncionamento6(Integer diaFuncionamento6) {
		this.diaFuncionamento6 = diaFuncionamento6;
	}

	public Integer getDiaFuncionamento7() {
		return diaFuncionamento7;
	}

	public void setDiaFuncionamento7(Integer diaFuncionamento7) {
		this.diaFuncionamento7 = diaFuncionamento7;
	}
}
