// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.*;
// import java.util.*;
// public class MovieTickets {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         long[] arrival = new long[n];
//         long[] dept = new long[n];
//         for(int i = 0;i<n;i++){
//             st = new StringTokenizer(br.readLine());
//             arrival[i] = Long.parseLong(st.nextToken());
//             dept[i] = Long.parseLong(st.nextToken());
//         }
//         mergeSort(arrival, 0, n-1);
//         mergeSort(dept, 0, n-1);
//         System.out.println(MergedInterval(n,arrival,dept));    
//     }
//     public static int MergedInterval(int n,long[] arrival,long[] dept){
        
//         if(n<2) return 0;
//         int ans=1;
//         int ap = 1;
//         int dp = 0;
        
//         while(ap<n){
//             if(arrival[ap]>=dept[dp]){
//                 ans++;
//                 ap++;
//                 dp++;
//             }
//             else{
//                 ap++;
//             }
//         }
//         //ans=ap-dp;
//         return ans;
//     }
//     public static void mergeSort(long[] arr, int left, int right){
//         if(left>=right) return;
//         int mid = left + (right-left)/2;
//         mergeSort(arr, left, mid);
//         mergeSort(arr, mid+1, right);
//         merge(arr, left, mid, right);
//     }
//     public static void merge(long[] arr, int left,int mid, int right){
//         int n1 = mid-left+1;
//         int n2 = right-mid;
//         long[] l = new long[n1];
//         long[] r = new long[n2];
//         System.arraycopy(arr, left, l, 0, n1);
//         System.arraycopy(arr, mid+1, r, 0, n2);
//         int i = 0, j = 0,k=left;
//         while (i<n1 && j<n2) {
//             if(l[i]<r[j]){
//                 arr[k++] = l[i++];
//             }
//             else arr[k++] = r[j++];
//         }
//         while (i<n1) {
//             arr[k++] = l[i++];
//         }
//         while (j<n2) {
//             arr[k++] = r[j++];
//         }
//     }
// }
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class MovieTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[] arrival = new long[n];
        long[] dept = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arrival[i] = Long.parseLong(st.nextToken());
            dept[i] = Long.parseLong(st.nextToken());
        }

        mergeSort(arrival, 0, n - 1);
        mergeSort(dept, 0, n - 1);

        System.out.println(MergedInterval(n, arrival, dept));
    }

    public static int MergedInterval(int n, long[] arrival, long[] dept) {
        if (n < 2) return 0;

        int ans = 1;
        int ap = 1, dp = 0;

        while (ap < n) {
            if (arrival[ap] >= dept[dp]) {
                // One show is over, so a new one can reuse the same slot
                dp++;
            } else {
                // New show overlaps, need another room
                ans++;
            }
            ap++;
        }

        return ans;
    }

    public static void mergeSort(long[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(long[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        long[] l = new long[n1];
        long[] r = new long[n2];

        System.arraycopy(arr, left, l, 0, n1);
        System.arraycopy(arr, mid + 1, r, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < n1) {
            arr[k++] = l[i++];
        }
        while (j < n2) {
            arr[k++] = r[j++];
        }
    }
}
