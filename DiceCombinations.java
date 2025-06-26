// import java.util.Scanner;
    
// public class DiceCombinations {
//     static int MOD = 1000000007;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] dp = new int[n+1];
//         System.out.println(rec(n, n,dp));
//         sc.close();
//     }
//     static int rec(int sum,int n,int[] dp){
//         if(sum==0) return 1;
//         if(sum<0) return 0;
        
//         if(dp[sum]!=0) return dp[sum];
//         int ans = 0;
//         for(int i = 1;i<=Math.min(n, 6);i++){
//                 ans=(ans+rec(sum-i,n,dp))%MOD;
//         }
//         dp[sum] = ans;
//         return ans;
//     }
// }
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// //import java.util.*;
// import java.io.*;
// import java.util.StringTokenizer;

// public class DiceCombinations {
//     static final int MOD = 1000000007;

//     public static void main(String[] args) throws IOException {
//         //Scanner sc = new Scanner(System.in);
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         //long n = Long.parseLong(st.nextToken());
//         int n = Integer.parseInt(st.nextToken());
//         long[] dp = new long[n + 1];  // use long to avoid overflow
//         for (int i = 0; i <= n; i++) dp[i] = -1; // initialize with -1 for memo
//         System.out.println(rec(n, dp));
//         //sc.close();
//     }

//     static long rec(int sum, long[] dp) {
//         if (sum == 0) return 1;
//         if (sum < 0) return 0;

//         if (dp[sum] != -1) return dp[sum];

//         long ans = 0;
//         for (int i = 1; i <= 6; i++) {
//             ans = (ans + rec(sum - i, dp)) % MOD;
//         }

//         dp[sum] = ans;
//         return ans;
//     }
// }
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DiceCombinations {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }

        System.out.println(dp[n]);
    }
}

