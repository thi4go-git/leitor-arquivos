package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;


import java.io.*;


public class Arquivo {


    public void lerArquivoTXT(String path) {
        File arquivoTxt = new File(path);
        if (this.validarArquivo(arquivoTxt)) {
            try {
                FileInputStream stream = new FileInputStream(arquivoTxt);
                InputStreamReader streamReader = new InputStreamReader(stream);
                BufferedReader buffer = new BufferedReader(streamReader);
                String linha;
                while ((linha = buffer.readLine()) != null) {
                    System.out.println(linha);
                }
            } catch (IOException e) {
                System.out.println("ERRO " + e.getMessage());
            }
        }
    }


    public void lerArquivoPDF(String path) {
        File arquivoPdf = new File(path);
        if (this.validarArquivo(arquivoPdf)) {
            try (PDDocument document = PDDocument.load(arquivoPdf)) {
                if (!document.isEncrypted()) {
                    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                    stripper.setSortByPosition(true);
                    PDFTextStripper tStripper = new PDFTextStripper();
                    String pdfFileInText = tStripper.getText(document);
                    String[] lines = pdfFileInText.split("\\r?\\n");
                    for (String line : lines) {
                        System.out.println(line);
                    }
                } else {
                    throw new RuntimeException("Não foi possível ler o PDF: Documento com senha.");
                }
            } catch (IOException e) {
                throw new RuntimeException("Erro ao Ler PDF: " + e.getMessage());
            }
        }
    }

    public String retornarExtensao(File file) {
        String extensao = file.getName().trim();
        return extensao.substring(extensao.indexOf("."), extensao.length())
                .replace(".", "").trim();
    }

    private boolean validarArquivo(File arquivo) {
        if (arquivo.exists() && arquivo.isFile()) {
            return true;
        }
        throw new RuntimeException("Arquivo não existe ou não é um Arquivo válido!");
    }
}
