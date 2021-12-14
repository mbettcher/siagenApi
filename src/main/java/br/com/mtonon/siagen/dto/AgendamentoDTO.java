package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.mtonon.siagen.domain.Agendamento;

public class AgendamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private LocalDateTime dataAgendamento;
	private String addrAgendamento;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private boolean diaInteiro;
	private Integer statusEvento;
	private String titulo;
	private String descricao;
	private String chaveAgendamento;
	private LocalDateTime dataAlteracao;
	
	private Integer pacienteId;
	private String nomePaciente;
	private LocalDate dataNascimento;
	private String cpf;
	private String rg;
	private String cartaoSus;
	
	private Integer unidadeSaudeId;
	private String nomeUnidadeSaude;
	
	private Integer servicoId;
	private String nomeServico;
	private Integer tempoExecucao;
	private Integer idadeMinima;
	private Integer idadeMaxima;
	private Integer doseId;
	private String dose;
	private String nomeVacina;
	private String nomeLaboratorio;

	public AgendamentoDTO() {
	}
	
	public AgendamentoDTO(Agendamento obj) {
		this.id = obj.getId();
		this.addrAgendamento = obj.getAddrAgendamento();
		this.dataInicio = obj.getDataInicio();
		this.dataFim = obj.getDataFim();
		this.diaInteiro = obj.isDiaInteiro();
		this.statusEvento = obj.getStatusEvento().getCodigo();
		this.titulo = obj.getTitulo();
		this.descricao = obj.getDescricao();
		this.chaveAgendamento = obj.getChaveAgendamento();
		this.dataAlteracao = obj.getDataAlteracao();
		this.pacienteId = obj.getPacienteAgendamento().getId();
		this.nomePaciente = obj.getPacienteAgendamento().getNome();
		this.cpf = obj.getPacienteAgendamento().getCpf();
		this.rg = obj.getPacienteAgendamento().getRg();
		this.cartaoSus = obj.getPacienteAgendamento().getCartaoSus();
		this.unidadeSaudeId = obj.getUnidadeSaude().getId();
		this.nomeUnidadeSaude = obj.getUnidadeSaude().getNome();
		this.servicoId = obj.getServico().getId();
		this.nomeServico = obj.getServico().getDescricao();
		this.tempoExecucao = obj.getServico().getTempoExecucao();
		this.idadeMinima = obj.getServico().getIdadeMinima();
		this.idadeMaxima = obj.getServico().getIdadeMaxima();
		this.doseId = obj.getServico().getDose().getCodigo();
		this.dose = obj.getServico().getDose().getDescricao();
		this.nomeVacina = obj.getServico().getNomeVacina().getNomeVacina();
		this.nomeLaboratorio = obj.getServico().getNomeVacina().getLaboratorio();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
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

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
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

	public Integer getStatusEvento() {
		return statusEvento;
	}

	public void setStatusEvento(Integer statusEvento) {
		this.statusEvento = statusEvento;
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

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getCartaoSus() {
		return cartaoSus;
	}

	public void setCartaoSus(String cartaoSus) {
		this.cartaoSus = cartaoSus;
	}

	public Integer getUnidadeSaudeId() {
		return unidadeSaudeId;
	}

	public void setUnidadeSaudeId(Integer unidadeSaudeId) {
		this.unidadeSaudeId = unidadeSaudeId;
	}

	public String getNomeUnidadeSaude() {
		return nomeUnidadeSaude;
	}

	public void setNomeUnidadeSaude(String nomeUnidadeSaude) {
		this.nomeUnidadeSaude = nomeUnidadeSaude;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
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

	public Integer getDoseId() {
		return doseId;
	}

	public void setDoseId(Integer doseId) {
		this.doseId = doseId;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

	public void setNomeLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}
}
