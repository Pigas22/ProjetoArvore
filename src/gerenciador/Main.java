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
		int idCond, idMorador, quantAP, quantMoradores, numAP, numCond;
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
					menu.menuArvoreInserir(nomeArv);
					
					if (isArvCondominio) {
						// Perguntar valores para inserir na Arvore Condominio
						System.out.print(" | Número de Identificação (ID): ");
						idCond = entrada.nextInt();
						
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
							if (arvCond.inserir(new ItemCondominio(idCond, nomeCond, adm, endereco, quantAP))){
								format.mensagemTerminal(false, "Inserção efetuada com sucesso...");

							} else {
								format.mensagemTerminal(true, "Inserção não efetuada, valor já existe");
							
							}		
						} else {
							if (arvCond.inserir(new ItemCondominio(idCond, nomeCond, adm, quantAP))){
								format.mensagemTerminal(false, "Inserção efetuada com sucesso...");

							} else {
								format.mensagemTerminal(true, "Inserção não efetuada, valor já existe");

							}							
						}

					} else if (isArvMorador) {
						// Perguntar valores para inserir na Arvore Morador
						System.out.print(" | Número de Identificação (ID): ");
						idMorador = entrada.nextInt();
						
						System.out.print(" | Nome do Responsável: ");
						entrada.nextLine();
						nomeResponsavel = entrada.nextLine().strip();

						System.out.print(" | Quantidade de Moradores: ");
						quantMoradores = entrada.nextInt();

						System.out.print(" | Número Apartamento: ");
						numAP = entrada.nextInt();

						System.out.print(" | Número do Condomínio: ");
						numCond = entrada.nextInt();

						menu.linha();
						
						if (arvMorador.inserir(new ItemMorador(idMorador, nomeResponsavel, quantMoradores, numAP, numCond))){
							format.mensagemTerminal(false, "Inserção efetuada com sucesso...");

						} else {
							format.mensagemTerminal(false, "Inserção efetuada com sucesso...");
							
						}
					} else {
						menu.linha();
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
					String strID;
					String msg=" ";
					int i = 0;
					
					if (arvCond.eVazia() && arvMorador.eVazia()) {
						format.mensagemTerminal(true, "A árvore está vazia");
						break;

					} else if (isArvCondominio) {
						vetorItemCond = arvCond.CamCentral();

						for (i = 0; i < arvCond.getQuantNos(); i++){
							strID = Integer.toString(vetorItemCond[i].getIdCond());
							
							msg+= "\n" + format.centralizarTabela(strID) + " - " + vetorItemCond[i].getNomeCond() + ";";

						}
					} else if (isArvMorador) {
						vetorItemMorador = arvMorador.CamCentral();
						
						for (i = 0; i < arvMorador.getQuantNos(); i++){
							strID = Integer.toString(vetorItemMorador[i].getIdMorador());
							
							msg+= "\n" + format.centralizarTabela(strID) + " - " + vetorItemMorador[i].getNomeResonsavel() + ";";
						
						}
					}
					System.out.println("| Exibir a árvore: "
							+ "\n" + format.centralizarTabela("[ID]") + " - [Nome]"
							+ msg);
					
					
					menu.delay(2);
					menu.linha();
					
					System.out.print("Exibir mais detalhes? [S/N] ");
					maisDetalhes = entrada.next().toUpperCase().charAt(0);
					strMaisDetalhes = Character.toString(maisDetalhes).toUpperCase();
					
					format.limparTerminal();
					
					if (strMaisDetalhes.equals("S")) {
						String msgDetalhada = "";
						
						if (isArvCondominio) {
							for (i = 0; i < arvCond.getQuantNos(); i++){
								msgDetalhada += "\n" + vetorItemCond[i].toString() + ";\n";

							}
						} else if (isArvMorador) {
							for (i = 0; i < arvMorador.getQuantNos(); i++){
								msgDetalhada += "\n" + vetorItemMorador[i].toString() + ";\n";
							
							}
						}
						System.out.println("| Exibir Detelhes: "
								+ "\n" + msgDetalhada);
						
						menu.linha();
					}
					
					menu.delay(8);
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

