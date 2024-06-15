package menu;


import java.util.Scanner;

import arvores.ArvoreCondominio;
import arvores.ArvoreMorador;
import dados.ItemCondominio;

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
	static boolean isArvoreCond = false;
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
		"Caminhamento",
	};
	
	
	public static void main(String[] args) {
		ArvoreCondominio arvCond = new ArvoreCondominio();
		ArvoreMorador arvMorador = new ArvoreMorador();
				
		char escolha;
		int escolhaInt;
		
		int valor;

		do {
			menuPrincipal();
			escolha = entrada.next().charAt(0);

			escolhaInt = Integer.parseInt(String.valueOf((char)escolha));
			
			if (escolha <= '5') {
				format.titulo(OpcMenuPrin[escolha]);
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
				}
				
				else if (isMenuArvore) {
					if (isArvoreCond) {
						// Perguntar valores para inserir na Arvore Condominio
						System.out.println("Inserir um Valor na árvore\n"+
								"Digite um valor");
						valor = entrada.nextInt();
						
						
						
						
						
						if (arvCond.inserir(new ItemCondominio())){
							System.out.println("inserção efetuada com sucesso");
						}else{
							System.out.println("inserção não efetuada, "+
									"valor já existe");
						}					
						
					}
				}
				break;

			case '2':
				// Árvore Moradores e Remover
				break;

			case '3':
				// Pesquisar
				break;

			case '4':
				// Caminhamento
				break;

			case '5':
				// Créditos
				creditos();
				break;

			default:
				System.out.println("[ERRO] - Número informado fora das escolhas esperadas pelo sistema.");
			}			

		} while (escolha != '0' || !isMenuArvore);

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
						+ "\n[ 4 ] - Caminhamento");

		format.linha();
	}	
	
	

	public static void creditos() {
		System.out.println("Diogo Rocha da Silva Pelanda"
						+ "\nThiago Holz Coutinho"
						+ "\nVinicius Rocha Aleixo"
						+ "\n"
						+ "\n©️ Copyright TVD 2024");
		
		format.linha(); 
		
		System.out.print("Continuar? [S/N] ");
		entrada.next();
	}

	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}
