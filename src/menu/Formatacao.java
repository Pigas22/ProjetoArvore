package menu;

import java.io.IOException;

import arvores.ArvoreCondominio;
import arvores.ArvoreMorador;
import dados.ItemCondominio;
import dados.ItemMorador;

public class Formatacao {
	private int numEspacamentoUni = 14;
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
	
	public String centralizarItem (String texto) {
		String strEspacamento = "";
		int tamanhoEspacamento = this.numEspacamentoUni - texto.length(); // Dobra do Tamanho do Espacamento
		
		for (int i = 0; i < tamanhoEspacamento; i++) {
			strEspacamento += " ";			
		}
		
		return strEspacamento + texto;
	}
	
	
	public String centralizarItem (String texto, int tamanho) {
		String strEspacamento = "";
		int tamanhoEspacamento;
		
		if (texto.length() % 2 == 0) {
			tamanhoEspacamento = (tamanho - texto.length()) / 2;
			
		} else {
			texto+= " ";
			tamanhoEspacamento = (tamanho - texto.length()) / 2;
			
		}
		
		
		for (int i = 0; i < tamanhoEspacamento; i++) {
			strEspacamento += " ";			
		}
		
		return strEspacamento + texto + strEspacamento;
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
			if (i % 2 == 0 && i != 0) {
				msg += "\n";
			}
						
			msg+= centralizarItem(vetorItemCond[i].getStrID(), 6) 
					+ " - " 
					+ centralizarItem(vetorItemCond[i].getNomeCond(), 14)
					+ " | ";
			
		}
		return msg;
	}
	
	
	public String dadosArvore(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		vetorItemMorador = arvMorador.CamCentral();
		String msg = "";
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			if (i % 2 == 0 && i != 0) {
				msg += "\n";
			}
						
			msg+= centralizarItem(vetorItemMorador[i].getStrID(), 6) 
					+ " - " 
					+ centralizarItem(vetorItemMorador[i].getNomeResonsavel(), 14)
					+ " | ";
		
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

	
	public String detalhaDadosArvore(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = "";
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			msgDetalhada += "\n" + vetorItemMorador[i].toString() + ";\n";
			
		}
		
		return msgDetalhada;
	}
	
	
	public String tabelaAPsVagos(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = "";
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			if (vetorItemMorador[i] == null) {
				continue;
			}
			
			msgDetalhada += "\n " + centralizarItem(vetorItemMorador[i].getStrID(), 6) 
					+ " | " + centralizarItem(vetorItemMorador[i].getNomeResonsavel(), 14) 
					+ " | " + centralizarItem(Integer.toString(vetorItemMorador[i].getNumCond()), 6);
			
		}
		
		return msgDetalhada;
	}
	
	
	public String tabelaQuantMoradores(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = "";
		int[] somaQuantMoradores = new int[5];
		int[] vetorCondID = new int[5];
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			if (vetorItemMorador[i] == null) {
				continue;
				
			}
			
			if (i == 0) {
				vetorCondID[i] = vetorItemMorador[i].getNumCond();
				somaQuantMoradores[i] += vetorItemMorador[i].getQuantMoradores();
				continue;
			} 

			for (int c = 0; c < vetorCondID.length; c++) {
				if (vetorItemMorador[i].getNumCond() == vetorCondID[c]) {
					somaQuantMoradores[c] += vetorItemMorador[i].getQuantMoradores();
					break;
					
				} else if (vetorCondID[c] == 0) {
					vetorCondID[c] = vetorItemMorador[i].getNumCond();
					break;
					
				} else {
					continue;
					
				}
			}
			
		}
		
		for (int f = 0; f < vetorCondID.length; f++) {
			if (vetorCondID[f] != 0) {
				msgDetalhada += "\n " 
						+ centralizarItem("" + vetorCondID[f], 18) 
						+ ": "
						+ centralizarItem("" + somaQuantMoradores[f], 22);
			}
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
