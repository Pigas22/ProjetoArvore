package menu;

public class Formatacao {
	private int numEspacamentoUni = 8;
	private String caracteres = "-="; // Mantenha 2 Caracteres
	
	
	public Formatacao() {
		// Usando somente para conseguir Instanciar a Classe nas outras Classes.
	}
	
	
	public void linha() {
		String msg = "";
		
		for (int i = 0; i < (2*this.numEspacamentoUni + 1); i++) {
			msg += this.caracteres;
		}
		
		System.out.println(msg);
	}
	
	
	public void titulo(String texto) {
		String strEspacamento = "";
		int tamanhoEspacamento = this.numEspacamentoUni * 2 - (texto.length() / 2); // Dobra do Tamanho do Espacamento
		
		for (int i = 0; i < tamanhoEspacamento; i++) {
			strEspacamento += " ";			
		}
		
		
		linha();
		System.out.println(strEspacamento + " " +  texto);
		linha();
	}

	
	public int getNumEspacamentoUni() {
		return numEspacamentoUni;
	}
	public void setNumEspacamentoUni(int numEspacamentoUni) {
		this.numEspacamentoUni = numEspacamentoUni;
	}

	
	public String getCaracteres() {
		return caracteres;
	}
	public void setCaracteres(String caracteres) {
		this.caracteres = caracteres;
	}

	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}
