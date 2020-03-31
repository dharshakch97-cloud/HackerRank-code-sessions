import java.io.*;
import java.util.*;

public class theDecadaryWatch {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            // String str = br.readLine();
            // System.out.println(str);
            String[] str = s.split("");
            int hh = Integer.parseInt(str[0] + str[1]);            
            int mm = Integer.parseInt(str[2] + str[3]);
            int ss = Integer.parseInt(str[4] + str[5]);
            int cc = Integer.parseInt(str[6] + str[7]);
            int day_24 = (((((hh * 60) + mm) * 60) + ss) * 100) + cc;
            long deci_10 = 10000000;
            long sec = 8640000;
            long result = (day_24 * deci_10) / sec;
            // System.out.println(result);
            
            System.out.println(String.format("%07d", result));           
        }
    }
}