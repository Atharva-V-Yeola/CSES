import java.util.*;

public class TowerOfHanoi {

    public static void towerOfHanoi(int n, int from, int to, int aux, StringBuilder sb) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        towerOfHanoi(n - 1, from, aux, to, sb);
        sb.append(from).append(" ").append(to).append("\n");
        towerOfHanoi(n - 1, aux, to, from, sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append((1 << n) - 1).append("\n");  
        towerOfHanoi(n, 1, 3, 2, sb);
        System.out.print(sb);
        sc.close();
    }
}
