import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class ForestQueries {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        //sc.nextLine();
        int[][] forest = new int[n][n];
        for(int i = 0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++){
                forest[i][j] = (line.charAt(j)=='*') ? 1:0;
            }
        }
        
        int[][] queries = new int[q][4];
        for(int i = 0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<4;j++){
                queries[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        TreeCount(n,q,forest,queries);
        //sc.close();
    }
    public static void TreeCount(int n,int q,int[][] forest,int[][] queries){
        StringBuilder sb = new StringBuilder();
        int[][] prefixSum = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                prefixSum[i][j] = forest[i][j];
                if(i>0) prefixSum[i][j] +=prefixSum[i-1][j];
                if(j>0) prefixSum[i][j] += prefixSum[i][j-1];
                if(i>0 && j>0) prefixSum[i][j] -= prefixSum[i-1][j-1];
            }
        }
        for(int i = 0;i<q;i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] -1 ;
            int x2 = queries[i][2] -1;
            int y2 = queries[i][3] -1;

            int ans = prefixSum[x2][y2];
            if(x1>0) ans-=prefixSum[x1-1][y2];
            if(y1>0) ans -= prefixSum[x2][y1-1];
            if(x1>0 && y1>0) ans+=prefixSum[x1-1][y1-1];

            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
