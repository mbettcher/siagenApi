package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.mtonon.siagen.domain.enums.Emissor;
import br.com.mtonon.siagen.domain.enums.EstadoCivil;
import br.com.mtonon.siagen.domain.enums.Etnia;
import br.com.mtonon.siagen.domain.enums.Sexo;
import br.com.mtonon.siagen.domain.enums.Status;

@Entity(name = "paciente")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pac_codigo")
	private Integer id;
	
	@Column(name = "pac_nome", nullable = false)
	private String nome;
	
	@Column(name = "pac_cpf", nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "pac_rg", nullable = false, unique = true)
	private String rg;
	
	@Column(name = "pac_emissor")
	private Integer emissor;
	
	@Column(name = "pac_cartao_sus")
	private String cartaoSus;
	
	@Column(name = "pac_data_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "pac_sexo")
	private Integer sexo;
	
	@Column(name = "pac_estado_civil")
	private Integer estadoCivil;
	
	@Column(name = "pac_email")
	private String email;
	
	@Column(name = "pac_data_cadastro")
	private LocalDateTime dataCadastro;	
	
	@Column(name = "pac_data_alteracao")
	private LocalDateTime dataAlteracao;
	
	@Column(name = "pac_status")
	private Integer status;
	
	@Column(name = "pac_ipaddr_alteracao")
	private String ipAddrAlteracao;
	
	@Column(name = "pac_etnia")
	private Integer etnia;
	
	/* Um Paciente tem Um ou Muitos Enderecos */
	@OneToMany(mappedBy = "paciente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	/* Um Paciente tem uma coleção de Telefones */
	@ElementCollection
	@CollectionTable(name = "paciente_telefone")
	private Set<String> telefones = new HashSet<>();
	
	/* Um Paciente tem muitos Agendamentos */
	@OneToMany(mappedBy = "pacienteAgendamento")
	private List<Agendamento> agendamentos = new ArrayList<>();
	
	public Paciente() {
	}

	public Paciente(Integer id, String nome, String cpf, String rg, Emissor emissor, String cartaoSus,
			LocalDate dataNascimento, Sexo sexo, EstadoCivil estadoCivil, String email, LocalDateTime dataCadastro,
			LocalDateTime dataAlteracao, Status status, String ipAddrAlteracao, Etnia etnia) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.emissor = emissor.getCodigo();
		this.cartaoSus = cartaoSus;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo.getCodigo();
		this.estadoCivil = estadoCivil.getCodigo();
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.dataAlteracao = dataAlteracao;
		this.status = status.getCodigo();
		this.ipAddrAlteracao = ipAddrAlteracao;
		this.etnia = etnia.getCodigo();
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Emissor getEmissor() {
		return Emissor.toEnum(emissor);
	}

	public void setEmissor(Emissor emissor) {
		this.emissor = emissor.getCodigo();
	}

	public String getCartaoSus() {
		return cartaoSus;
	}

	public void setCartaoSus(String cartaoSus) {
		this.cartaoSus = cartaoSus;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return Sexo.toEnum(sexo);
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo.getCodigo();
	}

	public EstadoCivil getEstadoCivil() {
		return EstadoCivil.toEnum(estadoCivil);
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil.getCodigo();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Status getStatus() {
		return Status.toEnum(status);
	}

	public void setStatus(Status status) {
		this.status = status.getCodigo();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	public String getIpAddrAlteracao() {
		return ipAddrAlteracao;
	}

	public void setIpAddrAlteracao(String ipAddrAlteracao) {
		this.ipAddrAlteracao = ipAddrAlteracao;
	}
	
	public Etnia getEtnia() {
		return Etnia.toEnum(etnia);
	}

	public void setEtnia(Etnia etnia) {
		this.etnia = etnia.getCodigo();
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
		Paciente other = (Paciente) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
