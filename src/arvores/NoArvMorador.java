package arvores;


import dados.ItemMorador;

public class NoArvMorador {
	private ItemMorador info; // o tipo ItemMoradores está declarado no capítulo 1
	private NoArvMorador esq, dir;
	public NoArvMorador(ItemMorador elem){
		this.info = elem;
		this.esq = null;
		this.dir = null;
	}
	
	public NoArvMorador getEsq(){
		return this.esq;
	}
	
	public NoArvMorador getDir(){
		return this.dir;
	}
	
	public ItemMorador getInfo(){
		return this.info;
	}
	
	public void setEsq(NoArvMorador no){
		this.esq = no;
	}
	
	public void setDir(NoArvMorador no){
		this.dir = no;
	}
	
	public void setInfo(ItemMorador elem){
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
