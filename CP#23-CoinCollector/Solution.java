import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(scan.nextLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0, prev = 0, count = 0;
            st =new StringTokenizer(scan.nextLine());
            for (int j = 0; j < n; j++) {
                int coin = Integer.parseInt(st.nextToken());
                if (sum + prev < coin) {
                    count++;
                    sum += prev;
                }
                prev = coin;
            }
            System.out.println(count);
        }
        scan.close();
    }
}
