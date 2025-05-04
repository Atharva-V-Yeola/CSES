import java.util.Scanner;

public class LongestRepetation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = input.length();
        System.out.println(Cnt(input,n));
        sc.close();
    }
    static int Cnt(String input, int n){
        int ans = 0;
        int l=0,r=0;
        while (r!=n) {
            //int temp = 0;
            if(input.charAt(l)==input.charAt(r)) r++;
            else{
                l=r;
                r++;
            }
            ans = Math.max(ans,r-l);
        }
        return ans;
    }
}
