public class sommeDoWhile {
    public static void main(String[] args) {

        int i = 1;
        int somme = 0;

        do {
            somme = somme + i;
            i++;
        } while (i <= 10);

        System.out.println("Somme avec do...while = " + somme);
    }
}
