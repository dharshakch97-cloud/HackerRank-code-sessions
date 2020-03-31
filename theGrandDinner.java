import java.io.*;
import java.util.*;

class theGrandDinner {

    static class table implements Comparable<table>{
        int num;
        int cap;
        public table(int n, int c){
            this.num = n;
            this.cap = c;
        }
        public int compareTo(table o) {
            return o.cap - this.cap;
        }
    }

    public static void main(String args[]) throws Exception{
        Scanner scan = new Scanner(System.in);
        while (true) {
            int M = scan.nextInt();
            int N = scan.nextInt();
            if(M == 0 && N == 0) break;
            int[] teams = new int[M];
            table[] tables = new table[N];
            int largeTeam = Integer.MIN_VALUE;
            for(int i = 0; i < M; i++){
                teams[i] = scan.nextInt();
                largeTeam = Math.max(largeTeam, teams[i]);
            }
            
            boolean possible = true;
            if(largeTeam > N) possible = false;
            for(int i = 0; i < N; i++) {
                tables[i] = new table(i + 1, scan.nextInt());
            }

            Arrays.sort(tables);
            int[][] ans = new int[M][N];
            for(int i = 0; i < M && possible; i++) {
                for(int j = 0; j < teams[i]; j++) {
                   ans[i][j] = tables[j].num;
                    if(--tables[j].cap < 0)
                        possible = false;
                }
            }

            if(possible == false) System.out.println(0);
            else {
                System.out.println(1);
                for(int i = 0; i < M; i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < teams[i]; j++){
                        sb.append(ans[i][j]).append(" ");
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }
}
