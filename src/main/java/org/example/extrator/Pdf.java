package org.example.extrator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.example.exceptions.GeralException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pdf extends Arquivo {


    public void lerArquivo(String path) {
        File arquivoPdf = new File(path);
        validarArquivo(arquivoPdf);
        try (PDDocument document = PDDocument.load(arquivoPdf)) {
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);
                String[] lines = pdfFileInText.split("\\r?\\n");
                for (String linha : lines) {
                    System.out.println(linha);
                }
            } else {
                throw new GeralException("Não foi possível ler o PDF: Documento com senha.");
            }
        } catch (IOException e) {
            throw new GeralException("Erro ao Ler PDF: " + e.getMessage());
        }
    }

    @Override
    public void validarArquivo(File arquivo) {
        super.validarArquivo(arquivo);
    }
}
