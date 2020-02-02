import java.util.*;
import java.io.*;
class Solution {

	static Tree tree;
	static boolean consistent;
	 private static class Tree {
        int node = 0;
        boolean isCons = false;
        Tree[] next = new Tree[10];

        public void setNext(int index, Tree t) {
            next[index] = t;
        }

        public Tree getTree(int index) {
            return next[index];
        }
    }

	public static void main(String[] args) throws IOException {
		Solution s = new Solution();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(reader.readLine());
            tree = new Tree();
            consistent = true;
            for (int j = 0; j < n; ++j) {
                String phone = reader.readLine();
                if (consistent)
                    s.build_tree(phone);
            }
            if (consistent)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
	}

	public void build_tree(String number) {
        Tree tr = tree;
        for (int i = 0; i < number.length(); i++) {
            int ch = Integer.parseInt(number.substring(i, i + 1));
            Tree aux = tr.next[ch];
            if (aux == null) {
                aux = new Tree();
                aux.node = 1;
                if (i == number.length() - 1)
                    aux.isCons = true;
                tr.setNext(ch, aux);
                tr = aux;
            } else {
                if (aux.isCons) {
                    consistent = false;
                    break;
                }
                if (i == number.length() - 1) {
                    consistent = false;
                    break;
                }
                tr = aux;
            }
        }
	}
}