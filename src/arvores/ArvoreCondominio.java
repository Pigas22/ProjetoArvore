package arvores;

import dados.ItemCondominio;


public class ArvoreCondominio {
	private NoArvCondominio raiz;
	private int quantNos;//opcional
	
	
	public ArvoreCondominio(){
		this.quantNos=0;
		this.raiz = null;
	}
	
	public boolean eVazia (){
		return (this.raiz == null);
	}
	
	public NoArvCondominio getRaiz(){
		return this.raiz;
	}
	
	public int getQuantNos(){
		return this.quantNos;
	}
	
	//inserir um novo nó na arvore. Sempre insere em um atributo que seja igual a null
	public boolean inserir (ItemCondominio elem){
		if (pesquisar (elem.getIdCond())){
			return false;
		}else{
			this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	
	public NoArvCondominio inserir (ItemCondominio elem, NoArvCondominio no){
		if (no == null){
			NoArvCondominio novo = new NoArvCondominio(elem);
			return novo;
		}else {
			if (elem.getIdCond() < no.getInfo().getIdCond()){
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}
	
	//Pesquisa se um determinado valor está na árvore
	public boolean pesquisar (int idCond){
		if (pesquisar (idCond, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}
	
	private NoArvCondominio pesquisar (int idCond, NoArvCondominio no){
		if (no != null){
			if (idCond < no.getInfo().getIdCond()){
				no = pesquisar (idCond, no.getEsq());
			}else{
				if (idCond > no.getInfo().getIdCond()){
					no = pesquisar (idCond, no.getDir());
				}
			}
		}
		return no;
	}
	
	//remove um determinado nó procurando pela chave. O nó pode estar em qualquer
	//posição na árvore
	public boolean remover (int idCond){
		if (pesquisar (idCond, this.raiz) != null){
			this.raiz = remover (idCond, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	
	public NoArvCondominio remover (int idCond, NoArvCondominio arv){
		if (idCond < arv.getInfo().getIdCond()){
			arv.setEsq(remover (idCond, arv.getEsq()));
		}else{
			if (idCond > arv.getInfo().getIdCond()){
				arv.setDir(remover (idCond, arv.getDir()));
			}else{
				if (arv.getDir()== null){
					return arv.getEsq();
				}else{
					if (arv.getEsq() == null){
						return arv.getDir();
					}else{
						arv.setEsq(Arrumar (arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}
	
	private NoArvCondominio Arrumar (NoArvCondominio arv, NoArvCondominio maior){
		if (maior.getDir() != null){
			maior.setDir(Arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}
	
	//caminhamento central
	public ItemCondominio [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		ItemCondominio [] vet = new ItemCondominio[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private ItemCondominio [] FazCamCentral (NoArvCondominio arv, ItemCondominio [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	
	//caminhamento pré-fixado
	public ItemCondominio [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		ItemCondominio [] vet = new ItemCondominio[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private ItemCondominio [] FazCamPreFixado (NoArvCondominio arv, ItemCondominio [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	
	//caminhamento pós-fixado
	public ItemCondominio [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		ItemCondominio [] vet = new ItemCondominio[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	
	private ItemCondominio [] FazCamPosFixado (NoArvCondominio arv, ItemCondominio[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}
	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}
