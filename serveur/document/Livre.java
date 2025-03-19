package serveur.document;

public class Livre extends Document {
    private int nb_page;
    public Livre(int num, String title, int nb_page) {
        super(num, title);
        this.nb_page = nb_page;
    }

    @Override
    public void reserver(Abonne ab) throws ReservationException {

    }

    @Override
    public void emprunter(Abonne ab) throws EmpruntException {

    }

    @Override
    public void retourner() {

    }
}
