import java.util.Scanner;

public class longPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(pow(2,n));
        sc.close();
    }
    static long mod = 1000000007;
    static long pow(long base,long expo){
        long ans = 1;
        while(expo>0){
            if((expo&1)==1){
                ans = (ans*base)%mod;
            }
            base = (base*base)%mod;
            expo>>=1;
        }
        return ans;
    }
}
