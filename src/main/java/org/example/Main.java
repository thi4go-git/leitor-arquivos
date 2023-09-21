package org.example;

public class Main {
    public static void main(String[] args) {

        String arqTxt = "arquivos/ARQ.txt";
        String arqPdf = "arquivos/Arquivo pdf.pdf";

        Leitor leitor = new Leitor(arqPdf);
        leitor.lerArquivo();

    }
}