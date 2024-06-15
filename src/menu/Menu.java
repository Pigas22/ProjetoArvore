package menu;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
	static Scanner entrada = new Scanner(System.in);
	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */

	/*
	 * Inserir (Condominio, Morador)
	 * Pesquisar (APs Vagas, QuantTotal de Pss)
	 * Remover (Condominio, Morador)
	 * Caminhamento
	 * 	- pre fixado
	 * 	- central
	 * 	- pos fixado
	 */
	public static void main(String[] args) {
		int escolha;

		do {
			escolha = menuPrincipal();
			abreEscolha(escolha);
			
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");	
			

		} while (escolha != 0);

		System.out.println("[INFO] - Finalizando o Programa...");	
		
		entrada.close();
	}


	public static int menuPrincipal () {
		int escolha;

		System.out.println(
				"-=-=-=-=-=-=-=-= Menu =-=-=-=-=-=-=-=-=-"
				+ "\n[ 0 ] - Sair"
				+ "\n[ 1 ] - Inserir"
				+ "\n[ 2 ] - Remover"
				+ "\n[ 3 ] - Pesquisar"
				+ "\n[ 4 ] - Caminhamento"
				+ "\n[ 9 ] - Créditos"
				+ "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"
				);

		System.out.print("Sua Escolha: ");
		escolha = entrada.nextInt();

		if (escolha != 9) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");			
		}

		return escolha;
	}

	public static void abreEscolha(int escolha) {
		switch (escolha) {
		case 1:
			// Inserir
			break;

		case 2:
			// Remover
			break;

		case 3:
			// Pesquisar
			break;

		case 4:
			// Caminhamento
			break;

		case 9:
			// Créditos
			creditos();
			break;

		default:
			System.out.println("[ERRO] - Número informado fora das escolhas esperadas pelo sistema.");
		}
	}

	public static void creditos() {
		System.out.println("-=-=-=-=-=-=-=-=-= Créditos =-=-=-=-=-=-=-=-"
						+ "\nDiogo Rocha da Silva Pelanda"
						+ "\nThiago Holz Coutinho"
						+ "\nVinicius Rocha Aleixo"
						+ "\n"
						+ "\n©️ Copyright TVD 2024"
		);
		System.out.print("Continuar? [S/N]");
		entrada.next();
	}
}
