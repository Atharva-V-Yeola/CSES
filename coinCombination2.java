import java.io.*;
import java.util.StringTokenizer;

public class coinCombination2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        int dp[][] = new int[n+1][target+1];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(cnt(n, target, arr, 0,dp));
    }
    public static int cnt(int n, int target, int arr[], int idx,int[][] dp) {
    if (target == 0) return 1;
    if (target < 0 || idx == n) return 0;
    if(dp[idx][target]!=0) return dp[idx][target];
    int take = cnt(n, target - arr[idx], arr, idx,dp);      
    int notTake = cnt(n, target, arr, idx + 1,dp);           
    return dp[idx][target] = take + notTake;
    }

}
