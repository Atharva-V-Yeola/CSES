import java.util.*;
public class raabGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //System.out.print("Enter number of test cases: ");
        int t = sc.nextInt(); // number of test cases

        for (int test = 1; test <= t; test++) {
            //System.out.println("\nTest case " + test + ":");
            //System.out.print("Enter n (cards per player): ");
            int n = sc.nextInt();
            //System.out.print("Enter a (score of player 1): ");
            int a = sc.nextInt();
            //System.out.print("Enter b (score of player 2): ");
            int b = sc.nextInt();

            if (a + b > n) {
                System.out.println("NO");
                continue;
            }

            List<Integer> p1Cards = new ArrayList<>();
            List<Integer> p2Cards = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                p1Cards.add(i);
                p2Cards.add(i);
            }

            // Sort player 1 descending to win 'a' rounds
            Collections.sort(p1Cards, Collections.reverseOrder());

            int[] player1 = new int[n];
            int[] player2 = new int[n];

            int i = 0;

            // Assign wins to Player 1
            for (; i < a; i++) {
                player1[i] = p1Cards.get(i); // High card
                player2[i] = p2Cards.get(n - a + i); // Low card
            }

            // Assign wins to Player 2
            for (int j = 0; j < b; j++, i++) {
                player1[i] = p1Cards.get(n - b + j); // Low card
                player2[i] = p2Cards.get(j); // High card
            }

            // Remaining are ties
            for (; i < n; i++) {
                player1[i] = p1Cards.get(i);
                player2[i] = p2Cards.get(i);
            }

            System.out.println("YES");
            //System.out.print("Player 1 cards: ");
            printArray(player1);
            //System.out.print("Player 2 cards: ");
            printArray(player2);
        }
        sc.close();
    }

    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}


