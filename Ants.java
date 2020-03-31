import java.io.*;
import java.util.*;

public class Ants {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(scan.nextLine());
            // String[] st = scan.nextLine().split(" ");
            int P = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int min = 0, max = 0;
            st = new StringTokenizer(scan.nextLine());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                min = Math.max(min, Math.min(k, P - k));
                max = Math.max(max, Math.max(k, P - k));
                // System.out.println(min + " " + max);
            }
            System.out.println(min + " " + max);
        }
    }
}