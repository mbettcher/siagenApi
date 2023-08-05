package br.com.mtonon.siagen.domain.enums;

public enum Etnia {
	
	BRANCO(1,"Branco"), 
	PARDO(2, "Pardo"), 
	PRETO(3, "Preto"), 
	INDIGENA(4, "Indígena"), 
	AMARELO(5, "Amarelo"),
	NAODECLARADO(9, "Não Declarado");
	
	private int codigo;
	private String descricao;
	
	private Etnia(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static Etnia toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(Etnia x : Etnia.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + codigo);
	}

}
