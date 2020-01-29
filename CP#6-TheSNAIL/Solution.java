import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            double H = scan.nextInt();
            if (H == 0)
                break;
            double U = scan.nextInt();
            double D = scan.nextInt();
            double F = (U * scan.nextInt()) / 100;
            double pH = 0.0;
            int day = 0;
            
            while (pH <= H && pH >= 0.0) {
                day++;
                pH = pH + U;
                if (pH > H) {
                    break;
                }
                pH = pH - D;
                U = U-F;
            }
            
            if (pH > H) {
                System.out.println("success on day " + day);
            } else {
                System.out.println("failure on day " + day);
            }
        }
    }
}