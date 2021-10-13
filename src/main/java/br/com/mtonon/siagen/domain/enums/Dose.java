package br.com.mtonon.siagen.domain.enums;

public enum Dose {
	
	PRIMEIRA(1, "Primeira Dose"), 
	SEGUNDA(2, "Segunda Dose"), 
	TERCEIRA(3, "Terceira Dose"), 
	QUARTA(4, "Quarta Dose"), 
	REFORÇO(5, "Reforço"), 
	NAOSEAPLICA(9, "Não se aplica");
	
	private int codigo;
	private String descricao;
	
	private Dose(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static Dose toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(Dose x : Dose.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + codigo);
	}

}
