import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class trailingeros {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int p = (int)Math.log(n)/(int)Math.log(5);
        System.out.println(cntZeros(n,p));
    }
    static long cntZeros(long n,int p){
        long ans = 0;
        for(int i = 1;i<=p;i++){
            ans+=n/(long)Math.pow(5, i);
        }
        return ans;
    }
}
