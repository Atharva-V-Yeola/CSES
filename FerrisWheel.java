import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String[] f = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        //String[] inp = br.readLine().split(" ");
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int l = 0,r = n-1;
        long ans=0;
        while (l<=r) {
            long temp = arr[l]+arr[r];
            if(temp<=x){
                l++;
            }
            r--;
            ans++;
        }
        System.out.println(ans);
    }
}
