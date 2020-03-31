import java.io.*;
import java.util.*;

public class Averagespeed {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        double speed = 0, distance = 0;
        int fh = 0, fm = 0, fs = 0;
        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            StringTokenizer st1 = new StringTokenizer(st.nextToken(),":");
            
            int hh = Integer.parseInt(st1.nextToken());
            int mm = Integer.parseInt(st1.nextToken());
            int ss = Integer.parseInt(st1.nextToken());
            
            distance += speed * ((hh - fh) * 3600 + (mm - fm) * 60 + (ss - fs));
            if (st.hasMoreTokens()) {
                speed = Integer.parseInt(st.nextToken()) / 3600.0;
            } else {
                System.out.printf("%s %.2f km\n", str, distance);
            }
            fh = hh;
            fm = mm;
            fs = ss;
        }        
    }
}