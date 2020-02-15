import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        
        for (int i = 0; i < n; i++) {
            String country = new StringTokenizer(br.readLine()).nextToken();
            if (!h.containsKey(country))
                h.put(country, 1);
            else 
                h.put(country, h.get(country) + 1);
        }
        
        Set<String> c = h.keySet();
        String[] countriesArray = c.toArray(new String[c.size()]);
        Arrays.sort(countriesArray);
        // System.out.println(Arrays.toString(countriesArray));
        
        for (int i = 0; i < countriesArray.length; i++) {
            System.out.println(countriesArray[i] + " " + h.get(countriesArray[i]));
        }
    }
}
