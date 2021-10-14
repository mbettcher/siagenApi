package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;

import br.com.mtonon.siagen.domain.enums.StatusEvento;

@Entity(name = "agendamento")
public class Agendamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "age_codigo")
	private Integer id;
	
	@Column(name = "age_data_agendamento", nullable = false)
	@FutureOrPresent(message = "A data da realização do agendamento deve ser o dia de hoje")
	private LocalDateTime dataAgendamento;
	
	@Column(name = "age_addr_agendamento", nullable = false)
	private String addrAgendamento;
	
	@Column(name = "age_data_inicio", nullable = false)
	@FutureOrPresent(message = "A data do início do agendamento deve ser o dia de hoje ou data futura")
	private LocalDateTime dataInicio;
	
	@Column(name = "age_data_fim", nullable = false)
	@FutureOrPresent(message = "A data do término do agendamento deve ser o dia de hoje ou data futura")
	private LocalDateTime dataFim;
	
	@Column(name = "age_dia_inteiro", columnDefinition = "BOOLEAN", nullable = false)
	private boolean diaInteiro;
	
	@Column(name = "age_status_agendamento", nullable = false)
	private Integer statusEvento;
	
	@Column(name = "age_titulo_agendamento")
	private String titulo;
	
	@Column(name = "age_descricao_agendamento")
	private String descricao;
	
	@Column(name = "age_chave_agendamento", nullable = false)
	private String chaveAgendamento;
	
	@Column(name = "age_data_alteracao")
	@FutureOrPresent(message = "A data de alteração do agendamento deve ser o dia de hoje ou data futura")
	private LocalDateTime dataAlteracao;

	public Agendamento() {
	}

	public Agendamento(Integer id, LocalDateTime dataAgendamento, String addrAgendamento, LocalDateTime dataInicio,
			LocalDateTime dataFim, boolean diaInteiro, StatusEvento statusEvento, String titulo, String descricao,
			String chaveAgendamento, LocalDateTime dataAlteracao) {
		super();
		this.id = id;
		this.dataAgendamento = dataAgendamento;
		this.addrAgendamento = addrAgendamento;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.diaInteiro = diaInteiro;
		this.statusEvento = statusEvento.getCodigo();
		this.titulo = titulo;
		this.descricao = descricao;
		this.chaveAgendamento = chaveAgendamento;
		this.dataAlteracao = dataAlteracao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDateTime dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getAddrAgendamento() {
		return addrAgendamento;
	}

	public void setAddrAgendamento(String addrAgendamento) {
		this.addrAgendamento = addrAgendamento;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isDiaInteiro() {
		return diaInteiro;
	}

	public void setDiaInteiro(boolean diaInteiro) {
		this.diaInteiro = diaInteiro;
	}

	public StatusEvento getStatusEvento() {
		return StatusEvento.toEnum(this.statusEvento);
	}

	public void setStatusEvento(StatusEvento statusEvento) {
		this.statusEvento = statusEvento.getCodigo();
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

	public String getChaveAgendamento() {
		return chaveAgendamento;
	}

	public void setChaveAgendamento(String chaveAgendamento) {
		this.chaveAgendamento = chaveAgendamento;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
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
		Agendamento other = (Agendamento) obj;
		return Objects.equals(id, other.id);
	}

}
