import java.io.*;
import java.util.*;

public class Collatz {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        int m_count = 0;
        int [] arr = new int[(int) (5 * Math.pow(10, 5) + 1)];
        for(int i=2;i<=3732423;i++) {
            int count = collatz_seq(i,0);
            if(count > m_count) {
                res = i;
                m_count = count;
            }
            else if(count == m_count) {
                res = i;
            }
            arr[i] = res;
        }
        for(int n1 = 0; n1 < n; n1++){
            int num = in.nextInt();
            if(num > 3732423){
                System.out.println(3732423);
            }else{
                System.out.println(arr[num]);
            }
        }
    }
    public static int collatz_seq(long n,int c) {
        while(n !=1) {
            if(n % 2 == 0) {
                c++;
                n = n / 2;
            }
            else {
                c++;
                n = n*3 + 1;
            }
        }
        return c; 
    }
}