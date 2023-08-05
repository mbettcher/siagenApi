package br.com.mtonon.siagen.domain.enums;

public enum Perfil {
	ADMIN(1, "ROLE_ADMIN"),
	GERENTE(2, "ROLE_GERENTE"),
	ANALISTA(3, "ROLE_ANALISTA"),
	OPERADOR(4, "ROLE_OPERADOR"),
	PACIENTE(5, "ROLE_PACIENTE");
	
	private int codigo;
	private String descricao;
	
	private Perfil(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static Perfil toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(codigo.equals(x.codigo)) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + codigo);
	}
	
}
