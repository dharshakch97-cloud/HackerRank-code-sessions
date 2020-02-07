import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static class Node { 
        Node[] next = new Node[26]; 
        int count; 
    }
    
    public static class TrieST {
        
        Node root = new Node();
        public void put(char[] s) {
            for(int i = 0; i < s.length; ++i)
                put(s, i);
        }
        
        public void put(char[] s, int index) {
            Node cur = root;
            root.count++;
            while(index < s.length) {
                Node nxt = cur.next[s[index] - 'A'];
                if(nxt == null)
                    nxt = cur.next[s[index] - 'A'] = new Node();
                index++;
                nxt.count++;
                cur = nxt;
            }
        }
        
        public Pair longestString() { 
            return longestString(root, 0); 
        }
        
        public Pair longestString(Node cur, int depth) {
            if(cur.count < 2)
                return new Pair(0, 0, -1, null);
            Pair ret = new Pair(depth, cur.count, -1, null);
            for(int i = 0; i < 26; ++i) {
                Node nxt = cur.next[i];
                if(nxt != null) {
                    Pair p = longestString(nxt, depth + 1);
                    if(p.len > ret.len)
                        ret = new Pair(p.len, p.count, i, p);
                }
            }
            return ret;
        }
    }

    public static class Pair { 
        int len, count, c; Pair nxt; 
        Pair(int a, int b, int d, Pair e) { 
            len = a;
            count = b;
            c = d;
            nxt = e; 
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int a = 0;
        int tc = Integer.parseInt(scan.nextLine());
        while(tc-- > 0)
        {
            while (scan.hasNextLine()) {
                a = 1;
                String str = scan.nextLine();
                char[] s = str.toCharArray();
                TrieST t = new TrieST();
                t.put(s);
                Pair seq = t.longestString();
                if(seq.len == 0)
                    System.out.println("No repetitions found!");
                else {
                    StringBuilder sb = new StringBuilder();
                    while(seq.nxt != null) {
                        sb.append((char)(seq.c + 'A'));
                        seq = seq.nxt;
                    }
                System.out.println(sb + " " + seq.count);
                } 
            }
            if (a == 0) {
                System.out.println("No repetitions found!");
            }
        } 
    }
}