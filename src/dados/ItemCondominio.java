package dados;


public class ItemCondominio {
	private int idCond;
	private String nomeCond;

	private String adm; 
	private String endereco = ""; // Opcional

	private int quantAP;
	private String strID;
	
	private SituacaoCondominio situacaoCond;
	

	// Construtor sem Endereco
	public ItemCondominio(int idCond, String nomeCond, String adm, int quantAP, int situacao) {
		this.idCond = idCond;
		this.nomeCond = nomeCond;
		
		this.adm = adm;
		this.quantAP = quantAP;
		
		this.strID = Integer.toString(this.getIdCond());
		
		switch (situacao) {
			case 1:
				this.situacaoCond = SituacaoCondominio.PLANTA;
				break;
			
			case 2:
				this.situacaoCond = SituacaoCondominio.VENDENDO;
				break;
				
			case 3:
				this.situacaoCond = SituacaoCondominio.CONSTRUIDA;
				break;
				
			case 4:
				this.situacaoCond = SituacaoCondominio.CONSTRUINDO;
				break;
				
			default:
				this.situacaoCond = SituacaoCondominio.SEM_CLASSIFICACAO;
		}
	}
	
	
	// Construtor com Endereco
	public ItemCondominio(int idCond, String nomeCond, String adm, int quantAP, int situacao, String endereco) {
		this.idCond = idCond;
		this.nomeCond = nomeCond;
		
		this.adm = adm;
		this.endereco = endereco;
		
		this.quantAP = quantAP;
		this.strID = Integer.toString(this.getIdCond());
		
		switch (situacao) {
			case 1:
				this.situacaoCond = SituacaoCondominio.PLANTA;
				break;
			
			case 2:
				this.situacaoCond = SituacaoCondominio.VENDENDO;
				break;
				
			case 3:
				this.situacaoCond = SituacaoCondominio.CONSTRUIDA;
				break;
				
			case 4:
				this.situacaoCond = SituacaoCondominio.CONSTRUINDO;
				break;
				
			default:
				this.situacaoCond = SituacaoCondominio.SEM_CLASSIFICACAO;
		}
	}
	
	
	@Override
    public String toString() {
        return "EntidadeCondominio{"
        		+ "\n		id= " + idCond + ";"
        		+ "\n		nomeCond= " + nomeCond + ";"
        		+ "\n		adm= " + adm + ";"
        		+ "\n		endereco= " + endereco + ";"
        		+ "\n		quantAP= " + quantAP + ";"
        		+ "\n		situacaoCond= " + situacaoCond.toString() + ";"
        		+ "}";

    }
	
	
	public int getIdCond() {
		return this.idCond;
	}

	
	public String getStrID() {
		return this.strID;
	}
		
	
	public SituacaoCondominio getSituacaoCondominio() {
		return this.situacaoCond;
	}
	public void setSituacaoCondominio (int situacao) {
			switch (situacao) {
			case 1:
				this.situacaoCond = SituacaoCondominio.PLANTA;
				break;
			
			case 2:
				this.situacaoCond = SituacaoCondominio.VENDENDO;
				break;
				
			case 3:
				this.situacaoCond = SituacaoCondominio.CONSTRUIDA;
				break;
				
			case 4:
				this.situacaoCond = SituacaoCondominio.CONSTRUINDO;
				break;
				
			default:
				this.situacaoCond = SituacaoCondominio.SEM_CLASSIFICACAO;
		}
	}
	
	
	public String getNomeCond() {
		return this.nomeCond;
	}
	public void setNomeCond(String nomeCond) {
		this.nomeCond = nomeCond;
	}
	
	
	public String getAdm() {
		return adm;
	}
	public void setAdm(String adm) {
		this.adm = adm;
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public int getQuantAP() {
		return quantAP;
	}
	public void setQuantAP(int quantAP) {
		this.quantAP = quantAP;
	}
	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}
