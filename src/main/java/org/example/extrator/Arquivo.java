package org.example.extrator;

import org.example.exceptions.GeralException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Arquivo {
    protected List<String> linhas;

    public Arquivo() {
        this.linhas = new ArrayList<>();
    }

    protected void validarArquivo(File arquivo) {
        if (!arquivo.exists() || !arquivo.isFile()) {
            throw new GeralException("Arquivo não existe ou não é um Arquivo válido!");
        }
    }

    protected void imprimirLinhas() {
        for (String linha : linhas) {
            System.out.println(linha);
        }
    }
}
