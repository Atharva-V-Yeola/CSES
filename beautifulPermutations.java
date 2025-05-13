import java.util.Scanner;
import java.util.ArrayList;
public class beautifulPermutations {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        long n = sc.nextLong();
        if(n==1) System.out.println(1);
        else if(n<=3){
            System.out.println("NO SOLUTION");
        }
        ArrayList<Long> list = Cnt(n);
        for(long num : list){
            System.out.print(num+" ");
        }
        sc.close();
    }
    public static ArrayList<Long> Cnt(Long n){
        ArrayList<Long> ans = new ArrayList<>();
        for(long i = 2;i<=n;i+=2){
            ans.add(i);
        }
        for(long i = 1;i<=n;i+=2){
            ans.add(i);
        }
        return ans;
    }
}