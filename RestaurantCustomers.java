import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
public class RestaurantCustomers {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] arrival = new long[n];
        long[] dept = new long[n];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arrival[i] = Long.parseLong(st.nextToken());
            dept[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(MergedInterval(n,arrival,dept));    
    }
    public static int MergedInterval(int n,long[] arrival,long[] dept){
        Arrays.sort(arrival);
        Arrays.sort(dept);
        if(n<2) return 0;
        int ans=0;
        int ap = 0;
        int dp = 0;
        int crr =0;
        
        while(ap<n){
            if(arrival[ap]<=dept[dp]){
                crr++;
                ans = Math.max(ans, crr);
                ap++;
            }
            else{
                crr--;
                dp++;
            }
        }
        //ans=ap-dp;
        return ans;
    }
}
