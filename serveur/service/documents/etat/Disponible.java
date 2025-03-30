package serveur.service.documents.etat;

import serveur.service.Abonne;
import serveur.service.documents.IEtatDocument;

import java.time.LocalTime;

public class Disponible extends EtatDocument {

    public Disponible() {
        super();
    }

    @Override
    public IEtatDocument reserver(Abonne ab) {
        return new Reserve(ab, LocalTime.now());
    }

    @Override
    public IEtatDocument emprunter(Abonne ab) {
        return new Emprunte();
    }


    @Override
    public IEtatDocument retourner() {
        return this;
    }
}
