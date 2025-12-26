
abstract class Personne {
    protected String nom, prenom, rue, ville; 
    protected static int nbPersonnes = 0; 

    public Personne(String nom, String prenom, String rue, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.ville = ville;
        nbPersonnes++;
    }

    public abstract void ecrirePersonne();

    public void modifierPersonne(String rue, String ville) {
        this.rue = rue;
        this.ville = ville;
        System.out.println("\n--- Modification effectuée ---");
        this.ecrirePersonne(); 
    }

    public String toString() {
        return nom + " " + prenom + " | Adresse: " + rue + ", " + ville;
    }

    public static void nbPersonne() {
        System.out.println("Total établissement: " + nbPersonnes + " personnes.");
    }
}


class Secretaire extends Personne {
    private String numeroBureau;
    private static int nbSecretaires = 0;

    public Secretaire(String nom, String prenom, String rue, String ville, String numeroBureau) {
        super(nom, prenom, rue, ville); 
        this.numeroBureau = numeroBureau;
        nbSecretaires++;
    }

    public void ecrirePersonne() {
        System.out.println("Secrétaire: " + toString());
    }

    public String toString() {
        return super.toString() + " | Bureau: " + numeroBureau;
    }

    public static void nbSecretaires() {
        System.out.println("Nombre de secrétaires: " + nbSecretaires);
    }
}


class Enseignant extends Personne {
    private String specialite;
    private static int nbEnseignants = 0;

    public Enseignant(String nom, String prenom, String rue, String ville, String specialite) {
        super(nom, prenom, rue, ville);
        this.specialite = specialite;
        nbEnseignants++;
    }

    public void ecrirePersonne() {
        System.out.println("Enseignant: " + toString()); 
    }

    public String toString() {
        return super.toString() + " | Spécialité: " + specialite;
    }

    public static void nbEnseignants() {
        System.out.println("Nombre d'enseignants: " + nbEnseignants);
    }
}


class Etudiant extends Personne {
    private String diplomeEnCours;
    private static int nbEtudiants = 0;

    public Etudiant(String nom, String prenom, String rue, String ville, String diplome) {
        super(nom, prenom, rue, ville);
        this.diplomeEnCours = diplome;
        nbEtudiants++;
    }

    public void ecrirePersonne() {
        System.out.println("Étudiant: " + toString()); 
    }

    public String toString() {
        return super.toString() + " | Diplôme: " + diplomeEnCours;
    }

    public static void nbEtudiants() {
        System.out.println("Nombre d'étudiants: " + nbEtudiants); 
    }
}

public class GestionEtablissement {
    public static void main(String[] args) {
        Secretaire s = new Secretaire("Abidi", "Said", "Rue Elamal", "Casablanca", "A123");
        Enseignant e = new Enseignant("Sbihi", "Ahmed", "Rue Bel Air", "Fès", "Informatique");
        Etudiant e1 = new Etudiant("Merras", "Samir", "rue saules", "Oujda", "licence informatique");
        Etudiant e2 = new Etudiant("Nissani", "Hamid", "rue d'olivier", "Taza", "DUT informatique");

        s.ecrirePersonne();
        e.ecrirePersonne();
        e2.ecrirePersonne();

        
        e.modifierPersonne("rue du grenadier", "Rabat");
        s.modifierPersonne("rue Taounat", "Safi");

        
        System.out.println("\n--- STATISTIQUES DE L'ÉTABLISSEMENT ---");
        Personne.nbPersonne(); 
        Secretaire.nbSecretaires();
        Enseignant.nbEnseignants();
        Etudiant.nbEtudiants();
    }
}