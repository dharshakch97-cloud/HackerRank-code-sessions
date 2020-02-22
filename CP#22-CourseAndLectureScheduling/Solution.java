import java.util.*;
import java.io.*;

public class Solution {

    static int N, L, C;
    static int[] t;
    static Pair[][] clss_schedule;
    
    static class Pair {
        int lectures, DI;
        Pair(int x, int y) {
            lectures = x;
            DI = y;
        }
    }

    public static Pair calc_dp(int i, int remain) {
        if(i == N) {
            return new Pair(0, disc_index(remain));
        }
        if(clss_schedule[i][remain] != null) 
            return clss_schedule[i][remain];
        
        Pair ans = new Pair(0, 0);
        Pair nxt = calc_dp(i + 1, L - t[i]);
        ans.lectures = nxt.lectures + 1;
        ans.DI = nxt.DI + disc_index(remain);
        if(remain >= t[i])    {
            nxt = calc_dp(i + 1, remain - t[i]);
            if(nxt.lectures < ans.lectures) {
                ans.lectures = nxt.lectures;
                ans.DI = nxt.DI;
            }
            else
                if(nxt.lectures == ans.lectures)
                    ans.DI = Math.min(ans.DI, nxt.DI);
        }
        return clss_schedule[i][remain] = ans;
    }
    
    public static int disc_index(int rem) {

        int di = 0;
        if(rem >= 1 && rem <= 10)
            di = -C;
        else
            if(rem > 10)
                di = (rem - 10) * (rem -10);
        return di;
    }
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);    
        StringBuilder sb = new StringBuilder();    
        int tc = 1;
        while(true) {
            N = scan.nextInt();
            if(N == 0) break;
            if (tc != 1)
                sb.append("\n");
            sb.append("Case "+ tc++).append(":\n");
            L = scan.nextInt();
            C = scan.nextInt();
            t = new int[N];
            for(int i = 0; i < N; i++) 
                t[i] = scan.nextInt();
            clss_schedule = new Pair[N][L + 1];
            Pair result = calc_dp(0, 0);
            sb.append("Minimum number of lectures: " + result.lectures).append("\n");
            sb.append("Total dissatisfaction index: " + result.DI).append("\n");
        }
        System.out.println(sb);
        scan.close();
    }
}
