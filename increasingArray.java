import java.util.Scanner;

public class increasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextLong();
        }
        System.out.println(Moves(arr,n));
        sc.close();
    }
    public static long Moves(long[] arr,int n){
        long ans = 0;
        for(int i = 1;i<n;i++){
            if(arr[i]<arr[i-1]){
                ans += arr[i-1]-arr[i];
                arr[i]=arr[i-1];   
            }
        }
        return ans;
    }
}
