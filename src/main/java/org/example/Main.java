package org.example;

public class Main {
    public static void main(String[] args) {

        String arqTxt = "ARQ.txt";
        String arqPdf = "texto.txt";

        Leitor leitor = new Leitor(arqTxt);
        leitor.lerArquivo();

    }
}