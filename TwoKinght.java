import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TwoKinght {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if(n==1) System.out.println(0);
        else{
        sb.append(0).append('\n');
        sb.append(6).append('\n');
        for(int i = 3;i<=n;i++){
            long total = (long)i*i*(i*i-1)/2;
            long kill = 4L*(i-1)*(i-2);
            long ans = total - kill;
            sb.append(ans).append('\n');
        }
    }
        System.out.println(sb);
    }
}
