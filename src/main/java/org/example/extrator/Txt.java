package org.example.extrator;

import org.example.exceptions.GeralException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Txt extends Arquivo {

    public void lerArquivo(String path) {
        File arquivoTxt = new File(path);
        validarArquivo(arquivoTxt);
        try {
            FileInputStream stream = new FileInputStream(arquivoTxt);
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(streamReader);
            String linha;
            while ((linha = buffer.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new GeralException("Erro ao Ler TXT: " + e.getMessage());
        }
    }

    @Override
    public void validarArquivo(File arquivo) {
        super.validarArquivo(arquivo);
    }
}
