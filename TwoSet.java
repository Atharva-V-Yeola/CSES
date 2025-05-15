import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.io.IOException;
public class TwoSet {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        
        makeSet(n);
    }
    public static void makeSet(Long n){
        StringBuilder sb = new StringBuilder();
        HashSet<Long> st1 = new HashSet<>();
        HashSet<Long> st2 = new HashSet<>();
        Long sum = n*(n+1)/2;
        if(sum%2!=0) sb.append("NO");
        else{
            sb.append("YES").append('\n');
            long tar = sum/2;
            for(long i = n;i>0;i--){
                if(tar-i>=0){
                    st1.add(i);
                    tar-=i;
                }
                else st2.add(i);
            }
            sb.append(st1.size()).append('\n');
            for(long a : st1){
                sb.append(a).append(" ");
            }
            sb.append('\n');
            sb.append(st2.size()).append('\n');
            for(long b : st2){
                sb.append(b).append(" ");
            }
        }
        System.out.println(sb);
    }
}
