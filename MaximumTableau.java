import java.util.Scanner;

public class MaximumTableau {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        System.out.print("Entrez la taille du tableau : ");
        int n = sc.nextInt();

        
        double[] tab = new double[n];

       
        for (int i = 0; i < n; i++) {
            System.out.print("Entrez l'element " + (i + 1) + " : ");
            tab[i] = sc.nextDouble();
        }

        
        double max = tab[0];

        
        for (int i = 1; i < n; i++) {
            if (tab[i] > max) {
                max = tab[i];
            }
        }

       
        System.out.println("Le maximum du tableau est : " + max);

        sc.close();
    }
}