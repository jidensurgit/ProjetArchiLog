package serveur.document;

public class Dvd extends Document {
    private final boolean adulte;

    public Dvd(int num, String title, boolean adulte) {
        super(num, title);
        this.adulte = adulte;
    }
}
