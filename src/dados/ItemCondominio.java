package dados;


public class ItemCondominio {
	private int idCond;
	private String nomeCond;

	private String adm; 
	private String endereco = ""; // Opcional

	private int quantAP;
	private String strID;
	

	// Construtor sem Endereco
	public ItemCondominio(int idCond, String nomeCond, String adm, int quantAP) {
		this.idCond = idCond;
		this.nomeCond = nomeCond;
		
		this.adm = adm;
		this.quantAP = quantAP;
		
		this.strID = Integer.toString(this.getIdCond());
	}
	
	
	// Construtor com Endereco
	public ItemCondominio(int idCond, String nomeCond, String adm, int quantAP, String endereco) {
		this.idCond = idCond;
		this.nomeCond = nomeCond;
		
		this.adm = adm;
		this.endereco = endereco;
		
		this.quantAP = quantAP;
		this.strID = Integer.toString(this.getIdCond());
	}
	
	
	@Override
    public String toString() {
        return "EntidadeCondominio{"
        		+ "\n		id= " + idCond + ";"
        		+ "\n		nomeCond= " + nomeCond + ";"
        		+ "\n		adm= " + adm + ";"
        		+ "\n		endereco= " + endereco + ";"
        		+ "\n		quantAP= " + quantAP + ";"
        		+ "}";

    }
	
	
	public int getIdCond() {
		return this.idCond;
	}

	
	public String getStrID() {
		return this.strID;
	}
		
	
	public String getNomeCond() {
		return nomeCond;
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
