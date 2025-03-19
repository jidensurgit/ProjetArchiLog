package serveur.document;

import serveur.IDocument;

public abstract class Document implements IDocument {
    private int num;
    private String title;

    public Document(int num, String title) {
        this.num = num;
        this.title = title;
    }

    @Override
    public int numero() {
        return num;
    }




}
