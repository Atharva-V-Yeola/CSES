import java.io.*;
import java.util.*;

public class ConcertTickets {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] ticket = new long[n];
        long[] customer = new long[m];
        for(int i = 0;i<n;i++){
            ticket[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++){
            customer[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(accepted(n,m,ticket,customer));
    }
    public static void accepted(int n, int m,long[] ticket,long[] customer){
        StringBuilder sb = new StringBuilder();
        Arrays.sort(ticket);
        Arrays.sort(customer);
        
    }
}
