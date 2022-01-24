package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pergunta", schema = "siagen_db")
public class PerguntaResposta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "per_codigo")
	private Integer id;
	
	@Column(name = "per_pergunta", nullable = false)
	private String pergunta;
	
	@Column(name = "per_resposta", nullable = false)
	private String resposta;
	
	public PerguntaResposta() {
	}

	public PerguntaResposta(Integer id, String pergunta, String resposta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
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
		PerguntaResposta other = (PerguntaResposta) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
