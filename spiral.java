import java.util.Scanner;

public class spiral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        while (n > 0) {
            n--;
            long row = sc.nextLong();
            long col = sc.nextLong();
            long sq;

            if (row > col) {
                sq = (row - 1) * (row - 1);
                if (row % 2 != 0)
                    sq += col;
                else
                    sq += 2 * row - col;
                System.out.println(sq);
            } else {
                sq = (col - 1) * (col - 1);
                if (col % 2 == 0)
                    sq += row;
                else
                    sq += 2 * col - row;
                System.out.println(sq);
            }
        }
        sc.close();
    }
}
