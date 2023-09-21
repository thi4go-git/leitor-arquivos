package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String caminhoTXT = "./arquivos/ARQ.txt";
        String caminhoPDF = "./arquivos/Arquivo pdf.pdf";

        Leitor leitor = new Leitor(caminhoTXT);

        List<String> linhas = leitor.lerArquivo();

    }
}