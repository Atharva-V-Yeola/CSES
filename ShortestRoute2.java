import java.io.*;
import java.util.*;

public class ShortestRoute2 {
    static final long INF = (long) 1e18;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // number of cities
        int m = Integer.parseInt(st.nextToken()); // number of roads
        int q = Integer.parseInt(st.nextToken()); // number of queries

        long[][] dist = new long[n + 1][n + 1];

        // Initialize distance matrix
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Read roads
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c); // undirected
        }

        // Floyd-Warshall Algorithm
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Answer queries
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (dist[a][b] == INF) {
                sb.append("-1\n");
            } else {
                sb.append(dist[a][b]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
