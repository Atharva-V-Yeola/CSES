import java.util.*;

public class Labyrinth {
    static int[] h = {1, -1, 0, 0};  // down, up, right, left
    static int[] v = {0, 0, 1, -1};
    static boolean[][] vis;
    static char[][] par;
    static int[][] dist;
    static int N, M, sx, sy, ex, ey;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        vis = new boolean[N][M];
        par = new char[N][M];
        dist = new int[N][M];
        Queue<int[]> Q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < M; j++) {
                char c = row.charAt(j);
                if (c == '#') {
                    vis[i][j] = true;
                } else if (c == 'A') {
                    sx = i;
                    sy = j;
                } else if (c == 'B') {
                    ex = i;
                    ey = j;
                }
            }
        }

        vis[sx][sy] = true;
        Q.add(new int[]{sx, sy});

        while (!Q.isEmpty()) {
            int[] P = Q.poll();
            for (int i = 0; i < 4; i++) {
                int dx = P[0] + h[i];
                int dy = P[1] + v[i];
                if (0 <= dx && dx < N && 0 <= dy && dy < M && !vis[dx][dy]) {
                    if (i == 0) par[dx][dy] = 'D';
                    else if (i == 1) par[dx][dy] = 'U';
                    else if (i == 2) par[dx][dy] = 'R';
                    else if (i == 3) par[dx][dy] = 'L';
                    dist[dx][dy] = dist[P[0]][P[1]] + 1;
                    vis[dx][dy] = true;
                    Q.add(new int[]{dx, dy});
                }
            }
        }

        if (!vis[ex][ey]) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        System.out.println(dist[ex][ey]);

        // Trace back the path
        StringBuilder path = new StringBuilder();
        int x = ex, y = ey;
        for (int i = dist[ex][ey]; i > 0; i--) {
            char dir = par[x][y];
            path.append(dir);
            if (dir == 'D') x--;
            else if (dir == 'U') x++;
            else if (dir == 'R') y--;
            else if (dir == 'L') y++;
        }

        System.out.println(path.reverse());
    }
}
