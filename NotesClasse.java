import java.util.Scanner;

public class NotesClasse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Entrez le nombre d'etudiants : ");
        int n = sc.nextInt();

        
        double[] notes = new double[n];
        double somme = 0;

        
        for (int i = 0; i < n; i++) {
            System.out.print("Entrez la note de l'etudiant " + (i + 1) + " : ");
            notes[i] = sc.nextDouble();
            somme = somme + notes[i];
        }

        
        double moyenne = somme / n;

        
        int compteur = 0;
        for (int i = 0; i < n; i++) {
            if (notes[i] > moyenne) {
                compteur++;
            }
        }

        
        System.out.println("Moyenne de la classe = " + moyenne);
        System.out.println("Nombre d'etudiants au-dessus de la moyenne = " + compteur);

        sc.close();
    }
}
