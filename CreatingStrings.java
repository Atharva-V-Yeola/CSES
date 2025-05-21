// import java.util.Scanner;

// public class CreatingStrings {
//     public static void Permutation(int n, StringBuilder sb){
//         sb.append(n*(n-1)).append('\n');
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         StringBuilder sb = new StringBuilder();
//         System.out.println(Permutation(n,sb));
//         sc.close();
//     }
// }
import java.util.*;

public class CreatingStrings {
    
    // Function to generate all permutations of string S
    static Set<String> solve(String S) {
        int N = S.length();
        char[] charArray = S.toCharArray();
        Arrays.sort(charArray);
        
        // Set to store all the unique permutations
        TreeSet<String> uniqueStrings = new TreeSet<>();
        
        do {
            uniqueStrings.add(new String(charArray));
        } while (nextPermutation(charArray));
        
        return uniqueStrings;
    }

    // Function to find the next lexicographically greater permutation
    static boolean nextPermutation(char[] array) {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            return false; // No next permutation is possible
        }

        int j = array.length - 1;
        while (array[j] <= array[i]) {
            j--;
        }

        // Swap the characters at positions i and j
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        // Reverse the suffix after i
        reverse(array, i + 1, array.length - 1);

        return true;
    }

    // Function to reverse the characters in the array from start to end
    static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Sample Input
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        Set<String> uniqueStrings = solve(S);

        System.out.println(uniqueStrings.size());
        for (String str : uniqueStrings) {
            System.out.println(str);
        }
        sc.close();
    }
}
