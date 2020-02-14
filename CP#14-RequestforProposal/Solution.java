import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int t = 1;
        while ((str = br.readLine()) != null && !str.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            for (int i = 0; i < n; i++) 
                br.readLine();
            
            String f_name = "";
            double f_price = 0.0;
            int freq_met = 0;
            
            for (int j = 0; j < p; j++) {
                String name = br.readLine();
                st = new StringTokenizer(br.readLine());
                double price = Double.parseDouble(st.nextToken());
                int req_met = Integer.parseInt(st.nextToken());
                for (int k = 0; k < req_met; k++)
                    br.readLine();
                
                if (freq_met < req_met || (freq_met == req_met && f_price > price)) {                    
                    f_name = name;
                    f_price = price;
                    freq_met = req_met;
                }
            }
            if (t > 1) 
                System.out.println();
            System.out.println("RFP #" + (t++) + "\n" + f_name);
        }
    }
}
