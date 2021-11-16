package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.mtonon.siagen.domain.PerguntaResposta;

public class PerguntaRespostaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	@NotBlank(message = "O campo pergunta é de preenchimento obrigatório!")
	private String pergunta;
	
	@NotBlank(message = "O campo resposta é de preenchimento obrigatório!")
	private String resposta;
	
	public PerguntaRespostaDTO() {
	}

	public PerguntaRespostaDTO(PerguntaResposta obj) {
		this.id = obj.getId();
		this.pergunta = obj.getPergunta();
		this.resposta = obj.getResposta();
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
}
