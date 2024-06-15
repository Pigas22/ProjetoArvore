package menu;

import java.util.ArrayList;
import java.util.Scanner;

import arvores.NoArvCondominio;

public class MenuPrincipal {
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
		Scanner input = new Scanner(System.in);
		
		System.out.println(
				"-=-=-=-=-=-=-=-= Menu =-=-=-=-=-=-=-=-=-"
				+ "[ 0 ] - Sair"
				+ "[ 1 ] - Inserir"
				+ "[ 2 ] - Remover"
				+ "[ 3 ] - Pesquisar"
				+ "[ 4 ] - Caminhamento"
			);
		
		
		
		input.close();
	}
	
	public void caminhamento(int escolha) {
		
	}
}
