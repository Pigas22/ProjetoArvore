package dados;


public class ItemCondominio {
	private int idCond;
	private String nomeCond;

	private String adm; 
	private String endereco = ""; // Opcional

	private int quantAP;
	private String strID;
	
	private EnumSituacaoCondominio situacaoCond = EnumSituacaoCondominio.SEM_CLASSIFICACAO;
	

	// Construtor sem Endereco
	public ItemCondominio(int idCond, String nomeCond, String adm, int quantAP) {
		this.idCond = idCond;
		this.nomeCond = nomeCond;
		
		this.adm = adm;
		this.quantAP = quantAP;
		
		this.strID = Integer.toString(this.getIdCond());
	}
	
	
	public ItemCondominio(int idCond, String nomeCond, String adm, int quantAP, int situacao) {
		this.idCond = idCond;
		this.nomeCond = nomeCond;
		
		this.adm = adm;
		this.quantAP = quantAP;
		
		this.strID = Integer.toString(this.getIdCond());
		this.setSituacaoCondominio(situacao);
	}
	
	
	// Construtor com Endereco
	public ItemCondominio(int idCond, String nomeCond, String adm, int quantAP, int situacao, String endereco) {
		this.idCond = idCond;
		this.nomeCond = nomeCond;
		
		this.adm = adm;
		this.endereco = endereco;
		
		this.quantAP = quantAP;
		this.strID = Integer.toString(this.getIdCond());
		
		this.setSituacaoCondominio(situacao);
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
		
	
	public EnumSituacaoCondominio getSituacaoCondominio() {
		return this.situacaoCond;
	}
	
	
	public void setSituacaoCondominio (int situacao) {
			switch (situacao) {
			case 1:
				this.situacaoCond = EnumSituacaoCondominio.PLANTA;
				break;
			
			case 2:
				this.situacaoCond = EnumSituacaoCondominio.A_VENDA;
				break;
				
			case 3:
				this.situacaoCond = EnumSituacaoCondominio.EDIFICADO;
				break;
				
			case 4:
				this.situacaoCond = EnumSituacaoCondominio.EM_CONSTRUCAO;
				break;
				
			default:
				this.situacaoCond = EnumSituacaoCondominio.SEM_CLASSIFICACAO;
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
