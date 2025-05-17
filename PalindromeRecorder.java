import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PalindromeRecorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inpt = sc.nextLine();
        long n = inpt.length();
        ArrayList<Character> list = new ArrayList<>();
        String ans = "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : inpt.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char k : map.keySet()){
            long cnt = 0;
            long freq = map.get(k);
            if(freq%2!=0) cnt+=1;
            if(n%2!=0 && cnt!=1 || n%2==0 && cnt!=0){
                ans = "NO SOLUTION";
                break;
            }
            else{
                
            }

        }
        System.out.println(ans);
        sc.close();
    }
}
