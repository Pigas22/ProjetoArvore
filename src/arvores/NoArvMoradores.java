package arvores;


import dados.ItemMorador;

public class NoArvMoradores {
	private ItemMorador info; // o tipo ItemMoradores está declarado no capítulo 1
	private NoArvMoradores esq, dir;
	public NoArvMoradores(ItemMorador elem){
		this.info = elem;
		this.esq = null;
		this.dir = null;
	}
	
	public NoArvMoradores getEsq(){
		return this.esq;
	}
	
	public NoArvMoradores getDir(){
		return this.dir;
	}
	
	public ItemMorador getInfo(){
		return this.info;
	}
	
	public void setEsq(NoArvMoradores no){
		this.esq = no;
	}
	
	public void setDir(NoArvMoradores no){
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
