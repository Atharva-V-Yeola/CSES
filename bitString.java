import java.util.Scanner;

public class bitString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long p = (long)Math.pow(2, n);
        long ans = (long)p%((long)Math.pow(10,9)+7);
        System.out.println(ans);
        sc.close();
    }
}
