package menu;


import java.io.File; // Torna possível manipular o arquivo;
import java.io.FileNotFoundException; // Identificar erros nos arquivos;
import java.io.BufferedWriter; // Armazena um dado em um Buffer(Quantidade de memória);
import java.io.FileWriter; // Gravar os dados no arquivo .txt;
import java.io.IOException; // Identificar um erro na hora de gravar o arquivo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class GerenciadorArquivos {
    private String caminhoArquivoArvCondominio = "ArvoreCondominio.txt";
    private String caminhoArquivoArvMorador = "ArvoreMorador.txt";

    public GerenciadorArquivos() {
        try {
            File jogadores = new File(caminhoArquivoArvCondominio);
            // Cria o arquivo caso não exista
            if (!jogadores.exists()) {
                jogadores.createNewFile();
            }
            File resultados = new File(caminhoArquivoArvMorador);
            if (!resultados.exists()) {
                resultados.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("| Erro ao criar os arquivos |");
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