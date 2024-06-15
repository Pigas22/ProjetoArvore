package arvores;


import dados.ItemMoradores;

public class NoArvMoradores {
	private ItemMoradores info; // o tipo ItemMoradores está declarado no capítulo 1
	private NoArvMoradores esq, dir;
	public NoArvMoradores(ItemMoradores elem){
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
	
	public ItemMoradores getInfo(){
		return this.info;
	}
	
	public void setEsq(NoArvMoradores no){
		this.esq = no;
	}
	
	public void setDir(NoArvMoradores no){
		this.dir = no;
	}
	
	public void setInfo(ItemMoradores elem){
		this.info = elem;
	}
}
