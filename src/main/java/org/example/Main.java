package org.example;

public class Main {
    public static void main(String[] args) {

        String caminhoTXT = "arquivos/ARQ.txt";
        String caminhoPDF = "arquivos/Arquivo pdf.pdf";

        Leitor leitor = new Leitor(caminhoTXT);
        leitor.lerArquivo();

    }
}