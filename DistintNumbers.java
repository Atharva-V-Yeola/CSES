import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.io.IOException;
public class DistintNumbers {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // long n = sc.nextLong();
        // HashSet<Long> set = new HashSet<>();
        // for(long i =0;i<n;i++){
        //     set.add(sc.nextLong());
        // } 
        // System.out.println(set.size());
        // sc.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        HashSet<Long> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            set.add(Long.parseLong(num[i]));
        }
        System.out.println(set.size());
    }
}
