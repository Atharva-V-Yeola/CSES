// import java.util.Arrays;
// import java.util.Scanner;
// import java.io.IOException;

// public class Apartments {
//     public static void main(String[] args) throws IOException{
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         int k = sc.nextInt();

//         int[] a = new int[n];
//         int[] b = new int[m];

//         for(int i = 0;i<n;i++){
//             a[i] = sc.nextInt();
//         }
//         for(int i = 0;i<m;i++){
//             b[i] = sc.nextInt();
//         }
//         Arrays.sort(a);
//         Arrays.sort(b);
//         int app=0,apt=0;
//         int ans = 0;
//         while(app<n && apt<m){
//             if(Math.abs(a[app]-b[apt])<=k){
//                 ans++;
//                 app++;
//                 apt++;
//             }
//             else if(a[app]<b[apt]) app++;
//             else apt++;
//         }
//         System.out.println(ans);
//         sc.close();
//     }
// }
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read first line: n, m, k
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        long k = Long.parseLong(firstLine[2]);

        // Read desired apartment sizes
        String[] aStr = br.readLine().split(" ");
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(aStr[i]);
        }

        // Read available apartment sizes
        String[] bStr = br.readLine().split(" ");
        long[] b = new long[m];
        for (int i = 0; i < m; i++) {
            b[i] = Long.parseLong(bStr[i]);
        }
        System.out.println(Possible(a,b,n,m,k));
    }
    public static int Possible(long[] a,long[] b, int n, int m, long k){
        //int ans = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        int app = 0, apt = 0, ans = 0;
        while (app < n && apt < m) {
            if (Math.abs(a[app] - b[apt]) <= k) {
                ans++;
                app++;
                apt++;
            } else if (a[app] < b[apt]) {
                app++;
            } else {
                apt++;
            }
        }
        return ans;
    }
}
