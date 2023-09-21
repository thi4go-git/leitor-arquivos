package org.example.enums;

public enum ExtensaoEnum {
    PDF, TXT;

    public static ExtensaoEnum fromFileName(String fileName) {
        fileName = fileName.substring(fileName.indexOf("."), fileName.length())
                .replace(".", "").trim();
        if (fileName != null) {
            for (ExtensaoEnum e : ExtensaoEnum.values()) {
                if (fileName.equalsIgnoreCase(e.name())) {
                    return e;
                }
            }
        }
        throw new IllegalArgumentException("Extensão não reconhecida: " + fileName);
    }
}
