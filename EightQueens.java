import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EightQueens {

    static void solve(List<StringBuilder> board, int row,
                      boolean[] occupiedCol,
                      boolean[] occupiedPrimary,
                      boolean[] occupiedSecondary, int[] ans) {
        if (row == 8) {
            ans[0]++;
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (board.get(row).charAt(col) == '*' || occupiedCol[col]
                || occupiedPrimary[row - col + 8]
                || occupiedSecondary[row + col]) {
                continue;
            }

            board.get(row).setCharAt(col, 'Q');
            occupiedCol[col] = occupiedPrimary[row - col + 8]
                = occupiedSecondary[row + col] = true;

            solve(board, row + 1, occupiedCol, occupiedPrimary,
                  occupiedSecondary, ans);

            board.get(row).setCharAt(col, '.');
            occupiedCol[col] = occupiedPrimary[row - col + 8]
                = occupiedSecondary[row + col] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StringBuilder> board = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            while (true) {
                String input = scanner.nextLine();
                if (input.length() == 8 && input.matches("[.*]{8}")) {
                    rowBuilder.append(input);
                    board.add(rowBuilder);
                    break;
                } else {
                    rowBuilder.setLength(0); 
                }
            }
        }

        boolean[] occupiedCol = new boolean[8];
        boolean[] occupiedPrimary = new boolean[16];
        boolean[] occupiedSecondary = new boolean[16];
        int[] ans = {0};

        solve(board, 0, occupiedCol, occupiedPrimary, occupiedSecondary, ans);

        System.out.println(ans[0]);
        scanner.close();
    }
}
