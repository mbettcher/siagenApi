package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "config_informacao_agendamento")
public class ConfigInformacaoAgendamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cin_codigo")
	private Integer id;
	
	@Column(name = "cin_ativo", columnDefinition = "boolean default false")
	private boolean ativo;
	
	@Column(name = "cin_titulo", nullable = false)
	private String titulo;
	
	@Column(name = "cin_descricao", nullable = false)
	private String descricao;
	
	@Column(name = "cin_complementar")
	private String complementar;
	
	@Column(name = "cin_informacao1", nullable = false)
	private String informacao1;
	
	@Column(name = "cin_informacao2")
	private String informacao2;
	
	@Column(name = "cin_informacao3")
	private String informacao3;
	
	@Column(name = "cin_informacao4")
	private String informacao4;
	
	@Column(name = "cin_informacao5")
	private String informacao5;
	
	@Column(name = "cin_informacao6")
	private String informacao6;
	
	@Column(name = "cin_informacao7")
	private String informacao7;
	
	@Column(name = "cin_informacao8")
	private String informacao8;
	
	@Column(name = "cin_informacao9")
	private String informacao9;
	
	@Column(name = "cin_informacao10")
	private String informacao10;
	
	@Column(name = "cin_informacao1_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel1;
	
	@Column(name = "cin_informacao2_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel2;
	
	@Column(name = "cin_informacao3_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel3;
	
	@Column(name = "cin_informacao4_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel4;
	
	@Column(name = "cin_informacao5_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel5;
	
	@Column(name = "cin_informacao6_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel6;
	
	@Column(name = "cin_informacao7_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel7;
	
	@Column(name = "cin_informacao8_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel8;
	
	@Column(name = "cin_informacao9_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel9;
	
	@Column(name = "cin_informacao10_visivel", columnDefinition = "boolean default false")
	private boolean informacaoVisivel10;
	
	public ConfigInformacaoAgendamento() {
	}

	public ConfigInformacaoAgendamento(Integer id, boolean ativo, String titulo, String descricao, String informacao1,
			String complementar, String informacao2, String informacao3, String informacao4, String informacao5, String informacao6,
			String informacao7, String informacao8, String informacao9, String informacao10, boolean informacaoVisivel1,
			boolean informacaoVisivel2, boolean informacaoVisivel3, boolean informacaoVisivel4,
			boolean informacaoVisivel5, boolean informacaoVisivel6, boolean informacaoVisivel7,
			boolean informacaoVisivel8, boolean informacaoVisivel9, boolean informacaoVisivel10) {
		super();
		this.id = id;
		this.ativo = ativo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.complementar = complementar;
		this.informacao1 = informacao1;
		this.informacao2 = informacao2;
		this.informacao3 = informacao3;
		this.informacao4 = informacao4;
		this.informacao5 = informacao5;
		this.informacao6 = informacao6;
		this.informacao7 = informacao7;
		this.informacao8 = informacao8;
		this.informacao9 = informacao9;
		this.informacao10 = informacao10;
		this.informacaoVisivel1 = informacaoVisivel1;
		this.informacaoVisivel2 = informacaoVisivel2;
		this.informacaoVisivel3 = informacaoVisivel3;
		this.informacaoVisivel4 = informacaoVisivel4;
		this.informacaoVisivel5 = informacaoVisivel5;
		this.informacaoVisivel6 = informacaoVisivel6;
		this.informacaoVisivel7 = informacaoVisivel7;
		this.informacaoVisivel8 = informacaoVisivel8;
		this.informacaoVisivel9 = informacaoVisivel9;
		this.informacaoVisivel10 = informacaoVisivel10;
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
		ConfigInformacaoAgendamento other = (ConfigInformacaoAgendamento) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
