import java.util.Scanner;

public class DiceCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        System.out.println(rec(n, n,dp));
        sc.close();
    }
    static int rec(int sum,int n,int[] dp){
        if(sum==0) return 1;
        if(sum<0) return 0;
        

        int ans = 0;
        for(int i = 1;i<=Math.min(n, 6);i++){
            if((sum-i)>=0){
                ans+=rec(sum-i,n,dp);
            }
        }
        return ans;
    }
}
