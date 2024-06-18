package menu;

import java.io.IOException;

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
    
    
    public void mensagemTerminal(boolean isError, String msg) {
    	if (isError) {
    		System.out.println("[ERRO] - " + msg);
    		
    	} else {
    		System.out.println("[INFO] - " + msg);
    		
    	}    	
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
