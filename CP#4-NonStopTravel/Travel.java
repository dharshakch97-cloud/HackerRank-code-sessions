import java.io.*;
import java.util.*;

public class Travel {

	static DirectedEdge de;
	static EdgeWeightedDigraph ewd;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = 0;
        for (int i = 0; i < n; i++) {
        	c++;
        	System.out.println(c);
            int te = scan.nextInt();
            if (te == 0) continue;
            for (int j = 0; j < te; j++) {
                de = new DirectedEdge(c, scan.nextInt(), scan.nextInt());
                ewd.addEdge(de);
            }
        }
        System.out.println(ewd.toString());
    }
}