package menu;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import arvores.ArvoreCondominio;
import arvores.ArvoreMorador;
import dados.ItemCondominio;
import dados.ItemMorador;


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

	
	public void exibirArvore(ArvoreCondominio arvCond, ItemCondominio[] vetorItemCond) {
		String msg = format.dadosArvore(arvCond, vetorItemCond);
		
		titulo("Exibir Árvore - Árvore " + arvCond.getNOME());
		System.out.println("| Exibir a árvore: "
				+ "\n" + format.centralizarTabela("[ID]") + " - [Nome]"
				+ msg);
		
		linha();
	}
	
	
	public void exibirArvore(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msg = format.dadosArvore(arvMorador, vetorItemMorador);
		
		titulo("Exibir Árvore - Árvore " + arvMorador.getNOME());
		System.out.println("| Exibir a árvore: "
				+ "\n" + format.centralizarTabela("[ID]") + " - [Nome]"
				+ msg);
		
		linha();
	}
	
	
	public void exibirDetalhesArvore(ArvoreCondominio arvCond, ItemCondominio[] vetorItemCond) {
		String msgDetalhada = format.detalhaDadosArvore(arvCond, vetorItemCond);
		
		System.out.println("| Exibir Detelhes: "
				+ "\n" + msgDetalhada);
		
		linha();
	}

	
	public void exibirDetalhesArvore(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = format.detalhaDadosArvore(arvMorador, vetorItemMorador);
		
		System.out.println("| Exibir Detelhes: "
				+ "\n" + msgDetalhada);
		
		linha();
	}
	

	public void mensagemTerminal(boolean isError, String msg) {
    	if (isError) {
    		System.out.println("[ERRO] - " + msg);
    		
    	} else {
    		System.out.println("[INFO] - " + msg);
    		
    	}    	
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
