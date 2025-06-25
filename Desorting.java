//import java.io.*;
import java.util.*;

public class Desorting{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    int ans;
    while(cases-->0){
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int idx = 0;idx<size;idx++){
            arr[idx]= sc.nextInt();
        }
        int diff= Integer.MAX_VALUE;
        for(int idx = 1;idx<size;idx++){
            int temp;
            if(arr[idx]>=arr[idx-1]){
                temp = arr[idx]-arr[idx-1];
                diff = Math.min(temp,diff);
            }
            else{
                System.out.println(0);
                break;
            }
        }
        ans = diff/2 + 1;  
        System.out.println(ans);
    }
    sc.close();
}
}