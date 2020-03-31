import java.io.*;
import java.util.*;

public class WordScramble {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String[] str = scan.nextLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                String input = str[i]; 
                StringBuilder input1 = new StringBuilder(); 
                input1.append(input); 
                input1 = input1.reverse(); 
                System.out.print(input1 + " "); 
            }
            System.out.println();
        }
    }
}