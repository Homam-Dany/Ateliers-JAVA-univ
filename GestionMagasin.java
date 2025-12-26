// ================== INTERFACES ==================

interface VendablePiece {
    double vendre(int quantite);
}

interface VendableKilo {
    double vendre(double quantite);
}

interface Solde {
    void lanceSolde(double pourcentage);
    void termineSolde(double pourcentage);
}

// ================== CLASSE ARTICLE ==================

class Article {

    protected String nom;
    protected String fournisseur;
    protected double prixAchat;
    protected double prixVente;

    public Article(String nom, String fournisseur,
                   double prixAchat, double prixVente) {
        this.nom = nom;
        this.fournisseur = fournisseur;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
    }

    public double rendement() {
        return ((prixVente - prixAchat) / prixAchat) * 100;
    }

    @Override
    public String toString() {
        return "Nom: " + nom +
               ", Fournisseur: " + fournisseur +
               ", Prix Achat: " + prixAchat +
               ", Prix Vente: " + prixVente +
               ", Rendement: " + rendement() + "%";
    }
}

// ================== ARTICLE ELECTROMENAGER ==================

class ArticleElectromenager extends Article
        implements VendablePiece, Solde {

    private int stock;

    public ArticleElectromenager(String nom, String fournisseur,
                                 double prixAchat, double prixVente) {
        super(nom, fournisseur, prixAchat, prixVente);
        stock = 0;
    }

    public void remplirStock(int quantite) {
        stock += quantite;
    }

    @Override
    public double vendre(int quantite) {
        if (quantite <= stock) {
            stock -= quantite;
            return quantite * prixVente;
        } else {
            System.out.println("Stock insuffisant (Electroménager)");
            return 0;
        }
    }

    @Override
    public void lanceSolde(double pourcentage) {
        prixVente -= prixVente * pourcentage / 100;
    }

    @Override
    public void termineSolde(double pourcentage) {
        prixVente += prixVente * pourcentage / 100;
    }

    @Override
    public String toString() {
        return super.toString() + ", Stock: " + stock + " pièces";
    }
}

// ================== ARTICLE PRIMEUR ==================

class ArticlePrimeur extends Article
        implements VendableKilo {

    private double stock;

    public ArticlePrimeur(String nom, String fournisseur,
                          double prixAchat, double prixVente) {
        super(nom, fournisseur, prixAchat, prixVente);
        stock = 0;
    }

    public void remplirStock(double quantite) {
        stock += quantite;
    }

    @Override
    public double vendre(double quantite) {
        if (quantite <= stock) {
            stock -= quantite;
            return quantite * prixVente;
        } else {
            System.out.println("Stock insuffisant (Primeur)");
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Stock: " + stock + " kg";
    }
}

// ================== CLASSE MAGASIN ==================

class Magasin {

    private double depense;
    private double revenu;

    public Magasin() {
        depense = 0;
        revenu = 0;
    }

    public void ajouterDepense(double montant) {
        depense += montant;
    }

    public void ajouterRevenu(double montant) {
        revenu += montant;
    }

    public double rendement() {
        if (depense == 0) return 0;
        return ((revenu - depense) / depense) * 100;
    }

    @Override
    public String toString() {
        return "Depense: " + depense +
               ", Revenu: " + revenu +
               ", Rendement magasin: " + rendement() + "%";
    }
}

// ================== CLASSE TEST (MAIN) ==================

public class GestionMagasin {

    public static void main(String[] args) {

        Magasin magasin = new Magasin();

        // Electroménager
        ArticleElectromenager machine =
                new ArticleElectromenager("Machine à laver", "LG", 2500, 3800);

        machine.remplirStock(4);
        magasin.ajouterDepense(4 * 2500);

        machine.lanceSolde(10);
        double venteMachine = machine.vendre(2);
        magasin.ajouterRevenu(venteMachine);

        System.out.println(machine);

        // Primeur
        ArticlePrimeur orange =
                new ArticlePrimeur("Orange", "Ferme locale", 1.5, 3);

        orange.remplirStock(50);
        magasin.ajouterDepense(50 * 1.5);

        double venteOrange = orange.vendre(8);
        magasin.ajouterRevenu(venteOrange);

        System.out.println(orange);

        // Etat du magasin
        System.out.println("------ ETAT DU MAGASIN ------");
        System.out.println(magasin);
    }
}
