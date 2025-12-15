public class SommeFor {
    public static void main(String[] args) {

        int somme = 0;

        for (int i = 1; i <= 10; i++) {
            somme = somme + i;
        }

        System.out.println("La somme des entiers de 1 à 10 (for) = " + somme);
    }
}
