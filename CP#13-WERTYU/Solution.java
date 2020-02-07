import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String keys = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        int f = 0;
        while (scan.hasNextLine()) {
            f = 1;
            String str = scan.nextLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ')
                    System.out.print(" ");
                else if (str.charAt(i) == ':' || str.charAt(i) == '`')
                    System.out.print(str.charAt(i));
                else
                    System.out.print(keys.charAt(keys.indexOf(str.charAt(i)) - 1));
            }
            System.out.println();
        }
        if (f == 0)
            System.out.println();
    }
}
