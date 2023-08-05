package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;

import br.com.mtonon.siagen.domain.enums.Dose;
import br.com.mtonon.siagen.domain.enums.Status;
import br.com.mtonon.siagen.domain.enums.StatusEvento;

@Entity
@Table(name = "agendamento", schema = "siagen_db")
public class Agendamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "age_codigo")
	private Integer id;
	
	@Column(name = "age_data_agendamento", nullable = false)
	@PastOrPresent(message = "A data da realização do agendamento deve ser o dia de hoje")
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
	
	/* Agendamento Muitos para Um Paciente*/
	@ManyToOne
	@JoinColumn(name = "age_paciente_codigo")
	private Paciente pacienteAgendamento;
	
	/* Muitos Agendamentos para Uma Unidade Saúde */
	@ManyToOne
	@JoinColumn(name = "age_unidade_saude_codigo")
	private UnidadeSaude unidadeSaude;
	
	@ManyToOne
	@JoinColumn(name = "age_servico_codigo")
	private Servico servico;

	public Agendamento() {
	}

	public Agendamento(Integer id, LocalDateTime dataAgendamento, String addrAgendamento, LocalDateTime dataInicio,
			LocalDateTime dataFim, boolean diaInteiro, Status status, String titulo, String descricao,
			String chaveAgendamento, LocalDateTime dataAlteracao, Paciente pacienteAgendamento, UnidadeSaude unidadeSaude,
			Servico servico) {
		this.id = id;
		this.dataAgendamento = dataAgendamento;
		this.addrAgendamento = addrAgendamento;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.diaInteiro = diaInteiro;
		this.statusEvento = (status == null) ? null : status.getCodigo();
		this.titulo = titulo;
		this.descricao = descricao;
		this.chaveAgendamento = chaveAgendamento;
		this.dataAlteracao = dataAlteracao;
		this.pacienteAgendamento = pacienteAgendamento;
		this.unidadeSaude = unidadeSaude;
		this.servico = servico;
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

	public Paciente getPacienteAgendamento() {
		return pacienteAgendamento;
	}

	public void setPacienteAgendamento(Paciente pacienteAgendamento) {
		this.pacienteAgendamento = pacienteAgendamento;
	}

	public UnidadeSaude getUnidadeSaude() {
		return unidadeSaude;
	}

	public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
		this.unidadeSaude = unidadeSaude;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
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

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		StringBuilder builder = new StringBuilder();
		builder.append("\nConfirmação de Agendamento\n");
		builder.append("Código do Agendamento: ");
		builder.append(id);
		builder.append(", Data do Agendamento: ");
		builder.append(getDataAgendamento().format(formatterDateTime));
		builder.append(", Paciente: ");
		builder.append(pacienteAgendamento.getNome());
		builder.append(", Data de Nascimento: ");
		builder.append(pacienteAgendamento.getDataNascimento().format(formatter));
		builder.append(", CPF: ");
		builder.append(pacienteAgendamento.getCpf());
		builder.append(", Cartão SUS: ");
		builder.append(pacienteAgendamento.getCartaoSus());
		builder.append(", Documento de Identidade: ");
		builder.append(pacienteAgendamento.getRg());
		builder.append(", Órgão Emissor: ");
		builder.append(pacienteAgendamento.getEmissor().getDescricao());
		builder.append("\nDetalhamento do Agendamento\n");
		builder.append("Tipo de Atendimento Agendado: ");
		builder.append(servico.getDescricao());
		builder.append(", Data: ");
		builder.append(dataInicio.toLocalDate().format(formatter));
		builder.append(", Hora: ");
		builder.append(dataInicio.toLocalTime());
		if(!servico.getDose().equals(Dose.NAOSEAPLICA)) {
			builder.append(", Nome do Laboratório: ");
			builder.append(servico.getNomeVacina().getLaboratorio());
			builder.append(", Nome da Vacina: ");
			builder.append(servico.getNomeVacina().getNomeVacina());
			builder.append(", Dose: ");
			builder.append(servico.getDose().getDescricao());
		}
		
		if(servico.getObservacoes() != null) {
			builder.append(", Informações Complementares: ");
			builder.append(servico.getObservacoes());
		}
		
		builder.append(", Local: ");
		builder.append(unidadeSaude.getNome());
		for(EnderecoUnidadeSaude end : unidadeSaude.getEnderecos()) {
			builder.append(", Endereço: ");
			builder.append(end.getLogradouro());
			builder.append(", Número: ");
			builder.append(end.getNumero());
			
			if(end.getComplemento() != null) {
				builder.append(", Complemento: ");
				builder.append(end.getComplemento());
			}
			
			builder.append(", Bairro: ");
			builder.append(end.getBairro());
			builder.append(", CEP: ");
			builder.append(end.getCep());
		}
		
		return builder.toString();
	}
	
	

}
