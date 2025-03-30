package serveur;

import serveur.service.*;
import serveur.service.documents.Dvd;
import serveur.service.documents.Livre;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppliServeur {

    public final static int PORT_RESERVATION = 2000;
    public final static int PORT_EMPRUNT = 3000;
    public final static int PORT_RETOUR = 4000;

    public static void main(String[] args) {
        Mediateque mediateque = new Mediateque(new ArrayList<>(List.of(
                new Livre(1, "NARUTO TOME 1", 300),
                new Livre(2, "NARUTO TOME 2", 300),
                new Livre(3, "NARUTO TOME 3", 300),
                new Dvd(4, "NARUTO EPISODE 1", false),
                new Dvd(5, "NARUTO EPISODE 2", true),
                new Dvd(6, "NARUTO EPISODE 3", true)
        )),
                new ArrayList<>(List.of(
                        new Abonne(1, "Kid", LocalDate.of(2010, 1, 1)),
                        new Abonne(2, "Adult", LocalDate.of(2000, 1, 1))
                ))
        );

        try {
            new Thread(new Serveur(PORT_RESERVATION, ServiceReservation.class, mediateque)).start();
            new Thread(new Serveur(PORT_EMPRUNT, ServiceEmprunt.class, mediateque)).start();
            new Thread(new Serveur(PORT_RETOUR, ServiceRetour.class, mediateque)).start();
        } catch (IOException e) {
        }
    }
}
