import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String[] d = scan.nextLine().split(" ");
            int a = Integer.parseInt(d[0]);
            int b = Integer.parseInt(d[1]);
            boolean z = false;
            int temp = 0;
            if (b < a) {
                z = true;
                temp = a;
                a = b;
                b = temp;
            }
            int max = 0;
            for (int i = a; i <= b; i++) {
                int c = 0;
                int j = i;
                // System.out.println("a:" + j);
                while (j >= 1) {
                    // System.out.println("seq:" + j);
                    c++;
                    if (j == 1) {
                        break;
                    }
                    if (j % 2 == 0)
                        j = j / 2;
                    else
                        j = 3 * j + 1;
                }
                if (c > max)
                    max = c;
            }
            if(z) {
                System.out.println(b + " " + a + " " + max);
            }
            else {
                System.out.println(a + " " + b + " " + max);
            }
        }
    }
}