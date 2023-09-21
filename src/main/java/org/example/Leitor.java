package org.example;

import org.example.enums.ExtensaoEnum;
import org.example.exceptions.GeralException;
import org.example.extrator.Pdf;
import org.example.extrator.Txt;

import java.io.File;
import java.util.List;

public class Leitor {
    private String path;

    public Leitor(String path) {
        this.path = path;
    }

    public List<String> lerArquivo() {
        File file = new File(this.path);
        ExtensaoEnum extensao = ExtensaoEnum.fromFileName(file.getName());
        switch (extensao) {
            case PDF:
                Pdf pdf = new Pdf();
                pdf.lerArquivo(this.path);
                break;
            case TXT:
                Txt txt = new Txt();
                txt.lerArquivo(this.path);
                break;
            default:
                throw new GeralException("Extensão de arquivo desconhecida!");
        }
        return null;
    }
}
