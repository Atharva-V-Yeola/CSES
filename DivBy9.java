import java.util.Scanner;

public class DivBy9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            String n = sc.next();
            sb.append(check(n)).append('\n');
        }
        System.out.print(sb);
        sc.close();
    }

    public static String check(String n) {
        int sum = 0, cnt2 = 0, cnt3 = 0;
        for (char c : n.toCharArray()) {
            int d = c - '0';
            sum += d;
            if (d == 2) cnt2++;
            if (d == 3) cnt3++;
        }
        for (int i = 0; i <= cnt2; i++) {
            for (int j = 0; j <= cnt3; j++) {
                int newSum = sum + 2 * i + 6 * j;
                if (newSum % 9 == 0) return "YES";
            }
        }
        return "NO";
    }
}
