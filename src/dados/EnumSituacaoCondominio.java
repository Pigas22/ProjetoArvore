package dados;

public enum EnumSituacaoCondominio {
	PLANTA ("Planta"), 
	A_VENDA ("À Venda"),
	EDIFICADO ("Edificado"),
	EM_CONSTRUCAO ("Em Construção"),
	SEM_CLASSIFICACAO ("Sem Classificação");
	
	private EnumSituacaoCondominio(String situacao) {
		this.situacao = situacao;
	}
	
	private String situacao;

	public String getValor() {
		return situacao;
	}
	
	public static EnumSituacaoCondominio valueOfTipo(String tipo) {
	    for (EnumSituacaoCondominio enderecoTipo : values()) {
	        if (enderecoTipo.situacao.equals(tipo)) {
	            return enderecoTipo;
	        }
	    }
	    return null;
	}	
	
}
