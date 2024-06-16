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

/*
 * Inserir (Condominio, Morador)
 * Pesquisar (APs Vagas, QuantTotal de Pss)
 * Remover (Condominio, Morador)
 * Caminhamento
 * 	- pre fixado
 * 	- central
 * 	- pos fixado
 */

public class Main {
	static Formatacao format = new Formatacao();
	static Scanner entrada = new Scanner(System.in);

	static boolean isMenuArvore = false;
	static boolean isArvCondominio = false;
	static boolean isArvMorador = false;

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


	public static void main(String[] args) throws IOException, InterruptedException {
		ArvoreCondominio arvCond = new ArvoreCondominio();
		ArvoreMorador arvMorador = new ArvoreMorador();

		// Váriaveis relacionadas às árvores
		int quantAP, quantMoradores, numAP, numCond;
		String nomeCond, adm, endereco, nomeResponsavel;

		ItemCondominio[] vetorItemCond = new ItemCondominio[5]; 
		ItemMorador[] vetorItemMorador = new ItemMorador[30];

		char escolha;
		int escolhaInt;


		do {
			menuPrincipal();
			System.out.print("| Informe sua escolha: ");
			escolha = entrada.next().charAt(0);

			escolhaInt = Integer.parseInt(String.valueOf((char)escolha));

			format.limparTerminal();

			if (escolha == '0' && !isMenuArvore) {
				break;

			} else if (escolha <= '5' && !isMenuArvore) {
				format.titulo(OpcMenuPrin[escolhaInt]);

			} else if (isMenuArvore) {
				if (isArvCondominio 
						&& escolhaInt != 0 ) {

					format.titulo(OpcMenuArv[escolhaInt] + " - Árvore Condomínio");

				} else if (isArvMorador 
						&& escolhaInt != 0) {

					format.titulo(OpcMenuArv[escolhaInt] + " - Árvore Morador");

				} else {
					format.titulo(OpcMenuArv[escolhaInt]);

				}
			}

			switch (escolha) {
			case '0': 
				if (isMenuArvore) {
					menuPrincipal();
				}

			case '1':
				// Árvore Condomínios e Inserir
				if (!isMenuArvore) {
					menuArvore("Condomínio");

				} else if (isMenuArvore) {
					if (isArvCondominio) {
						// Perguntar valores para inserir na Arvore Condominio
						System.out.print(" | Nome do Condomínio: ");
						nomeCond = entrada.next();

						System.out.print(" | Administrador do Condomínio: ");
						adm = entrada.next();

						System.out.print(" | Endereço: ");
						endereco = entrada.next();

						System.out.print(" | Quantidade de Apartamentos:");
						quantAP = entrada.nextInt();

						if (endereco != "") {
							if (arvCond.inserir(new ItemCondominio(nomeCond, adm, endereco, quantAP))){
								format.mensagemTerminal(false, "Inserção efetuada com sucesso..."); // escolher entre essa linha ou a debaixo
								System.out.println("[INFO] - Inserção efetuada com sucesso...");

							} else {
								format.mensagemTerminal(true, "Inserção não efetuada, valor já existe"); // escolher entre essa linha ou a debaixo
								System.out.println("[ERRO] - Inserção não efetuada, valor já existe");

							}		

						} else {
							if (arvCond.inserir(new ItemCondominio(nomeCond, adm, quantAP))){
								System.out.println("[INFO] - Inserção efetuada com sucesso...");

							} else {
								System.out.println("[ERRO] - Inserção não efetuada, valor já existe");

							}							
						}

					} else if (isArvMorador) {
						// Perguntar valores para inserir na Arvore Morador
						System.out.print(" | Nome do Responsável: ");
						nomeResponsavel = entrada.next();

						System.out.print(" | Administrador do Condomínio: ");
						quantMoradores = entrada.nextInt();

						System.out.print(" | Endereço: ");
						numAP = entrada.nextInt();

						System.out.print(" | Número da :");
						numCond = entrada.nextInt();

						if (arvMorador.inserir(new ItemMorador(nomeResponsavel, quantMoradores, numAP, numCond))){
							System.out.println("[INFO] - Inserção efetuada com sucesso...");

						} else {
							System.out.println("[ERRO] - Inserção não efetuada, valor já existe");

						}

					} else {
						System.out.println("[ERRO] - Problema inesperado, retornando ao menu principal.");

					}
				} else {
					System.out.println("[ERRO] - Problema inesperado, retornando ao menu principal.");

				}
				break;

			case '2':
				// Árvore Moradores e Remover
				if (!isMenuArvore) {
					menuArvore("Moradores");
				} else if (isMenuArvore) {
					if (isArvCondominio) {


					} else if (isArvMorador) {


					} else {


					}

				} else {


				}			

				break;

			case '3':
				// Pesquisar e Créditos
				if (!isMenuArvore) {
					creditos();
				} else if (isMenuArvore) {
					if (isArvCondominio) {


					} else if (isArvMorador) {


					} else {


					}

				} else {


				}	

				break;

			case '4':
				// Exibir Árvore
				if (isMenuArvore) {
					if (arvCond.eVazia() && arvMorador.eVazia()) {
						System.out.println("A árvore está vazia");						

					} else if (isArvCondominio) {
						vetorItemCond = arvCond.CamCentral();
						String msg=" ";
						for (int i=0; i<arvCond.getQuantNos();i++){
							msg+= vetorItemCond[i].getNomeCond()+"; ";
						}
						System.out.println("Exibir a árvore: "
								+ "\n	| "+ msg);
					} else if (isArvMorador) {
						vetorItemMorador = arvMorador.CamCentral();
						String msg=" ";
						for (int i=0; i<arvMorador.getQuantNos();i++){
							msg+= vetorItemMorador[i].getNomeResonsavel()+"; ";
						}
						System.out.println("Exibir a árvore: "
								+ "\n	| "+ msg);
					} else {


					}

				} else {


				}	
				break;

			default:
				System.out.println("[ERRO] - Número informado fora das escolhas esperadas pelo sistema.");
			}			

			format.limparTerminal();
		} while (escolha != '0' && !isMenuArvore);

		System.out.println("[INFO] - Finalizando o Programa...");	

		entrada.close();
		System.exit(0);
	}


	public static void menuPrincipal () {
		format.titulo("Menu Principal");

		System.out.println("[ 0 ] - Sair"
				+ "\n[ 1 ] - Árvore Condomínios"
				+ "\n[ 2 ] - Árvore Moradores"
				+ "\n[ 3 ] - Créditos");

		format.linha();
	}


	public static void menuArvore (String nomeArv) {
		format.titulo("Menu " + nomeArv);

		System.out.println("[ 0 ] - Voltar"
				+ "\n[ 1 ] - Inserir"
				+ "\n[ 2 ] - Remover"
				+ "\n[ 3 ] - Pesquisar"
				+ "\n[ 4 ] - Exibir Árvore");

		format.linha();
	}	


	public static void creditos () {
		char abrirNav;
		String strAbrirNav;

		format.centralizar("Diogo Rocha da Silva Pelanda");
		format.centralizar("Thiago Holz Coutinho");
		format.centralizar("Vinicius Rocha Aleixo");
		System.out.println("\n©️ Copyright TVD 2024"
				+ "\n"
				+ "\nLink do GitHub do Projeto:");
		format.centralizar("- https://github.com/Pigas22/ProjetoArvore/");
		format.linha(); 

		System.out.print("Abrir Link no navegador? [S/N] ");
		abrirNav = entrada.next().toUpperCase().charAt(0);
		strAbrirNav = Character.toString(abrirNav).toUpperCase();


		if (strAbrirNav.equals("S")) {
			abrirNavegador();
		}

		System.out.print("Continuar? [Digite qualquer coisa] ");
		entrada.next();
	}

	public static void abrirNavegador () {
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
	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}
