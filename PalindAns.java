import java.util.*;
public class PalindAns {
    static String solve(String S) {
        int N = S.length();
        Map<Character, Integer> freqMap = new HashMap<>();

        // Step 1: Count character frequencies
        for (char c : S.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Count odd frequencies
        int oddCount = 0;
        Character oddChar = null;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
                oddChar = entry.getKey();
            }
        }

        if (oddCount > 1)
            return "NO SOLUTION";

        // Step 3: Build the palindrome
        StringBuilder firstHalf = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            // Add half to first half
            for (int i = 0; i < count / 2; i++) {
                firstHalf.append(ch);
            }

            // Add odd character to middle
            if (count % 2 != 0) {
                for (int i = 0; i < count % 2; i++) {
                    middle.append(ch);
                }
            }
        }

        // Step 4: Combine first half + middle + reversed first half
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        return firstHalf.toString() + middle.toString() + secondHalf;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        System.out.println(solve(S));  // Sample Output: AAACBCAAA
        sc.close();
    }
}


