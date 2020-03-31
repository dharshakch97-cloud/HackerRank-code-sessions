import java.io.*;
import java.util.*;

public class Scarecrow {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        int tc = Integer.parseInt(st.nextToken());
        int t = 0;
        while (tc-- > 0) {
            st = new StringTokenizer(scan.nextLine());
            int n = Integer.parseInt(st.nextToken());
            String line = scan.nextLine();
            char[] l = line.toCharArray();
            int c = 0;
            for (int i = 0; i < l.length; ) {
                if (l[i] == '#')
                    i++;
                else {
                    i += 3;
                    c++;
                }
            }
            t++;
            System.out.println("Case " + t + ": " + c);
            // t++;
        } 
    }
}