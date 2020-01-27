import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {

    private static class Edge implements Comparable<Edge> {
        int dest, weight;
        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
        public int compareTo(Edge e) { 
            return this.weight - e.weight; 
        }
    }
    
    public static void main (String [] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int t = 1;
        while (true) {
            int N = scan.nextInt();
            if (N == 0) 
                break;
            int[][] adj_matrix = new int[N][N];
            for (int i=0; i < N; i++) {
                for (int j=0; j<N; j++) {
                    adj_matrix[i][j] = Integer.MAX_VALUE;
                }
            }
            
            for (int i = 0; i < N; i++) {
                int C = scan.nextInt();
                for (int c = 0; c < C;c++) {
                    adj_matrix[i][scan.nextInt() - 1] = scan.nextInt();
                }
            }
            
            int src = scan.nextInt() - 1;
            int dest = scan.nextInt() - 1;
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            
            int[] p = new int[N];
            for (int n=0;n<N;n++) 
                p[n]=n;
            
            PriorityQueue<Edge> queue=new PriorityQueue<>();
            queue.offer(new Edge(src,0));
            while (!queue.isEmpty()) {
                Edge e=queue.poll();
                if (e.dest==dest) 
                    break;
                for (int i=0;i<N;i++) {
                    if (adj_matrix[e.dest][i]!=Integer.MAX_VALUE) {
                        int weight = e.weight+adj_matrix[e.dest][i];
                        if (dist[i] > weight) {
                            dist[i] = weight;
                            p[i] = e.dest;
                            queue.offer(new Edge(i, weight));
                        }
                    }
                }
            }

            StringBuilder s = new StringBuilder();
            int c = dest;
            do {
                StringBuilder tmp = new StringBuilder();
                tmp.append(' ');
                tmp.append(c + 1);
                tmp.append(s.toString());
                s = tmp;
                c = p[c];
            } while (c != p[c]);
            
            System.out.printf("Case %d: Path = %d%s; %d second delay\n", t++, src+1, s.toString(), dist[dest]);
        }
    }

}
