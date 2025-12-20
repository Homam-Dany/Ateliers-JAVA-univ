import java.util.Scanner;
import java.time.Year;

public class EmployeTest {

    static class Employe {

        private int matricule;
        private String nom;
        private String prenom;
        private int anneeNaissance;
        private int anneeEmbauche;
        private double salaire;

        public Employe(int matricule, String nom, String prenom,
                       int anneeNaissance, int anneeEmbauche, double salaire) {
            this.matricule = matricule;
            this.nom = nom;
            this.prenom = prenom;
            this.anneeNaissance = anneeNaissance;
            this.anneeEmbauche = anneeEmbauche;
            this.salaire = salaire;
        }
        
        public int getMatricule() { return matricule; }
        public void setMatricule(int matricule) { this.matricule = matricule; }

        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; }

        public String getPrenom() { return prenom; }
        public void setPrenom(String prenom) { this.prenom = prenom; }

        public int getAnneeNaissance() { return anneeNaissance; }
        public void setAnneeNaissance(int anneeNaissance) { this.anneeNaissance = anneeNaissance; }

        public int getAnneeEmbauche() { return anneeEmbauche; }
        public void setAnneeEmbauche(int anneeEmbauche) { this.anneeEmbauche = anneeEmbauche; }

        public double getSalaire() { return salaire; }
        public void setSalaire(double salaire) { this.salaire = salaire; }

        public int getAnciennete() {
            int anneeActuelle = Year.now().getValue();
            return anneeActuelle - anneeEmbauche;
        }

        public int getAge() {
            int anneeActuelle = Year.now().getValue();
            return anneeActuelle - anneeNaissance;
        }

        public void AugmentationDuSalaire() {
            int anciennete = getAnciennete();

            if (anciennete < 5) {
                salaire = salaire + salaire * 0.02;
            } else if (anciennete < 10) {
                salaire = salaire + salaire * 0.05;
            } else {
                salaire = salaire + salaire * 0.10;
            }
        }

        public void AfficherEmploye() {
            System.out.println("Matricule : " + matricule);
            System.out.println("Nom : " + nom);
            System.out.println("Prénom : " + prenom);
            System.out.println("Age : " + getAge() + " ans");
            System.out.println("Ancienneté : " + getAnciennete() + " ans");
            System.out.println("Salaire : " + salaire + " DH");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Matricule : ");
        int matricule = sc.nextInt();
        sc.nextLine();

        System.out.print("Nom : ");
        String nom = sc.nextLine();

        System.out.print("Prénom : ");
        String prenom = sc.nextLine();

        System.out.print("Année de naissance : ");
        int anneeNaissance = sc.nextInt();

        System.out.print("Année d'embauche : ");
        int anneeEmbauche = sc.nextInt();

        System.out.print("Salaire : ");
        double salaire = sc.nextDouble();

        Employe emp = new Employe(matricule, nom, prenom,
                                  anneeNaissance, anneeEmbauche, salaire);

        emp.AugmentationDuSalaire();

        System.out.println("\nInformations de l'employé :");
        emp.AfficherEmploye();

        sc.close();
    }
}
