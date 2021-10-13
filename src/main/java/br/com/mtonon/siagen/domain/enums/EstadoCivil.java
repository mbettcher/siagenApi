package br.com.mtonon.siagen.domain.enums;

public enum EstadoCivil {

	 SOLTEIRO(1, "Solteiro(a)"), 
	 CASADO(2, "Casado(a)"), 
	 DIVORCIADO(3, "Divorciado(a)"), 
	 VIUVO(4, "Viúvo(a)"), 
	 JUDICIALMENTESEPARADO(4, "Separado(a) Judicialmente"),
	 NAODECLARADO(9, "Não Declarado");
	
	private int codigo;
	private String descricao;
	
	private EstadoCivil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static EstadoCivil toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(EstadoCivil x : EstadoCivil.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + codigo);
	}
}
