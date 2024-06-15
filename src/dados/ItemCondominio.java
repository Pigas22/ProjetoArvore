package dados;

public class ItemCondominio {
	private String nomeCond;
	private String adm; 
	private String endereco;
	private int quantAP;
	
	
	public ItemCondominio(String nomeCond, String adm, String endereco, int quantAP) {
		super();
		this.nomeCond = nomeCond;
		this.adm = adm;
		this.endereco = endereco;
		this.quantAP = quantAP;
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
	
	
	public int getQuantCasa() {
		return quantAP;
	}
	public void setQuantCasa(int quantCasa) {
		this.quantAP = quantCasa;
	}
}
