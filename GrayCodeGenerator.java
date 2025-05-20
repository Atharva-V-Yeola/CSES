import java.util.*;

public class GrayCodeGenerator {

    public static List<String> generateGrayCode(int n) {
        List<String> result = new ArrayList<>();
        int totalNumbers = 1 << n; // 2^n

        for (int i = 0; i < totalNumbers; i++) {
            int gray = i ^ (i >> 1);
            String binary = Integer.toBinaryString(gray); // Convert to binary string
            StringBuilder paddedBinary = new StringBuilder();

            // Add leading 0s to make it n bits
            for (int j = 0; j < n - binary.length(); j++) {
                paddedBinary.append('0');
            }

            paddedBinary.append(binary); // Add the actual binary digits
            result.add(paddedBinary.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Change n as needed
        List<String> grayCodes = generateGrayCode(n);
        for (String code : grayCodes) {
            System.out.println(code);
        }
        sc.close();
    }
}
