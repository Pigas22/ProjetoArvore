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
		int id, quantAP, quantMoradores, numCond;
		String nomeCond, adm, endereco, nomeResponsavel, strMaisDetalhes;

		char maisDetalhes;
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
					nomeArv = arvCond.getNOME();

				} else if (isArvMorador) {
					nomeArv = arvMorador.getNOME();
					
				}
			}


			switch (escolhaInt) {
			case 0: 
				if (!isMenuPrincipal) {
					isMenuPrincipal = true;
					isArvCondominio = false;
					isArvMorador = false;
					
					menu.titulo("Voltar");

				}
				break;

			case 1:
				// Árvore Condomínios e Inserir
				if (isMenuPrincipal) {
					isArvCondominio = true;
					isMenuPrincipal = false;
					isArvMorador = false;

				} else {
					menu.titulo("Inserir - Árvore " + nomeArv);
					
					if (isArvCondominio) {
						// Perguntar valores para inserir na Arvore Condominio
						System.out.print(" | Número de Identificação (ID): ");
						id = entrada.nextInt();
						
						System.out.print(" | Nome do Condomínio: ");
						entrada.nextLine();
						nomeCond = entrada.nextLine().strip();

						System.out.print(" | Administrador do Condomínio: ");
						adm = entrada.nextLine().strip();

						System.out.print(" | Endereço: ");
						endereco = entrada.nextLine().strip();

						System.out.print(" | Quantidade de Apartamentos: ");
						quantAP = entrada.nextInt();

						menu.linha();
						
						if (!endereco.equals("")) {
							if (arvCond.inserir(new ItemCondominio(id, nomeCond, adm, endereco, quantAP))){
								menu.mensagemTerminal(false, "Inserção efetuada com sucesso...");

							} else {
								menu.mensagemTerminal(true, "Inserção não efetuada, valor já existe");
							
							}		
						} else {
							if (arvCond.inserir(new ItemCondominio(id, nomeCond, adm, quantAP))){
								menu.mensagemTerminal(false, "Inserção efetuada com sucesso...");

							} else {
								menu.mensagemTerminal(true, "Inserção não efetuada, valor já existe");

							}							
						}

					} else if (isArvMorador) {
						// Perguntar valores para inserir na Arvore Morador
						System.out.print(" | Número de Identificação (ID): ");
						id = entrada.nextInt();
						
						System.out.print(" | Nome do Responsável: ");
						entrada.nextLine();
						nomeResponsavel = entrada.nextLine().strip();

						System.out.print(" | Quantidade de Moradores: ");
						quantMoradores = entrada.nextInt();

						System.out.print(" | Número do Condomínio: ");
						numCond = entrada.nextInt();

						menu.linha();
						
						if (arvMorador.inserir(new ItemMorador(id, nomeResponsavel, quantMoradores, numCond))){
							menu.mensagemTerminal(false, "Inserção efetuada com sucesso...");

						} else {
							menu.mensagemTerminal(false, "Inserção efetuada com sucesso...");
							
						}
					} else {
						menu.linha();
						menu.mensagemTerminal(true, "Problema inesperado, retornando ao menu principal.");

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
					boolean removeu;
					menu.titulo("Remover - Árvore " + nomeArv);
					
					if (arvCond.eVazia() && arvMorador.eVazia()){
						menu.mensagemTerminal(true, nomeArv);
						System.out.println("Arvore está vazia");

						menu.delay(3);

						break;

					} else if (isArvCondominio || isArvMorador) {

						System.out.print(" | Número de Identificação (ID): ");
						id = entrada.nextInt();

						if (isArvCondominio) {
							removeu = arvCond.remover(id);
							
						} else {
							removeu = arvMorador.remover(id);

						}

						menu.linha();

						if (removeu){
							menu.mensagemTerminal(false, "Remoção efetuada com sucesso...");

						}else{
							menu.mensagemTerminal(true, "Remoção não efetuada, valor não encontrado...");

						}

					} else {
						menu.mensagemTerminal(true, "Erro inexperado, retornando ao menu principal.");

					}

					menu.delay(5);
				}
				
				break;

			case 3:
				// Créditos e Pesquisar
				if (isMenuPrincipal) {
					menu.creditos();

				} else {
					menu.titulo("Pesquisar - Árvore " + nomeArv);
				
				}
				break;

			case 4:
				// Exibir Árvore
				if (isMenuPrincipal) {
					menu.mensagemTerminal(true, "Número informado fora das escolhas esperadas pelo sistema.");
					
				} else {
					if (arvCond.eVazia() && arvMorador.eVazia()) {
						menu.mensagemTerminal(true, "A árvore está vazia");

						menu.delay(3);

						break;

					} else if (isArvCondominio) {
						vetorItemCond = arvCond.CamCentral();

						menu.exibirArvore(arvCond, vetorItemCond);
						
					} else if (isArvMorador) {
						vetorItemMorador = arvMorador.CamCentral();
						
						menu.exibirArvore(arvMorador, vetorItemMorador);
					}

					menu.delay(2);
					
					System.out.print("Exibir mais detalhes? [S/N] ");
					maisDetalhes = entrada.next().toUpperCase().charAt(0);
					strMaisDetalhes = Character.toString(maisDetalhes).toUpperCase();
					
					
					if (strMaisDetalhes.equals("S")) {
						format.limparTerminal();

						if (isArvCondominio) {
							menu.exibirDetalhesArvore(arvCond, vetorItemCond);
							
						} else if (isArvMorador) {
							menu.exibirDetalhesArvore(arvMorador, vetorItemMorador);
							
						}
					}
					menu.delay(8);
				}
				break;

			default:
				menu.mensagemTerminal(true, "Número informado fora das escolhas esperadas pelo sistema.");
			
			}

			format.limparTerminal();
		
		} while (true);

		menu.mensagemTerminal(false, "Finalizando o Programa...");

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

