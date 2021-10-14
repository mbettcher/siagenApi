package br.com.mtonon.siagen.domain.enums;

public enum StatusEvento {
	
	PADRAO(1, "Padrão",""),
	URGENTE(2, "Urgente","urgente"),
	CANCELADO(3, "Cancelado","cancelado"),
	ATENDIDO(4, "Atendido","atendido");
	
	private int codigo;
	private String descricao;
	private String css;
	
	private StatusEvento(Integer codigo, String descricao, String css) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.css = css;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String getCss() {
		return this.css;
	}
	
	public static StatusEvento toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(StatusEvento x : StatusEvento.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + codigo);
		
	}

}
