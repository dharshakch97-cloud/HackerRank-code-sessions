import java.io.*;
import java.util.*;
import java.text.*;

public class StationBalance {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        DecimalFormat f = new DecimalFormat("0.00000");
        while(br.ready()) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int[] arr = new int[c<<1];
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            double imbalance = 0;
            for (int i = 0; i < s; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum+=arr[i];
            }
            int[] arr2 = arr.clone();
            Arrays.sort(arr2);
            sb.append("Set #"+(tc++) +"\n");
            double a = sum*1.0/c;
            for (int i = 0; i < c; i++) {
                int x = arr2[i],y = arr2[2*c-1-i];
                sb.append(" "+i+":");
                if(x==0 || y==0) {
                    if(x!=0)
                        sb.append(" "+x);
                    if(y!=0)
                        sb.append(" "+y);
                }
                else
                    sb.append(" "+x+" "+y);
                imbalance += Math.abs((x+y)-a);    
                sb.append("\n");            
            }
            sb.append("IMBALANCE = "+f.format(imbalance)+"\n\n");
        }
        System.out.println(sb.toString());
    }
}
