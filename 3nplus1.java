import java.io.*;
import java.util.*;

public class 3nplus1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int c =0;
            int n = Integer.parseInt(scan.nextLine());
            while(n >= 1) {
            // System.out.println(n);
            c++;
            if (n == 1) break;
            if (n % 2 == 0)
                n = n / 2;
            else
                n = 3 * n + 1;
        }
        System.out.println(c);
        }
    }
}