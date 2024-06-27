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
	
	
	public boolean menuInicial() throws IOException, InterruptedException {
		char carregar;
		String strCarregar;
		
		while (true) {
			titulo("Configurações");
			System.out.print("| Deseja carregar os dados Padrões das Árvores? [S/N] ");
			
			carregar = entrada.next().toUpperCase().charAt(0);
			strCarregar = Character.toString(carregar).toUpperCase();
			
			if (strCarregar.equals("S") || strCarregar.equals("N")) {
				break;
				
			} else {
				mensagemTerminal(true, "Resposta inesperada, por favor tente novamente...");
				delay(2);
				
				format.limparTerminal();
			}	
		}
	
		if (strCarregar.equals("S")) {
			return true;
			
		} else {
			return false;
			
		}
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
				+ "\n[ 3 ] - Alterar"
				+ "\n[ 4 ] - Pesquisar"
				+ "\n[ 5 ] - Exibir Árvore");

		linha();
	}	
	
	
	public void menuAlterar(String nomeArv) {
		titulo("Alterar - Árvore " + nomeArv);
		
		System.out.println("[ 0 ] - Voltar");
		
		if (nomeArv.equals("Condomínio")) {
			System.out.println("[ 1 ] - Nome do Condomínio"
					+ "\n[ 2 ] - Administrador"
					+ "\n[ 3 ] - Endereço"
					+ "\n[ 4 ] - Quantidade de Apartamentos");
			
		} else {
			System.out.println("[ 1 ] - Nome do Responsável"
					+ "\n[ 2 ] - Quantidade de Moradores"
					+ "\n[ 3 ] - Número do Condomínio"
					+ "\n[ 4 ] - Disponibilidade");
			
		}

		linha();
	}
	
	
	public void menuPesquisar(String nomeArv) {
		titulo("Alterar - Árvore " + nomeArv);
		
		System.out.println("[ 0 ] - Voltar");
		
		if (nomeArv.equals("Condomínio")) {
			System.out.println("[ 1 ] - Situações dos Condomínios"
					+ "\n[ 2 ] - Condomínios X Administrador");
			
		} else {
			System.out.println("[ 1 ] - Apartamentos Vagos"
					+ "\n[ 2 ] - Quantidade de Moradores");
			
		}

		linha();

	}

	
	public void exibirArvore(ArvoreCondominio arvCond, ItemCondominio[] vetorItemCond) {
		String msg = format.dadosArvore(arvCond, vetorItemCond);
		
		titulo("Exibir Árvore - Árvore " + arvCond.getNOME());
		System.out.println(format.centralizarItem("[ID]", 6) 
				+ " - " 
				+ format.centralizarItem("[Condomínio]", 14)
				+ " | "
				+ format.centralizarItem("[ID]", 6) 
				+ " - " 
				+ format.centralizarItem("[Condomínio]", 14));
				
		linha();
				
				System.out.println(msg);
		
		linha();
	}
	
	
	public void exibirArvore(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msg = format.dadosArvore(arvMorador, vetorItemMorador);
		
		titulo("Exibir Árvore - Árvore " + arvMorador.getNOME());
		System.out.println(format.centralizarItem("[ID]", 6) 
				+ " - " 
				+ format.centralizarItem("[Responsável]", 14)
				+ " | "
				+ format.centralizarItem("[ID]", 6) 
				+ " - " 
				+ format.centralizarItem("[Responsável]", 14));
				
		linha();
				
				System.out.println(msg);
		
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
	
	
	public String exibirPesqAPsVagos(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = " [ID]  | [Responsável]  | [ID Condomínio]";
		msgDetalhada += format.tabelaAPsVagos(arvMorador, vetorItemMorador);
		
		return msgDetalhada;
	}
	
	public String exibirPesqQuantMoradores(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = " [ID Condomínio]  | [Quantidade Moradores]";
		msgDetalhada += format.tabelaQuantMoradores(arvMorador, vetorItemMorador);
		
		return msgDetalhada;
	}
	
	
	public String exibirPesqSituacaoCond (ArvoreCondominio arvCond, ItemCondominio[] vetorItemCond) {
		String msgDetalhada = " [Planta]  | [À Venda] | [Edificado] | [Em Construção] | [Sem Classificação]";
		msgDetalhada += format.tabelaSituacaoCond(arvCond, vetorItemCond);
		
		return msgDetalhada;
	}
	
	
	public String exibirPesqAdmXCond(ArvoreCondominio arvCond, ItemCondominio[] vetorItemCond) {
		String msgDetalhada = "";
		msgDetalhada += format.tabelaAdmXCond(arvCond, vetorItemCond);
		
		return msgDetalhada;
	}
	

	public void mensagemTerminal(boolean isError, String msg) {
		linha();
    	
		if (isError) {
    		format.centralizar("[ERRO] - " + msg);
    		
    	} else {
    		format.centralizar("[INFO] - " + msg);
    		
    	}    	
    	
    	linha();
    }


	public void creditos () throws IOException, InterruptedException {
		char abrirNav;
		String strAbrirNav;
		
		titulo("Créditos");

		format.centralizar("Diogo Rocha da Silva Pelanda");
		format.centralizar("Thiago Holz Coutinho");
		format.centralizar("Vinicius Rocha Aleixo");
		
		System.out.println("\n© Copyright TVD 2024"
				+ "\n"
				+ "\nLink do GitHub do Projeto:");
		format.centralizar("- https://github.com/Pigas22/ProjetoArvore/");
		linha(); 

		System.out.print("Abrir Link no navegador? [S/N] ");
		abrirNav = entrada.next().toUpperCase().charAt(0);
		strAbrirNav = Character.toString(abrirNav).toUpperCase();


		if (strAbrirNav.equals("S") || strAbrirNav.equals("N")) {
			if (strAbrirNav.equals("S")) {
				abrirNavegador();
			
			} else {
				mensagemTerminal(false, "Retornando ao Menu Principal, aguarde...");
				
			}
		
		} else {
			format.limparTerminal();

			mensagemTerminal(true, "Resposta inesperada, por favor tente novamente...");
			
			format.limparTerminal();
			creditos();
			
		}

		delay(3);
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
