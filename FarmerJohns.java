import java.util.Scanner;

public class FarmerJohns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0) {
            int n = sc.nextInt();
            System.out.println(CntAnimals(n));
            t--;
        }
        sc.close();
    }
    public static int CntAnimals(int n){
        int ans = 0;
        if(n<2) return 0;
        if(n<4) return 1;
        if(n%4==0){
            ans = n/4;
        }
        else if (n%4==2) {
            ans = 1 + n/4;
        }
        return ans;
    }
}
