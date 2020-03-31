import java.io.*;
import java.util.*;

public class Troublemakers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int loop = Integer.parseInt(scan.nextLine().trim());
        for (int i = 0; i < loop; i++) {
            String str = scan.nextLine();
            String[] split = str.split(" ");
            int n = Integer.parseInt(split[0]);
            int pairs = Integer.parseInt(split[1]);
            int[][] arr = new int[n + 1][n + 1];
            for (int j = 0; j < pairs; j++) {
                str = scan.nextLine();
                split = str.split(" ");
                int u = Integer.parseInt(split[0]);
                int v = Integer.parseInt(split[1]);
                // System.out.println(u + " " + v);
                arr[u][v] = arr[v][u] = 1;
            }
            // for(int[] a : arr)
            //     System.out.println(Arrays.toString(a));
            int[] ran = new int[n + 1];
            for (int j = 1; j < n + 1; j++) {
                int a = 0;
                int b = 0;
                for (int k = 1; k < j; k++) {
                    if (ran[k] == 0) {
                        // System.out.println(j + " " + k);
                        a += arr[j][k];
                    } else {
                        // System.out.println(j + " " + k);
                        b += arr[j][k];
                    }
                }
                if (a <= b) {
                    ran[j] = 0;
                } else {
                    ran[j] = 1;
                }
            }
            String s = "";
            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if (ran[j] == 0) {
                    s += j + " ";
                    count++;
                }
            }
            System.out.println("Case #"+(i + 1)+": "+count + "\n" + s);
        }
    }
}