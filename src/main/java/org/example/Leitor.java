package org.example;

import org.example.enums.ExtensaoEnum;
import org.example.exceptions.GeralException;
import org.example.extrator.Pdf;
import org.example.extrator.Txt;

import java.io.File;


public class Leitor {

    public void lerArquivo(String path) {
        File file = new File(path);
        ExtensaoEnum extensao = ExtensaoEnum.fromFileName(file.getName());
        switch (extensao) {
            case PDF:
                Pdf pdf = new Pdf();
                pdf.lerArquivo(path);
                break;
            case TXT:
                Txt txt = new Txt();
                txt.lerArquivo(path);
                break;
            default:
                throw new GeralException("Extensão de arquivo desconhecida!");
        }
    }
}
