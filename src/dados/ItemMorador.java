package dados;

public class ItemMorador {
	private int idMorador;
	private String nomeResonsavel;

	private int quantMoradores;
	private int numAP;

	private int numCond;
	private boolean isVago = true;
	
	private String strID;
	
	
	public ItemMorador(int idMorador, String nomeResonsavel, int quantMoradores, int numAP, int numCond) {
		this.idMorador = idMorador;
		this.nomeResonsavel = nomeResonsavel;
		
		this.quantMoradores = quantMoradores;
		this.numAP = numAP;
		
		this.numCond = numCond;
		this.strID = Integer.toString(this.getIdMorador());
		
		if (quantMoradores != 0) {
			this.isVago = false;
		}
	}
	
	
	@Override
    public String toString() {
        return "EntidadeMorador{"
        		+ "\n		id= " + idMorador + ";"
        		+ "\n		nomeResponsavel= " + nomeResonsavel + ";"
        		+ "\n		quantMoradores= " + quantMoradores + ";"
        		+ "\n		numAP= " + numAP + ";"
        		+ "\n		numCond= " + numCond + ";"
        		+ "}";

    }
	
	
	public int getIdMorador() {
		return this.idMorador;
	}

	
	public String getStrID() {
		return this.strID;
	}
	
	
	public String getNomeResonsavel() {
		return nomeResonsavel;
	}
	public void setNomeResonsavel(String nomeResonsavel) {
		this.nomeResonsavel = nomeResonsavel;
	}
	
	
	public int getQuantMoradores() {
		return quantMoradores;
	}
	public void setQuantMoradores(int quantMoradores) {
		this.quantMoradores = quantMoradores;
	}
	
	
	public int getnumAP() {
		return numAP;
	}
	public void setnumAP(int numAP) {
		this.numAP = numAP;
	}
	
	
	public int getNumCond() {
		return numCond;
	}
	public void setNumCond(int numCond) {
		this.numCond = numCond;
	}
	
	
	public boolean getIsVago() {
		return this.isVago;
	}
	public void setIsVago(boolean isVago) {
		this.isVago = isVago;
	}
	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}