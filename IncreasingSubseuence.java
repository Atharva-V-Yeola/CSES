import java.util.*;
import java.io.*;
public class IncreasingSubseuence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long arr[] = new long[n];
        for(int i = 0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(MaxSeq(n, arr, 0, -1));
    }
    public static int MaxSeq(int n,long arr[],int idx,int prev){
        if(idx == n){
            return 0;
        }
        int ans = 0;
        int ignore = MaxSeq(n, arr, idx+1, prev);
        if(prev == -1 || arr[idx]>arr[prev]){
            ans+=1 + MaxSeq(n, arr, idx+1, idx);
        }
        return Math.min(ans, ignore);
    }
}
