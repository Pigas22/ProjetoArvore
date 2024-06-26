package dados;

public enum SituacaoCondominio {
	PLANTA, 
	VENDENDO, 
	CONSTRUIDA, 
	CONSTRUINDO, 
	SEM_CLASSIFICACAO;
	
	private String situacaoNome;

	public String getValor() {
		return situacaoNome;
	}
	
	public static SituacaoCondominio valueOfTipo(String tipo) {
	    for (SituacaoCondominio enderecoTipo : values()) {
	        if (enderecoTipo.situacaoNome.equals(tipo)) {
	            return enderecoTipo;
	        }
	    }
	    return null;
	}	
}
