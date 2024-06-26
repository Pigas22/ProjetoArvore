package gerenciador;


import java.io.IOException;
import java.util.Scanner;

import arvores.ArvoreCondominio;
import arvores.ArvoreMorador;
import dados.ItemCondominio;
import dados.ItemMorador;
import menu.Formatacao;
import menu.Menu;


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

		int idAlterar = 0;
		
		ItemCondominio[] vetorItemCond; 
		ItemMorador[] vetorItemMorador;

		boolean isMenuPrincipal = true;
		
		boolean isMenuPesquisa = false;
		boolean isMenuAlterar = false;
		
		boolean isArvCondominio = false;
		boolean isArvMorador = false;
		
		int escolhaInt = 0;

		
		// Tela de Configurações
		boolean carregarDados = menu.menuInicial();
		
		if (carregarDados) {
			arvCond.inserirDadosPadroes();
			arvMorador.inserirDadosPadroes();
			
			menu.mensagemTerminal(false, "Dados Carregados com sucesso.");
		
			vetorItemCond = new ItemCondominio[arvCond.getQuantNos()]; 
			vetorItemMorador = new ItemMorador[arvMorador.getQuantNos()];
			
		} else {
			menu.mensagemTerminal(false, "Ávores inicializadas vazias.");
			
			vetorItemCond = new ItemCondominio[1]; 
			vetorItemMorador = new ItemMorador[1];
			
		}
		
			
		menu.delay(2);
		
		format.limparTerminal();
		
		
		do {
			if (isMenuPrincipal) {
				menu.menuPrincipal();

			} else if (isMenuAlterar) {
				menu.menuAlterar(nomeArv);
				
			} else if (isMenuPesquisa) {
				menu.menuPesquisar(nomeArv);
				
			} else {
				menu.menuArvore(nomeArv);

			} 
			
			
			try {
				System.out.print("| Informe sua escolha: ");
				escolhaInt = Integer.parseInt(String.valueOf((char)entrada.next().charAt(0)));
					
			} catch (NumberFormatException erroInput) {
				format.limparTerminal();
				
				menu.mensagemTerminal(true, "Resposta Inexperada, tente novamente...");
				menu.delay(2);
				
				continue;
				
			} finally {
				format.limparTerminal();
				
			}

			
			if (isMenuPrincipal) {
				if (escolhaInt == 0) {
					break;

				}
			} else if (isArvCondominio) {
				nomeArv = arvCond.getNOME();

			} else if (isArvMorador) {
				nomeArv = arvMorador.getNOME();
				
			}
			

			switch (escolhaInt) {
			case 0: 
				menu.titulo("Voltar");

				if (isMenuAlterar) {
					isMenuAlterar = false;
					
				} else if (isMenuPesquisa) {
					isMenuPesquisa = false;
					
				} else if (!isMenuPrincipal) {
					isMenuPrincipal = true;
					isArvCondominio = false;
					isArvMorador = false;
					
				}
				
				menu.delay(1);
				
				break;

				
			case 1:
				if (isMenuPrincipal) {
					// Árvore Condomínios
					isArvCondominio = true;
					isMenuPrincipal = false;
					isArvMorador = false;

				} else if (isMenuPesquisa) {
					// MenuPesquisar - Arv Condominio e Morador 
					
					if (isArvCondominio) {
						
						
					} else if (isArvMorador) {
						// Arv Morador (Apartamentos Vagos) 
						vetorItemMorador = arvMorador.CamCentralPersonalizado(true);
						
						if (vetorItemMorador.length > 0) {
							menu.titulo("Apartamentos Vagos");
							
							format.centralizar(menu.exibirPesqAPsVagos(arvMorador, vetorItemMorador));
							
							menu.linha();
							
						} else {
							menu.mensagemTerminal(true, "Nenhum Apartamento Vago Encontrado.");
							
						}
						
						menu.delay(3);
						
					}
					
					
				} else if (isMenuAlterar) {
					// MenuAlterar (Nome do condominio ou responsavel)
					String novoNome;
					
					menu.titulo("Alterar - Árvore " + nomeArv);
					
					System.out.print(" | Novo nome: ");
					entrada.nextLine();
					novoNome = entrada.nextLine().strip();
					
					
					if (isArvCondominio) {
						ItemCondominio dado = arvCond.pesquisarComRetorno(idAlterar);
						
						dado.setNomeCond(novoNome);

						
					} else if (isArvMorador) {
						ItemMorador dado = arvMorador.pesquisarComRetorno(idAlterar);
						
						dado.setNomeResonsavel(novoNome);
					}
					
					menu.mensagemTerminal(false, "Nome alterado com sucesso.");
					
				} else {
					//Inserir
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


						if (!endereco.equals("")) {
							if (arvCond.inserir(new ItemCondominio(id, nomeCond, adm, quantAP, endereco))){
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

						if (arvMorador.inserir(new ItemMorador(id, nomeResponsavel, quantMoradores, numCond))){
							menu.mensagemTerminal(false, "Inserção efetuada com sucesso...");

						} else {
							menu.mensagemTerminal(false, "Inserção efetuada com sucesso...");
							
						}
					} else {
						menu.mensagemTerminal(true, "Problema inesperado, retornando ao menu principal.");

					}
					
					menu.delay(2);
				}
				break;

				
			case 2:
				if (isMenuPrincipal) {
					// Árvore Moradores
					isArvMorador = true;
					isArvCondominio = false;
					isMenuPrincipal = false;
					
				} else if (isMenuPesquisa) {
					// MenuPesquisar - Arv Condominio e Morador 
					
					if (isArvCondominio) {
						
						
					} else if (isArvMorador) {
						// Arv Morador (Quantidade de Moradores) 
						vetorItemMorador = arvMorador.CamCentral();
						
						if (vetorItemMorador.length > 0) {
							menu.titulo("Quantidade de Moradores - TOP 5");
							
							format.centralizar(menu.exibirPesqQuantMoradores(arvMorador, vetorItemMorador));
							
						} else {
							menu.mensagemTerminal(true, "A árvore está vazia");
							
						}
						
						menu.delay(3);
						
					}
					
					
				} else if (isMenuAlterar) {
					// MenuAlterar (Nome do Administrador ou Qtd de Moradores)
					String msg = "";
					menu.titulo("Alterar - Árvore " + nomeArv);
					
					if (isArvCondominio) {
						String novoAdm;
						
						System.out.print(" | Novo Administrador: ");
						entrada.nextLine();
						novoAdm = entrada.nextLine().strip();
						
						ItemCondominio dado = arvCond.pesquisarComRetorno(idAlterar);
						dado.setNomeCond(novoAdm);
							
						msg = "Admnistrador";
						
					} else if (isArvMorador) {
						int novaQtd;
						
						System.out.print(" | Novo número de Moradores: ");
						novaQtd = entrada.nextInt();
						
						ItemMorador dado = arvMorador.pesquisarComRetorno(idAlterar);
						dado.setQuantMoradores(novaQtd);
							
						msg = "Número de Moradores";
					}
					
					menu.mensagemTerminal(false, msg + " alterado com sucesso.");
					
				} else {
					// Remover
					boolean removeu;
					menu.titulo("Remover - Árvore " + nomeArv);
					
					if (arvCond.eVazia() && arvMorador.eVazia()){
						menu.mensagemTerminal(true, "A árvore está vazia");

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
				if (isMenuPesquisa) {
					menu.mensagemTerminal(true, "Número informado fora das escolhas esperadas pelo sistema.");
					menu.delay(2);
					
				} else if (isMenuPrincipal) {
					// Créditos
					menu.creditos();

				} else if (isMenuAlterar) {
					// MenuAlterar (Endereco e Número do Condominio) 
					String msg = "";
					
					menu.titulo("Alterar - Árvore " + nomeArv);
					
					if (isArvCondominio) {
						String novoEndereco;
						
						System.out.print(" | Novo Endereço: ");
						entrada.nextLine();
						novoEndereco = entrada.nextLine().strip();
						
						ItemCondominio dado = arvCond.pesquisarComRetorno(idAlterar);
						dado.setNomeCond(novoEndereco);
							
						msg = "Endereco";
						
					} else if (isArvMorador) {
						int novoCond;
						
						System.out.print(" | Novo número de Condomínio: ");
						novoCond = entrada.nextInt();
						
						ItemMorador dado = arvMorador.pesquisarComRetorno(idAlterar);
						dado.setQuantMoradores(novoCond);
							
						msg = "Número do Condomínio";
					}
					
					menu.mensagemTerminal(false, msg + " alterado com sucesso");
					
				} else if (isArvCondominio || isArvMorador) {
					// Alterar
					
					if (arvCond.eVazia() && arvMorador.eVazia()) {
						menu.mensagemTerminal(true, "A árvore está vazia");
						
						menu.delay(3);
						
						break;
					}
					
					isMenuAlterar = true;
					boolean encontrou = false;
					
					menu.titulo("Alterar - Árvore " + nomeArv);
					System.out.print(" | Número de Identificação do Item à ser alterado: ");
					id = entrada.nextInt();
					
					menu.linha();
					menu.delay(1);
					
					format.limparTerminal();
					
					menu.menuAlterar(nomeArv);
					
					if (isArvCondominio) {
						encontrou = arvCond.pesquisar(id);
						
					} else if (isArvMorador) {
						encontrou = arvMorador.pesquisar(id);						
						
					}
					
					
					if (!encontrou) {
						menu.delay(2);
						
						menu.mensagemTerminal(true, "Item não encontrado.");
						
						continue;
					}
					
					idAlterar = id;
					
				}
				break;
				
				
			case 4: 
				if (isMenuPrincipal || isMenuPesquisa) {
					menu.mensagemTerminal(true, "Número informado fora das escolhas esperadas pelo sistema.");
					menu.delay(2);
					
				} else if (isMenuAlterar) {
					// MenuAlterar (Quantidade de AP's e Disponibilidade) 
					String msg = "";
					
					menu.titulo("Alterar - Árvore " + nomeArv);
					
					if (isArvCondominio) {
						int novaQtd;
						
						System.out.print(" | Nova Quantidade de Apartamentos: ");
						novaQtd = entrada.nextInt();
						
						ItemCondominio dado = arvCond.pesquisarComRetorno(idAlterar);
						dado.setQuantAP(novaQtd);
							
						msg = "Quantidade de AP's";
						
					} else if (isArvMorador) {
						boolean novaDisponibilidade;
						
						System.out.print(" | Disponibilidade Atual: ");
						novaDisponibilidade = entrada.nextBoolean();
						
						ItemMorador dado = arvMorador.pesquisarComRetorno(idAlterar);
						dado.setIsVago(novaDisponibilidade);
							
						msg = "Disponibilidade";
					}
					
					menu.mensagemTerminal(false, msg + " alterada com sucesso.");
					
				} else {
					// Pesquisar
					isMenuPesquisa = true;
					
				}
				break;
		

			case 5:
				// Exibir Árvore
				if (isMenuPrincipal || isMenuAlterar || isMenuPesquisa) {
					menu.mensagemTerminal(true, "Número informado fora das escolhas esperadas pelo sistema.");
					menu.delay(2);

				} else {
					if (arvCond.eVazia() && arvMorador.eVazia()) {
						menu.mensagemTerminal(true, "A árvore está vazia");

						menu.delay(2);

						break;

					} else if (isArvCondominio) {
						vetorItemCond = arvCond.CamCentral();

						menu.exibirArvore(arvCond, vetorItemCond);
						
					} else if (isArvMorador) {
						vetorItemMorador = arvMorador.CamCentral();
						
						menu.exibirArvore(arvMorador, vetorItemMorador);
					}
					
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
						menu.delay(8);
						
					} else {
						menu.delay(2);

					}
				}
				break;
				

			default:
				menu.mensagemTerminal(true, "Número informado fora das escolhas esperadas pelo sistema.");
				menu.delay(1);

				menu.mensagemTerminal(false, "Retorando ao Menu, aguarde...");
				menu.delay(2);
			
			}
			
			if ((isArvCondominio || isArvMorador)
					&& (escolhaInt == 1 || escolhaInt == 2) ) {
				vetorItemCond = new ItemCondominio[arvCond.getQuantNos()]; 
				vetorItemMorador = new ItemMorador[arvMorador.getQuantNos()];
				
			}
			
			
			format.limparTerminal();
		
		} while (true);
		
		
		menu.titulo("Créditos");

		format.centralizar("Diogo Rocha da Silva Pelanda");
		format.centralizar("Thiago Holz Coutinho");
		format.centralizar("Vinicius Rocha Aleixo");
		System.out.println("\n© Copyright TVD 2024");

		menu.delay(1);
		menu.mensagemTerminal(false, "Finalizando o Programa...");

		menu.delay(3);
		format.limparTerminal();
		
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

