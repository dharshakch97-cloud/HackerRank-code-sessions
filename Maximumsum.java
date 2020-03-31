import java.io.*;
import java.util.*;

public class Maximumsum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            int N = Integer.parseInt(scan.nextLine());
            if (N == 0)
                break;
            int c = 0;
            for (int i = 0; i < N; i++) {
                int elem = Integer.parseInt(scan.nextLine());
                if (elem == 0) {
                    c++;
                }
                if (elem > 0) {
                    System.out.print(elem + " ");
                }
            }
            if (c == N) System.out.println(0);
            else System.out.println();
        }
    }
}
