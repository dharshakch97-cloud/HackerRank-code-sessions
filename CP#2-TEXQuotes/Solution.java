import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int c = 0;
        Scanner scan = new Scanner(System.in);
        
        while (scan.hasNext()) {
            String str = scan.nextLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '\"') {
                    if (c == 0) {
                        System.out.print("``");
                        c = 1;
                        continue;
                    }
                    else {
                        System.out.print("''");
                        c = 0;
                        continue;
                    }
                }
                System.out.print(str.charAt(i));
            }
            // System.out.println("\n");
        }
    }
}