import java.util.*;

public class WeirdAlgorithm {
    public static ArrayList<Long> algo(Long n){
        ArrayList<Long> list = new ArrayList<>();
        list.add(n);
        while (n!=1) {
        if(n%2!=0){
            list.add(3*n+1);
        }
        else{
            list.add(n/2);
        }
        n=list.get(list.size()-1);
    }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        ArrayList<Long> res = algo(n);
        for (long num : res) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}