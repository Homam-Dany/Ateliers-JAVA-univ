public class sommeWhile {
    public static void main(String[] args) {

        int i = 1;
        int somme = 0;

        while (i <= 10) {
            somme = somme + i;
            i++;
        }

        System.out.println("Somme avec while = " + somme);
    }
}
