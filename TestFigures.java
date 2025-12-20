import java.util.Vector;

class Figure {
    protected int x;          
    protected int y;          
    protected int couleur;    

   
    private static Vector<Figure> instances = new Vector<>();

    public Figure(int x, int y, int couleur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
        instances.add(this);
    }

    public static Vector<Figure> getInstances() {
        return instances;
    }

    @Override
    public String toString() {
        return "Figure [x=" + x + ", y=" + y + ", couleur=" + couleur + "]";
    }
}

class Carre extends Figure {
    private int cote;

    public Carre(int x, int y, int couleur, int cote) {
        super(x, y, couleur);
        this.cote = cote;
    }

    
    public static Vector<Carre> getCarreInstances() {
        Vector<Carre> carres = new Vector<>();
        for (Figure f : Figure.getInstances()) {
            if (f instanceof Carre) {
                carres.add((Carre) f);
            }
        }
        return carres;
    }

    @Override
    public String toString() {
        return "Carre [x=" + x + ", y=" + y + ", couleur=" + couleur + ", cote=" + cote + "]";
    }
}

class Rectangle extends Figure {
    private int longueur;
    private int largeur;

    public Rectangle(int x, int y, int couleur, int longueur, int largeur) {
        super(x, y, couleur);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public static Vector<Rectangle> getRectangleInstances() {
        Vector<Rectangle> rectangles = new Vector<>();
        for (Figure f : Figure.getInstances()) {
            if (f instanceof Rectangle) {
                rectangles.add((Rectangle) f);
            }
        }
        return rectangles;
    }

    @Override
    public String toString() {
        return "Rectangle [x=" + x + ", y=" + y + ", couleur=" + couleur + 
               ", longueur=" + longueur + ", largeur=" + largeur + "]";
    }
}

public class TestFigures {
    public static void main(String[] args) {
        new Figure(0, 0, 1);
        new Carre(1, 1, 2, 5);
        new Carre(2, 2, 3, 10);
        new Rectangle(3, 3, 4, 8, 4);

        System.out.println("---- Toutes les figures ----");
        for (Figure f : Figure.getInstances()) {
            System.out.println(f);
        }

        System.out.println("\n---- Tous les carrés ----");
        for (Carre c : Carre.getCarreInstances()) {
            System.out.println(c);
        }

        System.out.println("\n---- Tous les rectangles ----");
        for (Rectangle r : Rectangle.getRectangleInstances()) {
            System.out.println(r);
        }
    }
}