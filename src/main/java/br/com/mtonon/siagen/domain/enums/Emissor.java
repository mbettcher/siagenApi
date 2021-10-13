package br.com.mtonon.siagen.domain.enums;

public enum Emissor {
	
	CBM(1, "CBM – Corpo de Bombeiros Militar"),
    COFEN(2, "COFEN – Conselho Federal de Enfermagem"), 
    CONRE(3, "CONRE – Conselho Regional de Estatística"),
    CONRERP(4, "CONRERP – Conselho Regional de Profissionais de Relações Públicas"),
    CORE(5, "CORE – Conselho Regional de Representantes Comerciais"),
    CORECON(6, "CORECON – Conselho Regional de Economia"),
    COREN(7, "COREN – Conselho Regional de Enfermagem"),
    CRA(8, "CRA – Conselho Regional de Administração"),
    CRAS(9, "CRAS – Conselho Regional de Assistência Social"),
    CRB(10, "CRB – Conselho Regional de Biblioteconomia"),
    CRC(11, "CRC – Conselho Regional de Contabilidade"),
    CRCPN(12, "CRCPN - Cartório de Regitro Civil de Pessoas Naturais"),
    CREA(13, "CREA – Conselho Regional de Engenharia, Arquitetura e Agronomia"),
    CRECI(14, "CRECI – Conselho Regional de Corretores de Imóveis"),
    CREFITO(15, "CREFITO – Conselho Regional de Fisioterapia e Terapia Ocupacional"),
    CRF(16, "CRF – Conselho Regional de Farmácia"),
    CRM(17, "CRM – Conselho Regional de Medicina"),
    CRMV(18, "CRMV – Conselho Regional de Medicina Veterinária"),
    CRN(19, "CRN – Conselho Regional de Nutrição"),
    CRO(20, "CRO – Conselho Regional de Odontologia"),
    CRP(21, "CRP – Conselho Regional de Psicologia"),
    CRQ(22, "CRQ – Conselho Regional de Química"),
    DE(23, "Documento Estrangeiro"),
    DETRAN(24, "DETRAN – Departamento de Trânsito"),
    MA(25, "MA – Ministério da Aeronáutica"),
    MD(26, "MD – Ministério da Defesa"),
    ME(27, "ME – Ministério do Exército"),
    MM(28, "MM – Ministério da Marinha"),
    MT(29, "MT – Ministério do Trabalho"),
    OAB(30, "OAB – Ordem dos Advogados do Brasil"),
    OMB(31, "OMB – Ordem dos Músicos do Brasil"),
    OE(32, "Outros Emissores"),
    PC(33, "PC – Polícia Civil"),
    PF(34, "PF – Polícia Federal"),
    PM(35, "PM – Polícia Militar"),
    SESP(36, "SESP – Secretaria da Segurança Pública e Defesa Social"),
    SPTC(37, "SPTC – Superintendência da Polícia Técnico Científica"),
    SSP(38, "SSP – Secretaria de Segurança Pública"),
    NAODECLARADO(99, "Não declarado");
	
	private int codigo;
	private String descricao;
	
	private Emissor(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static Emissor toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(Emissor x : Emissor.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + codigo);
	}

}
