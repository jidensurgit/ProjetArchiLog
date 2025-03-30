package serveur.service;

import java.util.List;

public class Mediateque {
    private final List<IDocument> documentList;
    private final List<Abonne>  abonneList;

    public Mediateque(List<IDocument> documentList, List<Abonne> abonneList) {
        this.documentList = documentList;
        this.abonneList = abonneList;
    }

    public IDocument getDocumentById(int id) throws RuntimeException {
        for (IDocument document : documentList) {
            if (document.numero() == id)
                return document;
        }
        throw new RuntimeException("Document introuvable");
    }

    public Abonne getAbonneById(int id) throws RuntimeException {
        for (Abonne abonne : abonneList) {
            if (abonne.getNumero() == id)
                return abonne;
        }
        throw new RuntimeException("Abonne introuvable");
    }
}
