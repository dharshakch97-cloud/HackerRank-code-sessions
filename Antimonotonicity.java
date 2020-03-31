import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        int tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            st = new StringTokenizer(scan.nextLine());
            int N = Integer.parseInt(st.nextToken());
            int sequence = 1, in = 0;
            int elem = Integer.parseInt(st.nextToken());
            for (int i = 1; i < N; i++) {
                int cur_elem = Integer.parseInt(st.nextToken());
                if(in == 0 && elem > cur_elem || in == 1 && elem < cur_elem) {
                    ++sequence;
                    in ^= 1;
                }
                elem = cur_elem;
            }
            System.out.println(sequence);
        }
    }
}