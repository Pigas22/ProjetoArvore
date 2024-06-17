package gerenciador;


import java.io.IOException;
import java.util.Scanner;

import arvores.ArvoreCondominio;
import arvores.ArvoreMorador;
import dados.ItemCondominio;
import dados.ItemMorador;
import menu.Formatacao;
import menu.Menu;

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
	static Menu menu = new Menu();
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// Árvores
		ArvoreCondominio arvCond = new ArvoreCondominio();
		ArvoreMorador arvMorador = new ArvoreMorador();

		// Váriaveis relacionadas às árvores
		int quantAP, quantMoradores, numAP, numCond;
		String nomeCond, adm, endereco, nomeResponsavel;
		String nomeArv = "";

		ItemCondominio[] vetorItemCond = new ItemCondominio[5]; 
		ItemMorador[] vetorItemMorador = new ItemMorador[30];

		boolean isMenuPrincipal = true;
		boolean isArvCondominio = false;
		boolean isArvMorador = false;

		int escolhaInt = 0;

		do {
			if (isMenuPrincipal) {
				menu.menuPrincipal();

			} else if (isArvCondominio) {
				menu.menuArvore("Condomínio");

			} else if (isArvMorador) {
				menu.menuArvore("Morador");

			}

			System.out.print("| Informe sua escolha: ");
			escolhaInt = Integer.parseInt(String.valueOf((char)entrada.next().charAt(0)));

				
			format.limparTerminal();
			
			
			if (isMenuPrincipal) {
				if (escolhaInt == 0) {
					break;

				}
			} else {
				if (isArvCondominio) {
					nomeArv = "Condomínio";

				} else if (isArvMorador) {
					nomeArv = "Morador";
					
				}
			}


			switch (escolhaInt) {
			case 0: 
				if (!isMenuPrincipal) {
					isMenuPrincipal = true;
					isArvCondominio = false;
					isArvMorador = false;
					
					format.titulo("Voltar");

				}
				break;

			case 1:
				// Árvore Condomínios e Inserir
				if (isMenuPrincipal) {
					isArvCondominio = true;
					isMenuPrincipal = false;
					isArvMorador = false;

				} else {
					menu.menuArvoreInserir(nomeArv);
					
					if (isArvCondominio) {
						// Perguntar valores para inserir na Arvore Condominio
						System.out.print(" | Nome do Condomínio: ");
						entrada.nextLine();
						nomeCond = entrada.nextLine();

						System.out.print(" | Administrador do Condomínio: ");
						adm = entrada.nextLine();

						System.out.print(" | Endereço: ");
						endereco = entrada.nextLine();

						System.out.print(" | Quantidade de Apartamentos:");
						quantAP = entrada.nextInt();

						format.linha();
						
						if (endereco.equals("")) {
							if (arvCond.inserir(new ItemCondominio(nomeCond, adm, endereco, quantAP))){
								format.mensagemTerminal(false, "Inserção efetuada com sucesso...");

							} else {
								format.mensagemTerminal(true, "Inserção não efetuada, valor já existe");
							
							}		
						} else {
							if (arvCond.inserir(new ItemCondominio(nomeCond, adm, quantAP))){
								format.mensagemTerminal(false, "Inserção efetuada com sucesso...");

							} else {
								format.mensagemTerminal(true, "Inserção não efetuada, valor já existe");

							}							
						}

					} else if (isArvMorador) {
						// Perguntar valores para inserir na Arvore Morador
						System.out.print(" | Nome do Responsável: ");
						entrada.nextLine();
						nomeResponsavel = entrada.nextLine();

						System.out.print(" | Quantidade de Moradores: ");
						quantMoradores = entrada.nextInt();

						System.out.print(" | Número Apartamento: ");
						numAP = entrada.nextInt();

						System.out.print(" | Número do Condomínio :");
						numCond = entrada.nextInt();

						format.linha();
						
						if (arvMorador.inserir(new ItemMorador(nomeResponsavel, quantMoradores, numAP, numCond))){
							format.mensagemTerminal(false, "Inserção efetuada com sucesso...");

						} else {
							format.mensagemTerminal(false, "Inserção efetuada com sucesso...");
							
						}
					} else {
						format.linha();
						format.mensagemTerminal(true, "Problema inesperado, retornando ao menu principal.");

					}
					
					menu.delay(2);
				}
				break;

			case 2:
				// Árvore Moradores e Remover
				if (isMenuPrincipal) {
					isArvMorador = true;
					isArvCondominio = false;
					isMenuPrincipal = false;
					
				} else {
					menu.menuArvoreRemover(nomeArv);
					
				}
				
				break;

			case 3:
				// Créditos e Pesquisar
				if (isMenuPrincipal) {
					menu.creditos();

				} else {
					menu.menuArvorePesquisar(nomeArv);
				
				}
				break;

			case 4:
				// Exibir Árvore
				if (isMenuPrincipal) {
					format.mensagemTerminal(true, "Número informado fora das escolhas esperadas pelo sistema.");
					
				} else {
					menu.menuExibirArvore(nomeArv);
					
					if (arvCond.eVazia() && arvMorador.eVazia()) {
						format.mensagemTerminal(false, "A árvore está vazia");

					} else if (isArvCondominio) {
						vetorItemCond = arvCond.CamCentral();
						String msg=" ";

						for (int i=0; i<arvCond.getQuantNos();i++){
							msg+= "\n	" + (i + 1) + "° - " + vetorItemCond[i].getNomeCond() + ";";
						}

						System.out.println("| Exibir a árvore: " + msg);

					} else if (isArvMorador) {
						vetorItemMorador = arvMorador.CamCentral();
						String msg=" ";

						for (int i=0; i<arvMorador.getQuantNos();i++){
							msg+= "\n	" + (i + 1) + "° - " + vetorItemMorador[i].getNomeResonsavel() + ";";
						}

						System.out.println("| Exibir a árvore: " + msg);
					}
					menu.delay(3);
				}
				break;

			default:
				format.mensagemTerminal(true, "Número informado fora das escolhas esperadas pelo sistema.");
			
			}

			format.limparTerminal();
		
		} while (true);

		format.mensagemTerminal(false, "Finalizando o Programa...");

		entrada.close();
		System.exit(0);
	}

	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}

