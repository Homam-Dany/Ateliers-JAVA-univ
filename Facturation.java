import java.util.Scanner;

public class Facturation {
    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);

       
        double prixHT;
        double prixTTC;
        double remise = 0;
        double montantFinal;

       
        System.out.print("Entrez le prix HT en DH : ");
        prixHT = sc.nextDouble();

       
        prixTTC = prixHT + (prixHT * 18.6 / 100);

        
        if (prixTTC < 1000) {
            remise = 0;
        } else if (prixTTC < 2000) {
            remise = prixTTC * 1 / 100;
        } else if (prixTTC < 5000) {
            remise = prixTTC * 3 / 100;
        } else {
            remise = prixTTC * 5 / 100;
        }

       
        montantFinal = prixTTC - remise;

       
        System.out.println("Prix TTC : " + prixTTC + " DH");
        System.out.println("Montant de la remise : " + remise + " DH");
        System.out.println("Montant final à payer : " + montantFinal + " DH");

       
        sc.close();
    }
}
