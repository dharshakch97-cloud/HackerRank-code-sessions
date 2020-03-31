import java.io.*;
import java.util.*;

public class Freespots {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s=br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(s);
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            
            int free_spots = W * H;
            boolean[][] flag = new boolean[W][H];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                
                for (int x = Math.min(x1,x2); x <= Math.max(x1,x2); x++) 
                    for (int y = Math.min(y1,y2); y <= Math.max(y1,y2); y++) 
                        if (!flag[x - 1][y - 1]) {
                            flag[x - 1][y - 1]=true;
                            free_spots--;
                }
            }
            
            if (free_spots == 0) 
                System.out.println("There is no empty spots.");
            else if (free_spots == 1) 
                System.out.println("There is one empty spot.");
            else 
                System.out.println("There are " + free_spots + " empty spots.");
            br.readLine();
        }
    }
}