package serveur.service.documents;

public class Livre extends Document {
    private final int nb_page;
    public Livre(int num, String title, int nb_page) {
        super(num, title);
        this.nb_page = nb_page;
    }



    @Override
    public String toString() {
        return "livre";
    }
}

