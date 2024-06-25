package arvores;

import dados.ItemMorador;

public class ArvoreMorador {
	private NoArvMorador raiz;
	private int quantNos;//opcional
	
	private final String NOME = "Morador";
	
	
	public ArvoreMorador(){
		this.quantNos=0;
		this.raiz = null;
	}
	
	public void inserirDadosPadroes() {
		// Condominio 1
		this.inserir(new ItemMorador(1, "Thiago", 3, 1));
		this.inserir(new ItemMorador(2, "Thiago", 3, 1));
		this.inserir(new ItemMorador(3, "Thiago", 3, 1));
		this.inserir(new ItemMorador(4, "Thiago", 3, 1));
		this.inserir(new ItemMorador(5, "Thiago", 3, 1));
		this.inserir(new ItemMorador(6, "Thiago", 3, 1));
		this.inserir(new ItemMorador(7, "Thiago", 3, 1));
		this.inserir(new ItemMorador(8, "Thiago", 3, 1));
		
		// Condominio 3
		this.inserir(new ItemMorador(9,  "Diogo", 3, 3));
		this.inserir(new ItemMorador(10, "Diogo", 3, 3));
		this.inserir(new ItemMorador(11, "Diogo", 3, 3));
		this.inserir(new ItemMorador(12, "Diogo", 3, 3));
		this.inserir(new ItemMorador(13, "Diogo", 3, 3));
		this.inserir(new ItemMorador(14, "Diogo", 3, 3));
		this.inserir(new ItemMorador(15, "Diogo", 3, 3));
		this.inserir(new ItemMorador(16, "Diogo", 3, 3));
		
		// Condominio 4
		this.inserir(new ItemMorador(17, "Vinicius", 3, 4));
		this.inserir(new ItemMorador(18, "Vinicius", 3, 4));
		this.inserir(new ItemMorador(19, "Vinicius", 3, 4));
		this.inserir(new ItemMorador(20, "Vinicius", 3, 4));
		this.inserir(new ItemMorador(21, "Vinicius", 3, 4));
		this.inserir(new ItemMorador(22, "Vinicius", 3, 4));
		this.inserir(new ItemMorador(23, "Vinicius", 3, 4));
		this.inserir(new ItemMorador(24, "Vinicius", 3, 4));
	}
	
	public String getNOME() {
		return this.NOME;
	}
	
	public boolean eVazia (){
		return (this.raiz == null);
	}
	
	public NoArvMorador getRaiz(){
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
	
	public NoArvMorador inserir (ItemMorador elem, NoArvMorador no){
		if (no == null){
			NoArvMorador novo = new NoArvMorador(elem);
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
	
	public ItemMorador pesquisarComRetorno (int idMorador){
		NoArvMorador no = pesquisar (idMorador, this.raiz);
		
		if (no != null){
			return no.getInfo();
		}else{
			return null;
		}
	}
	
	private NoArvMorador pesquisar (int idMorador, NoArvMorador no){
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
	
	public NoArvMorador remover (int idMorador, NoArvMorador arv){
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
	
	private NoArvMorador Arrumar (NoArvMorador arv, NoArvMorador maior){
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
	private ItemMorador [] FazCamCentral (NoArvMorador arv, ItemMorador [] vet, int []n){
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
	private ItemMorador [] FazCamPreFixado (NoArvMorador arv, ItemMorador [] vet, int []n){
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
	
	private ItemMorador [] FazCamPosFixado (NoArvMorador arv, ItemMorador[] vet, int []n){
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
