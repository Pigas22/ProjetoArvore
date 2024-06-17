package teste;

import java.io.IOException;
import java.util.Scanner;

import arvores.ArvoreCondominio;
import arvores.ArvoreMorador;
import dados.ItemCondominio;
import dados.ItemMorador;
import menu.Formatacao;
import menu.Menu;

public class TestePigas {
	static Formatacao format = new Formatacao();
	static Scanner entrada = new Scanner(System.in);
	static Menu menu = new Menu();


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

		boolean isMenuPrincipal = true;
		boolean isArvCondominio = false;
		boolean isArvMorador = false;
		
		char escolha;
		int escolhaInt = 0;


		do {
			if (isMenuPrincipal) {
				menu.menuPrincipal();

			} else if (isArvCondominio) {
				menu.menuArvore("Condomínios");
				
			} else if (isArvMorador) {
				menu.menuArvore("Moradores");
				
			}
			
			System.out.print("| Informe sua escolha: ");
			escolha = entrada.next().charAt(0);
			escolhaInt = Integer.parseInt(String.valueOf((char)escolha));


			if (isMenuPrincipal) {
				if (escolhaInt == 0) {
					break;

				}
			}

			switch (escolhaInt) {
			case 0: 
				if (!isMenuPrincipal) {
					isMenuPrincipal = true;
					isArvCondominio = false;
					
				}
				break;

			case 1:
				// Árvore Condomínios e Inserir
				if (isMenuPrincipal) {
					isArvCondominio = true;
					isMenuPrincipal = false;

				} else {
					if (isArvCondominio) {
						// Perguntar valores para inserir na Arvore Condominio
						System.out.print(" | Nome do Condomínio: ");
						nomeCond = entrada.next();
						entrada.next();

						System.out.print(" | Administrador do Condomínio: ");
						adm = entrada.next();

						System.out.print(" | Endereço: ");
						endereco = entrada.next();

						System.out.print(" | Quantidade de Apartamentos:");
						quantAP = entrada.nextInt();

						if (endereco.equals("")) {
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
				}
				break;

			case 2: 
				break;
				
			case 3:
				// Créditos e Pesquisar
				if (isMenuPrincipal) {
					menu.creditos();
					
				} 
				break;

			case 4:
				// Exibir Árvore
				if (!isMenuPrincipal) {
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
					}
				}
				break;

			default:
				System.out.println("[ERRO] - Número informado fora das escolhas esperadas pelo sistema.");
				
			}			
			format.limparTerminal();
		} while (true);

		System.out.println("[INFO] - Finalizando o Programa...");	

		entrada.close();
		System.exit(0);
	}
	/*
	 * Thiago Holz Coutinho
	 * 
	 * Copyright Pigas22
	 */
}