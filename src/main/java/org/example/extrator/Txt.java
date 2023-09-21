package org.example.extrator;

import org.example.exceptions.GeralException;

import java.io.*;
import java.util.logging.Logger;

public class Txt extends Arquivo {


    private static final Logger LOG = Logger.getLogger(Txt.class.getName());
    public void lerArquivo(String path) {
        File arquivoTxt = new File(path);
        validarArquivo(arquivoTxt);
        try {
            LOG.info("::: Lendo arquivo TXT :::");
            FileInputStream stream = new FileInputStream(arquivoTxt);
            InputStreamReader streamReader = new InputStreamReader(stream);
            try (BufferedReader buffer = new BufferedReader(streamReader)) {
                String linha;
                while ((linha = buffer.readLine()) != null) {
                    System.out.println(linha);
                }
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
