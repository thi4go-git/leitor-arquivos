package org.example;

import java.io.File;

public class Leitor {
    private String path;

    public Leitor(String path) {
        this.path = path;
    }

    public void lerArquivo() {
        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("Arquivo inválido!");
        }

        Arquivo arquivo = new Arquivo();
        String extensao = arquivo.retornarExtensao(file);

        switch (extensao.toUpperCase()) {
            case "PDF":
                arquivo.lerArquivoPDF(this.path);
                break;
            case "TXT":
                arquivo.lerArquivoTXT(this.path);
                break;
            case "CSV":
                arquivo.lerArquivoCSV(this.path);
                break;
            case "HTML":
                arquivo.lerArquivoHTML(this.path);
                break;
            default:
                throw new RuntimeException("Extensão de arquivo desconhecida!");
        }
        
    }
}