import java.util.Scanner;

public class LivreTest { 
    static class Livre {
        private String titre;
        private String auteur;
        private double prix;
     
        public Livre(String titre, String auteur, double prix) {
            this.titre = titre;
            this.auteur = auteur;
            this.prix = prix;
        }
 
        public String getTitre() {
            return titre;
        }

        public void setTitre(String titre) {
            this.titre = titre;
        }

        public String getAuteur() {
            return auteur;
        }

        public void setAuteur(String auteur) {
            this.auteur = auteur;
        }

        public double getPrix() {
            return prix;
        }

        public void setPrix(double prix) {
            this.prix = prix;
        }

        
        public void Afficher() {
            System.out.println("Titre : " + titre);
            System.out.println("Auteur : " + auteur);
            System.out.println("Prix : " + prix + " DH");
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Donner le titre du livre : ");
        String titre = sc.nextLine();

        System.out.print("Donner l'auteur du livre : ");
        String auteur = sc.nextLine();

        System.out.print("Donner le prix du livre : ");
        double prix = sc.nextDouble();

        Livre livre = new Livre(titre, auteur, prix);

        System.out.println("\nInformations du livre :");
        livre.Afficher();

        sc.close();
    }
}
