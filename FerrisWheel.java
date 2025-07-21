import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String[] f = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        //String[] inp = br.readLine().split(" ");
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        mergeSort(arr, 0, n-1);
        int l = 0,r = n-1;
        long ans=0;
        while (l<=r) {
            long temp = arr[l]+arr[r];
            if(temp<=x){
                l++;
            }
            r--;
            ans++;
        }
        System.out.println(ans);
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

        long[] L = new long[n1];
        long[] R = new long[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
