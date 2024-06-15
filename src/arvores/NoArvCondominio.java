package arvores;


import dados.ItemCondominio;

public class NoArvCondominio {
	private ItemCondominio info; // o tipo ItemCondominio está declarado no capítulo 1
	private NoArvCondominio esq, dir;
	
	public NoArvCondominio(ItemCondominio elem){
		this.info = elem;
		this.esq = null;
		this.dir = null;
	}
	
	public NoArvCondominio getEsq(){
		return this.esq;
	}
	
	public NoArvCondominio getDir(){
		return this.dir;
	}
	
	public ItemCondominio getInfo(){
		return this.info;
	}
	
	public void setEsq(NoArvCondominio no){
		this.esq = no;
	}
	
	public void setDir(NoArvCondominio no){
		this.dir = no;
	}
	
	public void setInfo(ItemCondominio elem){
		this.info = elem;
	}
	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}
