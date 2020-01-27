import java.io.*;
import java.util.*;

class BinarySearch {
    
    public static String binarySearch(String[] a, int l, int h, String k) {        
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (a[m] == k) {
                System.out.println("equals");
                return k;
            }
            else if (a[m].equals(k)) {
                System.out.println("left");
                return binarySearch(a, l, m - 1, k);
            }
            else {
                System.out.println("right");
                return binarySearch(a, m + 1, h, k);
            }
        }
        System.out.println("Not found");
        return "-1";
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // read first line
        String num = br.readLine(); // read next line
        String[] a = num.split(" "); // split into int array
        // System.out.println(Arrays.toString(a));
        // for (int i = 0; i < a.length; i++)
        String key = br.readLine(); // read last line
        
        String retValue = binarySearch(a, 0, a.length - 1, key);
        String s = "";
        int c = 0;
        System.out.println(retValue);
        // if (retValue == "-1")
        //     s += "-1 -1 0";
        // else {
        //     for (int i = 0; i <= a.length - 1; i++) {
        //         if (a[i] == key)
        //             s += i;
        //             c += 1;
        //     }
        // }
        // s += c;
        // System.out.println(s);
    }
}