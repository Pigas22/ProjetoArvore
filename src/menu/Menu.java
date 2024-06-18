package menu;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Menu {
	static Formatacao format = new Formatacao();
	static Scanner entrada = new Scanner(System.in);
	private String caracteres;
	private int numEspacamentoUni;

	static final String[] OpcMenuPrin = {
			"Sair",
			"Árvore Condomínios",
			"Árvore Moradores",
			"Créditos",
	};
	static final String[] OpcMenuArv = {
			"Voltar",
			"Inserir",
			"Remover",
			"Pesquisar",
			"Exibir Árvore",
	};
	
	
	// Construtor
	public Menu() {
		this.caracteres = format.getCaracteres();
		this.numEspacamentoUni = format.getNumEspacamentoUni();
	}
	
	
	public void linha() {
		String msg = "";
		
		for (int i = 0; i < (2*this.numEspacamentoUni + 1); i++) {
			msg += this.caracteres;
		}
		
		System.out.println(msg);
	}
	
	
	public void titulo(String texto) {
		linha();
		format.centralizar(texto);
		linha();
	}
	
	

	public void menuPrincipal () {
		titulo("Menu Principal");

		System.out.println("[ 0 ] - Sair"
				+ "\n[ 1 ] - Árvore Condomínios"
				+ "\n[ 2 ] - Árvore Moradores"
				+ "\n[ 3 ] - Créditos");

		linha();
	}


	public void menuArvore (String nomeArv) {
		titulo("Menu - Árvore " + nomeArv);

		System.out.println("[ 0 ] - Voltar"
				+ "\n[ 1 ] - Inserir"
				+ "\n[ 2 ] - Remover"
				+ "\n[ 3 ] - Pesquisar"
				+ "\n[ 4 ] - Exibir Árvore");

		linha();
	}	

	
	public void menuArvoreInserir (String nomeArv) {
		titulo("Inserir - Árvore " + nomeArv);
	}
	
	
	public void menuArvoreRemover (String nomeArv) {
		titulo("Remover - Árvore " + nomeArv);
	}
	
	
	public void menuArvorePesquisar (String nomeArv) {
		titulo("Pesquisar - Árvore " + nomeArv);
	}
	
	
	public void menuExibirArvore (String nomeArv) {
		titulo("Exibir Árvore - Árvore " + nomeArv);
	}
	

	public void creditos () {
		char abrirNav;
		String strAbrirNav;
		
		titulo("Créditos");

		format.centralizar("Diogo Rocha da Silva Pelanda");
		format.centralizar("Thiago Holz Coutinho");
		format.centralizar("Vinicius Rocha Aleixo");
		
		System.out.println("\n©️ Copyright TVD 2024"
				+ "\n"
				+ "\nLink do GitHub do Projeto:");
		format.centralizar("- https://github.com/Pigas22/ProjetoArvore/");
		linha(); 

		System.out.print("Abrir Link no navegador? [S/N] ");
		abrirNav = entrada.next().toUpperCase().charAt(0);
		strAbrirNav = Character.toString(abrirNav).toUpperCase();


		if (strAbrirNav.equals("S")) {
			abrirNavegador();
		}

		delay(1);
	}


	public void abrirNavegador () {
		String url = "https://github.com/Pigas22/ProjetoArvore/";

		// Verifica se o desktop é suportado pela plataforma
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();

			try {
				// Abre o navegador com a URL fornecida
				desktop.browse(new URI(url));
				System.out.println("Abrindo navegador com URL: " + url);

			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();

			}
		} else {
			System.err.println("Ação de navegação não suportada.");
			System.out.println("Por favor, abra o seguinte link manualmente: " + url);
		}
	}
	
	
	public void delay(int tempo) {
		try {
	        Thread.sleep(tempo * 1000);  // transforma o tempo informado em milissegundos
	    } catch (InterruptedException e) {
	        // Trata a exceção caso a thread seja interrompida durante o sleep
	        e.printStackTrace();
	    }
	}
	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}
