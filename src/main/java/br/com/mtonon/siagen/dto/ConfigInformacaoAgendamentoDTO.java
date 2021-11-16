package br.com.mtonon.siagen.dto;

import javax.validation.constraints.NotBlank;

import br.com.mtonon.siagen.domain.ConfigInformacaoAgendamento;

public class ConfigInformacaoAgendamentoDTO {

	private Integer id;

	private boolean ativo;
	
	@NotBlank(message = "O campo Título é de preenchimento obrigatório!")
	private String titulo;

	@NotBlank(message = "O campo Descrição é de preenchimento obrigatório!")
	private String descricao;

	private String complementar;
	private String informacao1;
	private String informacao2;
	private String informacao3;
	private String informacao4;
	private String informacao5;
	private String informacao6;
	private String informacao7;
	private String informacao8;
	private String informacao9;
	private String informacao10;
	private boolean informacaoVisivel1;
	private boolean informacaoVisivel2;
	private boolean informacaoVisivel3;
	private boolean informacaoVisivel4;
	private boolean informacaoVisivel5;
	private boolean informacaoVisivel6;
	private boolean informacaoVisivel7;
	private boolean informacaoVisivel8;
	private boolean informacaoVisivel9;
	private boolean informacaoVisivel10;
	
	public ConfigInformacaoAgendamentoDTO() {
	}

	public ConfigInformacaoAgendamentoDTO(ConfigInformacaoAgendamento obj) {
		this.id = obj.getId();
		this.ativo = obj.isAtivo();
		this.titulo = obj.getTitulo();
		this.descricao = obj.getDescricao();
		this.complementar = obj.getComplementar();
		this.informacao1 = obj.getInformacao1();
		this.informacao2 = obj.getInformacao2();
		this.informacao3 = obj.getInformacao3();
		this.informacao4 = obj.getInformacao4();
		this.informacao5 = obj.getInformacao5();
		this.informacao6 = obj.getInformacao6();
		this.informacao7 = obj.getInformacao7();
		this.informacao8 = obj.getInformacao8();
		this.informacao9 = obj.getInformacao9();
		this.informacao10 = obj.getInformacao10();
		this.informacaoVisivel1 = obj.isInformacaoVisivel1();
		this.informacaoVisivel2 = obj.isInformacaoVisivel2();
		this.informacaoVisivel3 = obj.isInformacaoVisivel3();
		this.informacaoVisivel4 = obj.isInformacaoVisivel4();
		this.informacaoVisivel5 = obj.isInformacaoVisivel5();
		this.informacaoVisivel6 = obj.isInformacaoVisivel6();
		this.informacaoVisivel7 = obj.isInformacaoVisivel7();
		this.informacaoVisivel8 = obj.isInformacaoVisivel8();
		this.informacaoVisivel9 = obj.isInformacaoVisivel9();
		this.informacaoVisivel10 = obj.isInformacaoVisivel10();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComplementar() {
		return complementar;
	}

	public void setComplementar(String complementar) {
		this.complementar = complementar;
	}

	public String getInformacao1() {
		return informacao1;
	}

	public void setInformacao1(String informacao1) {
		this.informacao1 = informacao1;
	}

	public String getInformacao2() {
		return informacao2;
	}

	public void setInformacao2(String informacao2) {
		this.informacao2 = informacao2;
	}

	public String getInformacao3() {
		return informacao3;
	}

	public void setInformacao3(String informacao3) {
		this.informacao3 = informacao3;
	}

	public String getInformacao4() {
		return informacao4;
	}

	public void setInformacao4(String informacao4) {
		this.informacao4 = informacao4;
	}

	public String getInformacao5() {
		return informacao5;
	}

	public void setInformacao5(String informacao5) {
		this.informacao5 = informacao5;
	}

	public String getInformacao6() {
		return informacao6;
	}

	public void setInformacao6(String informacao6) {
		this.informacao6 = informacao6;
	}

	public String getInformacao7() {
		return informacao7;
	}

	public void setInformacao7(String informacao7) {
		this.informacao7 = informacao7;
	}

	public String getInformacao8() {
		return informacao8;
	}

	public void setInformacao8(String informacao8) {
		this.informacao8 = informacao8;
	}

	public String getInformacao9() {
		return informacao9;
	}

	public void setInformacao9(String informacao9) {
		this.informacao9 = informacao9;
	}

	public String getInformacao10() {
		return informacao10;
	}

	public void setInformacao10(String informacao10) {
		this.informacao10 = informacao10;
	}

	public boolean isInformacaoVisivel1() {
		return informacaoVisivel1;
	}

	public void setInformacaoVisivel1(boolean informacaoVisivel1) {
		this.informacaoVisivel1 = informacaoVisivel1;
	}

	public boolean isInformacaoVisivel2() {
		return informacaoVisivel2;
	}

	public void setInformacaoVisivel2(boolean informacaoVisivel2) {
		this.informacaoVisivel2 = informacaoVisivel2;
	}

	public boolean isInformacaoVisivel3() {
		return informacaoVisivel3;
	}

	public void setInformacaoVisivel3(boolean informacaoVisivel3) {
		this.informacaoVisivel3 = informacaoVisivel3;
	}

	public boolean isInformacaoVisivel4() {
		return informacaoVisivel4;
	}

	public void setInformacaoVisivel4(boolean informacaoVisivel4) {
		this.informacaoVisivel4 = informacaoVisivel4;
	}

	public boolean isInformacaoVisivel5() {
		return informacaoVisivel5;
	}

	public void setInformacaoVisivel5(boolean informacaoVisivel5) {
		this.informacaoVisivel5 = informacaoVisivel5;
	}

	public boolean isInformacaoVisivel6() {
		return informacaoVisivel6;
	}

	public void setInformacaoVisivel6(boolean informacaoVisivel6) {
		this.informacaoVisivel6 = informacaoVisivel6;
	}

	public boolean isInformacaoVisivel7() {
		return informacaoVisivel7;
	}

	public void setInformacaoVisivel7(boolean informacaoVisivel7) {
		this.informacaoVisivel7 = informacaoVisivel7;
	}

	public boolean isInformacaoVisivel8() {
		return informacaoVisivel8;
	}

	public void setInformacaoVisivel8(boolean informacaoVisivel8) {
		this.informacaoVisivel8 = informacaoVisivel8;
	}

	public boolean isInformacaoVisivel9() {
		return informacaoVisivel9;
	}

	public void setInformacaoVisivel9(boolean informacaoVisivel9) {
		this.informacaoVisivel9 = informacaoVisivel9;
	}

	public boolean isInformacaoVisivel10() {
		return informacaoVisivel10;
	}

	public void setInformacaoVisivel10(boolean informacaoVisivel10) {
		this.informacaoVisivel10 = informacaoVisivel10;
	}
}
