import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class coinPiles {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            String[] prt = br.readLine().split(" ");
            Long a = Long.parseLong(prt[0]);
            Long b = Long.parseLong(prt[1]);
            
            if(((2*b-a)%3!=0 || (2*b-a)<0) || ((2*a-b)%3!=0 || (2*a-b)<0)) sb.append("NO").append('\n');
            else sb.append("YES").append('\n');
            n--;
        }
        System.out.println(sb);
    }
    
}
