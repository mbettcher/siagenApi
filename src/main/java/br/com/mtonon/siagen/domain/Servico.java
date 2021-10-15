package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.mtonon.siagen.domain.enums.Dose;

@Entity(name = "servico")
public class Servico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ser_codigo")
	private Integer id;
	
	@Column(name = "ser_descricao", nullable = false, unique = true)
	private String descricao;
	
	@Column(name = "ser_tempo_execucao")
	private Integer tempoExecucao;
	
	@Column(name = "ser_idade_min")
	private Integer idadeMinima;
	
	@Column(name = "ser_idade_max")
	private Integer idadeMaxima;
	
	@Column(name = "ser_observacoes")
	private String observacoes;
	
	@Column(name = "ser_dose")
	private Integer dose;
	
	@ManyToOne
	@JoinColumn(name = "ser_nome_vacina_codigo")
	private NomeVacina nomeVacina;
	
	@ManyToOne
	@JoinColumn(name = "ser_tipo_servico_codigo")
	@JsonManagedReference
	private TipoServico tipoServico;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "servicos")
	private List<UnidadeSaude> unidadesSaude = new ArrayList<>();
	
	public Servico() {
	}

	public Servico(Integer id, String descricao, Integer tempoExecucao, Integer idadeMinima, Integer idadeMaxima,
			String observacoes, Dose dose, NomeVacina nomeVacina, TipoServico tipoServico) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tempoExecucao = tempoExecucao;
		this.idadeMinima = idadeMinima;
		this.idadeMaxima = idadeMaxima;
		this.observacoes = observacoes;
		this.dose = dose.getCodigo();
		this.nomeVacina = nomeVacina;
		this.tipoServico = tipoServico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(Integer tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public Integer getIdadeMinima() {
		return idadeMinima;
	}

	public void setIdadeMinima(Integer idadeMinima) {
		this.idadeMinima = idadeMinima;
	}

	public Integer getIdadeMaxima() {
		return idadeMaxima;
	}

	public void setIdadeMaxima(Integer idadeMaxima) {
		this.idadeMaxima = idadeMaxima;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Dose getDose() {
		return Dose.toEnum(this.dose);
	}

	public void setDose(Dose dose) {
		this.dose = dose.getCodigo();
	}

	public NomeVacina getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(NomeVacina nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public List<UnidadeSaude> getUnidadesSaude() {
		return unidadesSaude;
	}

	public void setUnidadesSaude(List<UnidadeSaude> unidadesSaude) {
		this.unidadesSaude = unidadesSaude;
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
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}

}
