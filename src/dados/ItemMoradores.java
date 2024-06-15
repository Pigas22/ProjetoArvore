package dados;

public class ItemMoradores {
	private String nomeResonsavel;
	private int quantMoradores;
	private int numAP;
	private int numCond;
	
	public ItemMoradores(String nomeResonsavel, int quantMoradores, int numAP, int numCond) {
		super();
		this.nomeResonsavel = nomeResonsavel;
		this.quantMoradores = quantMoradores;
		this.numAP = numAP;
		this.numCond = numCond;
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
}