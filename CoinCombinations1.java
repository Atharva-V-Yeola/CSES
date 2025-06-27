import java.io.*;
import java.util.StringTokenizer;

public class CoinCombinations1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long target = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long arr[] = new long[n];
        for(int i = 0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(cnt(n, target, arr));
    }
    public static int cnt(int n,long target,long arr[]){
        if(target == 0){
            return 1;
        }
        if(target<0) return 0;
        int ans =0;
        for (int i = 0; i < n; i++) {
            ans += cnt(n, target - arr[i], arr);
        }
        return ans;
    }
}
