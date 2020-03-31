import java.util.*;

public class MapMaker {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        StringTokenizer st = tokenizeNextLine();

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        Map<String, Sub_array> map = new HashMap<String, Sub_array>();

        for (int i = 0; i < n; i++) {
            st = tokenizeNextLine();
            String arrayName = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int bounds[] = new int[2 * d];
            for (int j = 0; j < 2 * d; j++) {
                bounds[j] = Integer.parseInt(st.nextToken());
            }

            Sub_array array = new Sub_array(b, size, d, bounds);
            map.put(arrayName, array);
        }

        for (int i = 0; i < r; i++) {
            st = tokenizeNextLine();
            String arrayName = st.nextToken();
            ArrayList<Integer> arguments = new ArrayList<Integer>();
            while (st.hasMoreTokens()) {
                arguments.add(Integer.parseInt(st.nextToken()));
            }

            Sub_array array = map.get(arrayName);
            if (array != null) {
                int pos = array.calc_phyAddr(arguments);
                System.out.println(arrayName + arguments + " = " + pos);
            }
        }
    }

    private static StringTokenizer tokenizeNextLine() {
        return new StringTokenizer(scn.nextLine());
    }
}

class Sub_array {

    int c[];

    public Sub_array(int b, int size, int d, int[] bounds) {
        c = new int[d + 1];
        c[d] = size;

        for (int i = d - 1; i > 0; i--) {
            c[i] = c[i + 1] * (bounds[2 * i + 1] - bounds[2 * i] + 1);
        }

        c[0] = b;
        for (int i = 1; i <= d; i++) {
            c[0] -= c[i] * bounds[2 * i - 2];
        }
    }

    public int calc_phyAddr(ArrayList<Integer> arguments) {
        int pos = c[0];
        for (int i = 0; i < arguments.size(); i++) {
            pos += c[i + 1] * arguments.get(i);
        }
        return pos;
    }

}
