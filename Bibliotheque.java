import java.util.ArrayList;

class Document {
    protected int numero;
    protected String titre;

    public Document(int numero, String titre) {
        this.numero = numero;
        this.titre = titre;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitre() {
        return titre;
    }

    public String toString() {
        return "Document [Numéro=" + numero + ", Titre=" + titre + "]";
    }
}


class Livre extends Document {
    private String auteur;
    private int nbPages;

    public Livre(int numero, String titre, String auteur, int nbPages) {
        super(numero, titre);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }

    public String getAuteur() {
        return auteur;
    }

    @Override
    public String toString() {
        return "Livre [Numéro=" + numero + ", Titre=" + titre +
               ", Auteur=" + auteur + ", Pages=" + nbPages + "]";
    }
}


class Dictionnaire extends Document {
    private String langue;
    private int nbTomes;

    public Dictionnaire(int numero, String titre, String langue, int nbTomes) {
        super(numero, titre);
        this.langue = langue;
        this.nbTomes = nbTomes;
    }

    @Override
    public String toString() {
        return "Dictionnaire [Numéro=" + numero + ", Titre=" + titre +
               ", Langue=" + langue + ", Tomes=" + nbTomes + "]";
    }
}


class ListeDeDocuments {
    private ArrayList<Document> liste;

    public ListeDeDocuments() {
        liste = new ArrayList<>();
    }

    public void ajouter(Document d) {
        liste.add(d);
    }

    public void tousLesAuteurs() {
        for (Document d : liste) {
            System.out.print("Document n° " + d.getNumero());

            if (d instanceof Livre) {
                Livre l = (Livre) d;
                System.out.println(" | Auteur : " + l.getAuteur());
            } else {
                System.out.println(" | Auteur : ---");
            }
        }
    }

    public void tousLesDocuments() {
        for (Document d : liste) {
            System.out.println(d);
        }
    }
}


public class Bibliotheque {
    public static void main(String[] args) {

       
        Livre l1 = new Livre(1, "Java Facile", "Ali", 300);
        Livre l2 = new Livre(2, "POO en Java", "Sara", 250);
        Dictionnaire d1 = new Dictionnaire(3, "Larousse", "Français", 2);

        
        ListeDeDocuments liste = new ListeDeDocuments();

        liste.ajouter(l1);
        liste.ajouter(l2);
        liste.ajouter(d1);

        System.out.println("---- Tous les auteurs ----");
        liste.tousLesAuteurs();

        System.out.println("\n---- Tous les documents ----");
        liste.tousLesDocuments();
    }
}
