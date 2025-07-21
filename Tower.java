// import java.io.*;
// import java.util.*;
// import java.util.Map.Entry;

// public class Tower {

//     // Function to find the minimum number of towers
//     static long solve(long N, ArrayList<Long> cubes) {
//         long ans = 0;

//         TreeMap<Long, Integer> topElements = new TreeMap<>();

//         for (int i = 0; i < N; i++) {
//             long current = cubes.get(i);

//             // Find smallest top cube > current
//             Entry<Long, Integer> entry = topElements.higherEntry(current);

//             if (entry == null) {
//                 ans++;  // No tower can accept → start new
//             } else {
//                 // Use that tower, reduce count or remove
//                 if (entry.getValue() == 1) {
//                     topElements.remove(entry.getKey());
//                 } else {
//                     topElements.put(entry.getKey(), entry.getValue() - 1);
//                 }
//             }

//             // Put current cube as new top
//             topElements.put(current, topElements.getOrDefault(current, 0) + 1);
//         }

//         return ans;
//     }

//     public static void main(String[] args) throws IOException {
//         // BufferedReader for fast input
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         // Read N
//         //System.out.print("Enter number of cubes: ");
//         long N = Long.parseLong(br.readLine());

//         // Read cube sizes
//         //System.out.println("Enter cube sizes separated by space:");
//         String[] input = br.readLine().split(" ");
//         ArrayList<Long> cubes = new ArrayList<>();

//         for (int i = 0; i < N; i++) {
//             cubes.add(Long.parseLong(input[i]));
//         }

//         // Solve and print result
//         long result = solve(N, cubes);
//         System.out.println(result);
//     }
// }
import java.util.*;
import java.io.*;

public class Tower {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(TowerCount(n,arr));
    }
    public static int upperBound(ArrayList<Long> list, long num){
        int low = 0,high = list.size();

        while (low<high) {
            int mid = high-low+(high/2);
            if(list.get(mid)<=num){
                low = mid+1;
            }
            else mid = high;
        }
        return low;
    }
    public static int TowerCount(int n, long[] arr){
        ArrayList<Long> temp = new ArrayList<>();
        for(int i= 0; i<n; i++){
            if(temp.size()==0){
                temp.add(0, arr[i]);
            }
            else if(arr[i]>=temp.get(temp.size()-1)){
                temp.add(temp.size()-1,arr[i]);
            }
            else {
                int idx = upperBound(temp, arr[i]);
                temp.set(idx,arr[i]);
            }
        }
        
        return temp.size();
    }
}