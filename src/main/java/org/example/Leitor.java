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
            throw new GeralException("Arquivo inválido!");
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
            default:
                throw new GeralException("Extensão de arquivo desconhecida!");
        }

    }
}
