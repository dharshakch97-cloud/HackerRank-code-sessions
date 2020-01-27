import java.util.ArrayList;
import java.util.*;

/**
 * 
 * @author Dharshak
 */
public class LongCollatzSequence {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();
        int[] a = new int[tc];
        for (int i = 0; i < tc; i++) {
            int limit = scan.nextInt();
            int size = 0, max = 1, j = 0;
            for (int k = 2; k < limit; k++) {
                size = getSeq_Size(k);
                // System.out.println(size + " " + k);
                if (size >= max) {
                    max = size;
                    j = k;
                }
            }
            // System.out.println(j);
            a[i] = j;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static int getSeq_Size(int n) {
        long num = n;
        List<Long> seq_list = new ArrayList<>();
        int s = 0;
        while (num != 1) {
            seq_list.add(num);
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = 3 * num + 1;
            }
        }
        s = seq_list.size();
        return s;
    }
}