// // import java.util.Arrays;
// // import java.util.Scanner;
// // import java.io.IOException;

// // public class Apartments {
// //     public static void main(String[] args) throws IOException{
// //         Scanner sc = new Scanner(System.in);
// //         int n = sc.nextInt();
// //         int m = sc.nextInt();
// //         int k = sc.nextInt();

// //         int[] a = new int[n];
// //         int[] b = new int[m];

// //         for(int i = 0;i<n;i++){
// //             a[i] = sc.nextInt();
// //         }
// //         for(int i = 0;i<m;i++){
// //             b[i] = sc.nextInt();
// //         }
// //         Arrays.sort(a);
// //         Arrays.sort(b);
// //         int app=0,apt=0;
// //         int ans = 0;
// //         while(app<n && apt<m){
// //             if(Math.abs(a[app]-b[apt])<=k){
// //                 ans++;
// //                 app++;
// //                 apt++;
// //             }
// //             else if(a[app]<b[apt]) app++;
// //             else apt++;
// //         }
// //         System.out.println(ans);
// //         sc.close();
// //     }
// // }
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;
// import java.util.Arrays;

// public class Apartments {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String[] firstLine = br.readLine().split(" ");
//         int n = Integer.parseInt(firstLine[0]);
//         int m = Integer.parseInt(firstLine[1]);
//         Long k = Long.parseLong(firstLine[2]);
//         String[] aStr = br.readLine().split(" ");

//         Long[] a = new Long[n];
//         for (int i = 0; i < n; i++) {
//             a[i] = Long.parseLong(aStr[i]);
//         }

//         String[] bStr = br.readLine().split(" ");
//         Long[] b = new Long[m];
//         for (int i = 0; i < m; i++) {
//             b[i] = Long.parseLong(bStr[i]);
//         }
//         System.out.println(Possible(a,b,n,m,k));
//     }
//     public static int Possible(Long[] a,Long[] b, int n, int m, Long k){
//         //int ans = 0;
//         Arrays.sort(a);
//         Arrays.sort(b);

//         int app = 0, apt = 0, ans = 0;
//         while (app < n && apt < m) {
//             if (Math.abs(a[app] - b[apt]) <= k) {
//                 ans++;
//                 app++;
//                 apt++;
//             } else if (a[app] < b[apt]) {
//                 app++;
//             } else {
//                 apt++;
//             }
//         }
//         return ans;
//     }
// }
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;
// import java.util.Arrays;

// public class Apartments {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         // Read first line: n, m, k
//         String[] firstLine = br.readLine().split(" ");
//         int n = Integer.parseInt(firstLine[0]);
//         int m = Integer.parseInt(firstLine[1]);
//         long k = Long.parseLong(firstLine[2]);

//         // Read desired apartment sizes
//         String[] aStr = br.readLine().split(" ");
//         long[] a = new long[n];
//         for (int i = 0; i < n; i++) {
//             a[i] = Long.parseLong(aStr[i]);
//         }

//         // Read available apartment sizes
//         String[] bStr = br.readLine().split(" ");
//         long[] b = new long[m];
//         for (int i = 0; i < m; i++) {
//             b[i] = Long.parseLong(bStr[i]);
//         }

//         System.out.println(findMatches(a, b, n, m, k));
//     }

//     public static int findMatches(long[] a, long[] b, int n, int m, long k) {
//         Arrays.sort(a);
//         Arrays.sort(b);

//         int app = 0, apt = 0, ans = 0;

//         while (app < n && apt < m) {
//             if (b[apt] >= a[app] - k && b[apt] <= a[app] + k) {
//                 ans++;
//                 app++;
//                 apt++;
//             } else if (b[apt] < a[app] - k) {
//                 apt++;
//             } else {
//                 app++;
//             }
//         }

//         return ans;
//     }
// }
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n, m, k
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        long k = Long.parseLong(firstLine[2]);

        // Read desired apartment sizes
        long[] a = new long[n];
        String[] aStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(aStr[i]);
        }

        // Read available apartment sizes
        long[] b = new long[m];
        String[] bStr = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Long.parseLong(bStr[i]);
        }

        mergeSort(a, 0, n - 1);
        mergeSort(b, 0, m - 1);

        System.out.println(matchApartments(a, b, k));
    }

    public static int matchApartments(long[] a, long[] b, long k) {
        int i = 0, j = 0, matches = 0;
        int n = a.length, m = b.length;

        while (i < n && j < m) {
            if (b[j] < a[i] - k) {
                j++;
            } else if (b[j] > a[i] + k) {
                i++;
            } else {
                matches++;
                i++;
                j++;
            }
        }

        return matches;
    }

    // Merge Sort implementation for long[]
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
