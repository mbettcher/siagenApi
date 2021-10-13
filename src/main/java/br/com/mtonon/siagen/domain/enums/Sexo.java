package br.com.mtonon.siagen.domain.enums;

public enum Sexo {
	
	FEMININO(1, "Feminino"),
	MASCULINO(2, "Masculino"),
	NAODECLARADO(9, "Não Declarado");
	
	private int codigo;
	private String descricao;
	
	private Sexo(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static Sexo toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(Sexo x : Sexo.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + codigo);
	}

}
