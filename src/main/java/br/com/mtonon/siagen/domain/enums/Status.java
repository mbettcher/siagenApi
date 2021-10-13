package br.com.mtonon.siagen.domain.enums;

public enum Status {
	
	ATIVO(1, "Ativo"), 
	INATIVO(2, "Inativo"), 
	SUSPENSO(3, "Suspenso"), 
	BLOQUEADO (4, "Bloqueado");
	
	private int codigo;
	private String descricao;
	
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static Status toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + codigo);	
	}
}
