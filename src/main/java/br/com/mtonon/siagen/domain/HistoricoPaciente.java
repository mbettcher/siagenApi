package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PastOrPresent;

@Entity(name = "historico_paciente")
public class HistoricoPaciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hpa_codigo")
	private Integer id;
	
	@Column(name = "hpa_data_historico")
	@PastOrPresent(message = "A data do histórico deve ser a data atual ou data pretérita")
	private LocalDateTime dataHistorico;
	
	@Column(name = "hpa_observacao", nullable = false)
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "hpa_paciente_codigo")
	private Paciente paciente;
	
	public HistoricoPaciente() {
	}

	public HistoricoPaciente(Integer id, LocalDateTime dataHistorico, String observacao, Paciente paciente) {
		super();
		this.id = id;
		this.dataHistorico = dataHistorico;
		this.observacao = observacao;
		this.paciente = paciente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public LocalDateTime getDataHistorico() {
		return dataHistorico;
	}

	public void setDataHistorico(LocalDateTime dataHistorico) {
		this.dataHistorico = dataHistorico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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
		HistoricoPaciente other = (HistoricoPaciente) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
