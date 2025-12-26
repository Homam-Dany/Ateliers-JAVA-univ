import java.util.ArrayList;
import java.util.ListIterator;

abstract class ObjetGraphique {
    protected int x, y; 

    public ObjetGraphique() { this.x = 0; this.y = 0; } 
    public ObjetGraphique(int x, int y) { this.x = x; this.y = y; } 
    public ObjetGraphique(ObjetGraphique og) { this.x = og.x; this.y = og.y; }

    public int getX() { return x; } 
    public int getY() { return y; } 
    public void setPosition(int x, int y) { this.x = x; this.y = y; } 
    public void deplacer(int dx, int dy) { this.x += dx; this.y += dy; } 

    public abstract void affiche(); 
}

class Rectangle extends ObjetGraphique {
    protected double largeur, hauteur; 

    public Rectangle() { super(); this.largeur = 0; this.hauteur = 0; } 
    public Rectangle(int x, int y, double l, double h) {
        super(x, y); this.largeur = l; this.hauteur = h; 
    }
    public Rectangle(Rectangle r) { super(r); this.largeur = r.largeur; this.hauteur = r.hauteur; } 

    public void setTaille(double l, double h) { this.largeur = l; this.hauteur = h; } 
    
    @Override
    public void affiche() {
        System.out.println("Rectangle à (" + x + "," + y + ") - Largeur: " + largeur + ", Hauteur: " + hauteur);
    }
}


class Bouton extends Rectangle {
    protected String text; 

    public Bouton() { super(); this.text = ""; } 
    public Bouton(int x, int y, double l, double h, String t) {
        super(x, y, l, h); this.text = t; 
    }

    @Override
    public void affiche() {
        System.out.print("Bouton [Texte: " + text + "] ");
        super.affiche(); 
    }
}
class Cercle extends ObjetGraphique {
    private double rayon; 

    public Cercle() { super(); this.rayon = 0; } 
    public Cercle(int x, int y, double r) { super(x, y); this.rayon = r; } 

    @Override
    public void affiche() {
        System.out.println("Cercle à (" + x + "," + y + ") - Rayon: " + rayon);
    }
}


class ListeObjetGraphique {
    private ObjetGraphique[] liste; 
    private int taille, index = 0; 

    public ListeObjetGraphique(int taille) { 
        this.taille = taille; 
        this.liste = new ObjetGraphique[taille];
    }

    public void ajouter(ObjetGraphique f) {
        if (index < taille) { liste[index++] = f; } 
    }

    public void afficheObjetsGraphique() {
        for (int i = 0; i < index; i++) { liste[i].affiche(); } 
    }
}


public class TestGraphique {
    public static void main(String[] args) {
        ListeObjetGraphique maListe = new ListeObjetGraphique(10);
        maListe.ajouter(new Cercle(10, 10, 5.5));
        maListe.ajouter(new Rectangle(20, 20, 10, 5));
        maListe.ajouter(new Bouton(0, 0, 100, 30, "Valider"));
        System.out.println("--- Liste Classique ---");
        maListe.afficheObjetsGraphique();

      
        ArrayList<ObjetGraphique> listArr = new ArrayList<>();
        listArr.add(new Cercle(5, 5, 2));
        listArr.add(new Bouton(50, 50, 80, 20, "Annuler"));

        System.out.println("\n--- Liste avec ArrayList et Iterator ---");
        ListIterator<ObjetGraphique> it = listArr.listIterator(); 
        while (it.hasNext()) { 
            it.next().affiche(); 
        }
    }
}