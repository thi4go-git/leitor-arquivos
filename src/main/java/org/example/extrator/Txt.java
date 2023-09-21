package org.example.extrator;

import org.example.exceptions.GeralException;

import java.io.*;
import java.util.List;

public class Txt extends Arquivo {

    public List<String> lerArquivo(String path) {
        File arquivoTxt = new File(path);
        validarArquivo(arquivoTxt);
        try {
            FileInputStream stream = new FileInputStream(arquivoTxt);
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(streamReader);
            String line;
            while ((line = buffer.readLine()) != null) {
                this.linhas.add(line);
            }
            this.imprimirLinhas();
            return this.linhas;
        } catch (IOException e) {
            throw new GeralException("Erro ao Ler TXT: " + e.getMessage());
        }
    }

    @Override
    public void validarArquivo(File arquivo) {
        super.validarArquivo(arquivo);
    }
}
