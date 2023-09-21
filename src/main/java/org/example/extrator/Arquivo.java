package org.example.extrator;

import org.example.exceptions.GeralException;

import java.io.*;


public abstract class Arquivo {
    protected void validarArquivo(File arquivo) {
        if (!arquivo.exists() || !arquivo.isFile()) {
            throw new GeralException("Arquivo não existe ou não é um Arquivo válido!");
        }
    }
}
