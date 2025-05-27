//import java.util.Arrays;
//import java.util.Scanner;

//public class AppleDivision {
//     static long diff(int n,long[] arr){
        
//         Arrays.sort(arr);
//         long sum1 = 0L;
//         long sum2 = 0L;
//         for(int i = n-1;i>=0;i--){
//             if(sum2<=sum1) sum2+=arr[i];
//             else sum1+=arr[i];
//         }
//         long diff = Math.abs(sum1-sum2);
//         return diff;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         long arr[] = new long[n];
//         for(int i = 0;i<n;i++){
//             arr[i] = sc.nextLong();
//         }
//         long ans = diff(n, arr);
//         System.out.println(ans);
//         sc.close();
//     }
// }

// Memoization Apporach
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;

// public class AppleDivision {

//     static long totalSum;
//     static Map<String, Long> memo = new HashMap<>();

//     static long solve(int idx, long[] arr, long sum1) {
//         if (idx == arr.length) {
//             long sum2 = totalSum - sum1;
//             return Math.abs(sum1 - sum2);
//         }

//         String key = idx + "-" + sum1;

//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }

//         // Include current element in sum1
//         long include = solve(idx + 1, arr, sum1 + arr[idx]);

//         // Exclude current element from sum1 (implicitly goes to sum2)
//         long exclude = solve(idx + 1, arr, sum1);

//         long result = Math.min(include, exclude);
//         memo.put(key, result);
//         return result;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         long[] arr = new long[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         totalSum = 0;
//         for (long val : arr) {
//             totalSum += val;
//         }

//         long ans = solve(0, arr, 0);
//         System.out.println(ans);
//         sc.close();
//     }
// }


// Tabulation Apporach

import java.util.Scanner;
//import java.util.*;
// public class AppleDivision {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         long[] arr = new long[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextLong(); // Use nextLong() for long values
//         }

//         long totalSum = 0;
//         for (long num : arr) totalSum += num;

//         boolean[][] dp = new boolean[n + 1][(int) totalSum + 1];
//         dp[0][0] = true; // 0 sum is always possible with 0 elements

//         // Fill the DP table
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= totalSum; j++) {
//                 dp[i][j] = dp[i - 1][j];
//                 if (j >= arr[i - 1]) {
//                     dp[i][j] |= dp[i - 1][(int)(j - arr[i - 1])];
//                 }
//             }
//         }

//         long minDiff = Long.MAX_VALUE;
//         for (int s1 = 0; s1 <= totalSum / 2; s1++) {
//             if (dp[n][s1]) {
//                 long s2 = totalSum - s1;
//                 minDiff = Math.min(minDiff, Math.abs(s2 - s1));
//             }
//         }

//         System.out.println(minDiff);
//         sc.close();
//     }
public class AppleDivision{

    static long solve(int idx, long[] arr, long sum1, long sum2, int n) {
        // If we have reached the end, return the difference between the sums
        if (idx == n) {
            return Math.abs(sum1 - sum2);
        }

        // Choose the current apple in group 1
        long choose = solve(idx + 1, arr, sum1 + arr[idx], sum2, n);

        // Choose the current apple in group 2
        long notChoose = solve(idx + 1, arr, sum1, sum2 + arr[idx], n);

        // Return the minimum of both the choices
        return Math.min(choose, notChoose);
    }

    public static void main(String[] args) {
        // Sample Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextLong();
        }

        // Call the recursive function to find the minimum difference between both the groups
        long ans = solve(0, arr, 0, 0, n);
        System.out.println(ans);
        sc.close();
    }

}



