package menu;

import java.io.IOException;

import arvores.ArvoreCondominio;
import arvores.ArvoreMorador;
import dados.ItemCondominio;
import dados.ItemMorador;

public class Formatacao {
	private int numEspacamentoUni = 12;
	private String caracteres = "-="; // Mantenha 2 Caracteres
	
	
	public Formatacao() {
		// Usando somente para conseguir Instanciar a Classe nas outras Classes.
	}
	
	
	public void centralizar(String texto) {
		String strEspacamento = "";
		int tamanhoEspacamento = this.numEspacamentoUni * 2 - (texto.length() / 2); // Dobra do Tamanho do Espacamento
		
		for (int i = 0; i < tamanhoEspacamento; i++) {
			strEspacamento += " ";			
		}
		
		System.out.println(strEspacamento + " " +  texto);
	}
	
	public String centralizarTabela (String texto) {
		String strEspacamento = "";
		int tamanhoEspacamento = this.numEspacamentoUni - texto.length(); // Dobra do Tamanho do Espacamento
		
		for (int i = 0; i < tamanhoEspacamento; i++) {
			strEspacamento += " ";			
		}
		
		return strEspacamento + texto;
	}
	
	
    // Limpa o terminal, ainda em teste - Thiago
    public void limparTerminal() throws IOException, InterruptedException {
        //Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime();
        }
    }
    
	
	public String dadosArvore(ArvoreCondominio arvCond, ItemCondominio[] vetorItemCond) {
		vetorItemCond = arvCond.CamCentral();
		String msg = "";

		for (int i = 0; i < arvCond.getQuantNos(); i++){
			msg+= "\n" + centralizarTabela(vetorItemCond[i].getStrID())
										+ " - " + vetorItemCond[i].getNomeCond() + ";";

		}
		return msg;
	}
	
	
	public String dadosArvore(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		vetorItemMorador = arvMorador.CamCentral();
		String msg = "";
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			msg+= "\n" + centralizarTabela(vetorItemMorador[i].getStrID()) 
										+ " - " + vetorItemMorador[i].getNomeResonsavel() + ";";
		
		}
		return msg;
	}
	
	
	public String detalhaDadosArvore (ArvoreCondominio arvCond, ItemCondominio[] vetorItemCond) {
		String msgDetalhada = "";
		
		for (int i = 0; i < arvCond.getQuantNos(); i++){
			msgDetalhada += "\n" + vetorItemCond[i].toString() + ";\n";

		}
		
		return msgDetalhada;
	}

	
	public String detalhaDadosArvore (ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = "";
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			msgDetalhada += "\n" + vetorItemMorador[i].toString() + ";\n";
			
		}
		
		return msgDetalhada;
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
