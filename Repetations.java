import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Repetations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = input.length();
        System.out.println(Cnt(input,n));
        sc.close();
    }
    static int Cnt(String input, int n){
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(char ch: input.toCharArray()){
            if(set.contains(ch)) ans++;
            set.add(ch);
        }
        return ans;
    }
}
