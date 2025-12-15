public class Main {


    static class Point {
        int x;
        int y;

        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        
        Point[][] matrice = new Point[2][];

        
        matrice[0] = new Point[2]; // 2 points
        matrice[1] = new Point[3]; // 3 points

        
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(7, 8);
        Point p5 = new Point(9, 10);

        
        matrice[0][0] = p1;
        matrice[0][1] = p2;

        matrice[1][0] = p3;
        matrice[1][1] = p4;
        matrice[1][2] = p5;

        
        System.out.println("Contenu de la matrice :");
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.println("Point[" + i + "][" + j + "] = (" 
                        + matrice[i][j].x + ", " + matrice[i][j].y + ")");
            }
        }
    }
}
