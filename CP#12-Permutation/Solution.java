import java.util.*;

public class Solution {
    public static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }

    public static String nThPermutation(String str, long n) {
        char[] s = str.toCharArray();
        Arrays.sort(s);
        StringBuilder sb = new StringBuilder(new String(s));
        String res = "";
        while (n != 0) {
            int k = (int) (n / factorial(sb.length() - 1));
            long mod = n % factorial(sb.length() - 1);
            res = res + sb.charAt(k);
            sb.deleteCharAt(k);
            n = mod;
        }
        return res + sb;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();
        while (tc-- > 0) {
            String str = scan.next();
            long n = scan.nextLong();
            System.out.println(nThPermutation(str, n));
        }
    }
}
