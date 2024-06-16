package arvores;

import dados.ItemMorador;

public class ArvoreMorador {
	private NoArvMoradores raiz;
	private int quantNos;//opcional
	
	
	public ArvoreMorador(){
		this.quantNos=0;
		this.raiz = null;
	}
	
	public boolean eVazia (){
		return (this.raiz == null);
	}
	
	public NoArvMoradores getRaiz(){
		return this.raiz;
	}
	
	public int getQuantNos(){
		return this.quantNos;
	}
	
	//inserir um novo nó na arvore. Sempre insere em um atributo que seja igual a null
	public boolean inserir (ItemMorador elem){
		if (pesquisar (elem.getIdMorador())){
			return false;
		}else{
			this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	
	public NoArvMoradores inserir (ItemMorador elem, NoArvMoradores no){
		if (no == null){
			NoArvMoradores novo = new NoArvMoradores(elem);
			return novo;
		}else {
			if (elem.getIdMorador() < no.getInfo().getIdMorador()){
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}
	
	//Pesquisa se um determinado valor está na árvore
	public boolean pesquisar (int idMorador){
		if (pesquisar (idMorador, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}
	
	private NoArvMoradores pesquisar (int idMorador, NoArvMoradores no){
		if (no != null){
			if (idMorador < no.getInfo().getIdMorador()){
				no = pesquisar (idMorador, no.getEsq());
			}else{
				if (idMorador > no.getInfo().getIdMorador()){
					no = pesquisar (idMorador, no.getDir());
				}
			}
		}
		return no;
	}
	
	//remove um determinado nó procurando pela chave. O nó pode estar em qualquer
	//posição na árvore
	public boolean remover (int idMorador){
		if (pesquisar (idMorador, this.raiz) != null){
			this.raiz = remover (idMorador, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	
	public NoArvMoradores remover (int idMorador, NoArvMoradores arv){
		if (idMorador < arv.getInfo().getIdMorador()){
			arv.setEsq(remover (idMorador, arv.getEsq()));
		}else{
			if (idMorador > arv.getInfo().getIdMorador()){
				arv.setDir(remover (idMorador, arv.getDir()));
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
	
	private NoArvMoradores Arrumar (NoArvMoradores arv, NoArvMoradores maior){
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
	public ItemMorador [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		ItemMorador [] vet = new ItemMorador[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private ItemMorador [] FazCamCentral (NoArvMoradores arv, ItemMorador [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	
	//caminhamento pré-fixado
	public ItemMorador [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		ItemMorador [] vet = new ItemMorador[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private ItemMorador [] FazCamPreFixado (NoArvMoradores arv, ItemMorador [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	
	//caminhamento pós-fixado
	public ItemMorador [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		ItemMorador [] vet = new ItemMorador[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	
	private ItemMorador [] FazCamPosFixado (NoArvMoradores arv, ItemMorador[] vet, int []n){
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
