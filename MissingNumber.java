import java.util.Scanner;

public class MissingNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] arr = new long[(int)n-1];
        for(int i = 0;i<n-1;i++){
            arr[i] = sc.nextLong();
        }
        System.out.println(FindNo(arr,n));
        sc.close();
    }
    public static long FindNo(long[] arr, long n){
        //long ans = 1;
        long sum = n*(n+1)/2;
        for(int i=0;i<n-1;i++){
            sum-=arr[i];
        }
        return sum;
    }
}