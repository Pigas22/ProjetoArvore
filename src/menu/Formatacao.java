package menu;

import java.io.IOException;

import arvores.ArvoreCondominio;
import arvores.ArvoreMorador;
import dados.EnumSituacaoCondominio;
import dados.ItemCondominio;
import dados.ItemMorador;

public class Formatacao {
	private int numEspacamentoUni = 18;
	private String caracteres = "-="; // Mantenha 2 Caracteres
	
	
	public Formatacao() {
		// Usando somente para conseguir Instanciar a Classe nas outras Classes.
	}
	
	
	public void centralizar(String texto) {
		String strEspacamento = "";
		int tamanhoEspacamento = this.numEspacamentoUni * 2 - (texto.length() / 2); // Dobra do Tamanho do Espacamento
		
		for (int i = 0; i < tamanhoEspacamento; i++) {
			strEspacamento += " ";			
		}
		
		System.out.println(strEspacamento + " " +  texto);
	}
	
	public String centralizarItem (String texto) {
		String strEspacamento = "";
		int tamanhoEspacamento = this.numEspacamentoUni - texto.length(); // Dobra do Tamanho do Espacamento
		
		for (int i = 0; i < tamanhoEspacamento; i++) {
			strEspacamento += " ";			
		}
		
		return strEspacamento + texto;
	}
	
	
	public String centralizarItem (String texto, int tamanho) {
		String strEspacamento = "";
		int tamanhoEspacamento;
		
		if (texto.length() % 2 == 0) {
			tamanhoEspacamento = (tamanho - texto.length()) / 2;
			
		} else {
			texto+= " ";
			tamanhoEspacamento = (tamanho - texto.length()) / 2;
			
		}
		
		
		for (int i = 0; i < tamanhoEspacamento; i++) {
			strEspacamento += " ";			
		}
		
		return strEspacamento + texto + strEspacamento;
	}
	
	
    // Limpa o terminal, ainda em teste - Thiago
    public void limparTerminal() throws IOException, InterruptedException {
        //Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime();
        }
    }
    
	
	public String dadosArvore(ArvoreCondominio arvCond, ItemCondominio[] vetorItemCond) {
		vetorItemCond = arvCond.CamPreFixado();
		String msg = "";

		for (int i = 0; i < arvCond.getQuantNos(); i++){
			if (i % 2 == 0 && i != 0) {
				msg += "\n";
			}
						
			msg+= centralizarItem(vetorItemCond[i].getStrID(), 6) 
					+ " - " 
					+ centralizarItem(vetorItemCond[i].getNomeCond(), 14)
					+ " | ";
			
		}
		return msg;
	}
	
	
	public String dadosArvore(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		vetorItemMorador = arvMorador.CamPreFixado();
		String msg = "";
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			if (i % 2 == 0 && i != 0) {
				msg += "\n";
			}
						
			msg+= centralizarItem(vetorItemMorador[i].getStrID(), 6) 
					+ " - " 
					+ centralizarItem(vetorItemMorador[i].getNomeResonsavel(), 14)
					+ " | ";
		
		}
		return msg;
	}
	
	
	public String detalhaDadosArvore (ArvoreCondominio arvCond, ItemCondominio[] vetorItemCond) {
		String msgDetalhada = "";
		
		for (int i = 0; i < arvCond.getQuantNos(); i++){
			msgDetalhada += "\n" + vetorItemCond[i].toString() + ";\n";

		}
		
		return msgDetalhada;
	}

	
	public String detalhaDadosArvore(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = "";
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			msgDetalhada += "\n" + vetorItemMorador[i].toString() + ";\n";
			
		}
		
		return msgDetalhada;
	}
	
	
	public String tabelaAPsVagos(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = "";
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			if (vetorItemMorador[i] == null) {
				continue;
			}
			
			msgDetalhada += "\n " + centralizarItem(vetorItemMorador[i].getStrID(), 6) 
					+ " | " + centralizarItem(vetorItemMorador[i].getNomeResonsavel(), 14) 
					+ " | " + centralizarItem(Integer.toString(vetorItemMorador[i].getNumCond()), 6);
			
		}
		
		return msgDetalhada;
	}
	
	
	public String tabelaQuantMoradores(ArvoreMorador arvMorador, ItemMorador[] vetorItemMorador) {
		String msgDetalhada = "";
		int[] somaQuantMoradores = new int[5];
		int[] vetorCondID = new int[5];
		
		for (int i = 0; i < arvMorador.getQuantNos(); i++){
			if (vetorItemMorador[i] == null) {
				continue;
				
			}
			
			if (i == 0) {
				vetorCondID[i] = vetorItemMorador[i].getNumCond();
				somaQuantMoradores[i] += vetorItemMorador[i].getQuantMoradores();
				continue;
			} 

			for (int c = 0; c < vetorCondID.length; c++) {
				if (vetorItemMorador[i].getNumCond() == vetorCondID[c]) {
					somaQuantMoradores[c] += vetorItemMorador[i].getQuantMoradores();
					break;
					
				} else if (vetorCondID[c] == 0) {
					vetorCondID[c] = vetorItemMorador[i].getNumCond();
					break;
					
				} else {
					continue;
					
				}
			}
			
		}
		
		for (int f = 0; f < vetorCondID.length; f++) {
			if (vetorCondID[f] != 0) {
				msgDetalhada += "\n " 
						+ centralizarItem("" + vetorCondID[f], 18) 
						+ ": "
						+ centralizarItem("" + somaQuantMoradores[f], 22);
			}
		}
		
		return msgDetalhada;
	}
	
	
	public String tabelaSituacaoCond(ArvoreCondominio arvCond, ItemCondominio[] vetorItemCondominio) {
		String msgDetalhada = "";
		
		String nomeCond;
		String itemPlanta;

		String itemAVenda;
		String itemEdificado;
		
		String itemEmConstrucao;
		String itemSemClassificacao;
		
		EnumSituacaoCondominio itemSituacao;
		
		String[] vetorPLANTA = new String[8];
		String[] vetorA_VENDA = new String[8];
		
		String[] vetorEDIFICADO = new String[8];
		String[] vetorEM_CONSTRUCAO = new String[8];
		
		String[] vetorSEM_CLASSIFICACAO = new String[10];
		

		for (int i = 0; i < arvCond.getQuantNos(); i++){
			if (vetorItemCondominio[i] == null) {
				continue;
			}
			
			itemSituacao = vetorItemCondominio[i].getSituacaoCondominio();
			nomeCond = vetorItemCondominio[i].getNomeCond();
		
				
			if (itemSituacao == EnumSituacaoCondominio.PLANTA) {
				if (vetorPLANTA[0] == null) {
					vetorPLANTA[0] = nomeCond;
				
				} else {
					vetorPLANTA[vetorPLANTA.length] = nomeCond;
					
				}
				
			} else if (itemSituacao == EnumSituacaoCondominio.A_VENDA) {
				if (vetorPLANTA[0] == null) {
					vetorA_VENDA[0] = nomeCond;
				
				} else {
					vetorA_VENDA[vetorA_VENDA.length] = nomeCond;
					
				}
				
			} else if (itemSituacao == EnumSituacaoCondominio.EDIFICADO) {
				if (vetorPLANTA[0] == null) {
					vetorEDIFICADO[0] = nomeCond;
					
				} else {
					vetorEDIFICADO[vetorEDIFICADO.length] = nomeCond;
				}
				
			} else if (itemSituacao == EnumSituacaoCondominio.EM_CONSTRUCAO) {
				if (vetorPLANTA[0] == null) {
					vetorEM_CONSTRUCAO[0] = nomeCond;

				} else {
					vetorEM_CONSTRUCAO[vetorEM_CONSTRUCAO.length] = nomeCond;
				
				}
				
			} else if (itemSituacao == EnumSituacaoCondominio.SEM_CLASSIFICACAO) {
				if (vetorPLANTA[0] == null) {
					vetorSEM_CLASSIFICACAO[0] = nomeCond;}
				
				else {
					vetorSEM_CLASSIFICACAO[vetorSEM_CLASSIFICACAO.length] = nomeCond;
				}
				
			} else {
				continue;
				
			}
		}
		
		for (int f = 0; f < arvCond.getQuantNos(); f++) {
			msgDetalhada += "\n";
			
			
			if (vetorPLANTA[f] == null) {
				itemPlanta = "Nulo";
				
			} else {
				itemPlanta = vetorPLANTA[f];
				
			}
			
			if (vetorA_VENDA[f] == null) {
				itemAVenda = "Nulo";
				
			} else {
				itemAVenda = vetorA_VENDA[f];
				
			}
			
			if (vetorEDIFICADO[f] == null) {
				itemEdificado = "Nulo";
				
			} else {
				itemEdificado = vetorEDIFICADO[f];
				
			}
			
			if (vetorEM_CONSTRUCAO[f] == null) {
				itemEmConstrucao = "Nulo";
				
			} else {
				itemEmConstrucao = centralizarItem(vetorEM_CONSTRUCAO[f], 15) + " | ";
				
			}
			
			if (vetorSEM_CLASSIFICACAO[f] == null) {
				itemSemClassificacao = "Nulo";
				
			} else {
				itemSemClassificacao= vetorSEM_CLASSIFICACAO[f];
				
			}
			
			
			msgDetalhada += centralizarItem(itemPlanta, 10) + "  | "
							+ centralizarItem(itemEdificado, 10) + "| " 
							+ centralizarItem(itemAVenda, 11) + "  |   "
							+ centralizarItem(itemEmConstrucao, 13) + "  |  "
							+ centralizarItem(itemSemClassificacao, 15);
			
		}
		
		return msgDetalhada;
	
	}
	
	
	public String tabelaAdmXCond(ArvoreCondominio arvCond, ItemCondominio[] vetorItemCondominio) {
		String msgDetalhada = "";
		
		String[] nomeAdms = new String[5];
		String[] nomeCond = new String [5];
		
		int contAdm = 0;
		
		for (int f = 0; f < nomeAdms.length; f++) {
			nomeAdms[contAdm] = vetorItemCondominio[f].getAdm();
			
			for (int i = 0; i < arvCond.getQuantNos(); i++){
				if (vetorItemCondominio[i] == null) {
					continue;
					
				}
				
				nomeCond[i] = vetorItemCondominio[i].getNomeCond();
			}
			
			contAdm++;
		}
		

		for (int t = 0; t < 0;) {
			msgDetalhada += centralizarItem(nomeAdms[t], 18) + " | ";
			
			for (int f = 0; f < vetorItemCondominio.length; f++) {
				msgDetalhada += "\n";
				msgDetalhada += centralizarItem(nomeCond[f], 18) + " | ";
				
			}
		}
		
		return msgDetalhada;
	}
	
	
	public int getNumEspacamentoUni() {
		return numEspacamentoUni;
	}
	public void setNumEspacamentoUni(int numEspacamentoUni) {
		this.numEspacamentoUni = numEspacamentoUni;
	}

	
	public String getCaracteres() {
		return caracteres;
	}
	public void setCaracteres(String caracteres) {
		this.caracteres = caracteres;
	}

	/*
	 * Diogo Rocha da Silva Pelanda
	 * Thiago Holz Coutinho
	 * Vinicius Rocha Aleixo
	 * 
	 * Copyright TVD
	 */
}
