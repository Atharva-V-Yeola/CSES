import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class temp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            String[] parts = br.readLine().split(" ");
            long row = Long.parseLong(parts[0]);
            long col = Long.parseLong(parts[1]);
            long sq;

            if (row > col) {
                sq = (row - 1) * (row - 1);
                if (row % 2 != 0)
                    sq += col;
                else
                    sq += 2 * row - col;
                sb.append(sq).append('\n');
            } else {
                sq = (col - 1) * (col - 1);
                if (col % 2 == 0)
                    sq += row;
                else
                    sq += 2 * col - row;
                sb.append(sq).append('\n');
            }
        }
        System.out.print(sb);
    }
}
