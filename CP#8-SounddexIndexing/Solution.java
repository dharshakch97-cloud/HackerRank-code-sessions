import java.util.Scanner;
class Solution {

    private static String getCode(char c) {
        switch(c) {
            case 'B': case 'F': case 'P': case 'V':
              return "1";
            case 'C': case 'G': case 'J': case 'K':
            case 'Q': case 'S': case 'X': case 'Z':
              return "2";
            case 'D': case 'T':
              return "3";
            case 'L':
              return "4";
            case 'M': case 'N':
              return "5";
            case 'R':
              return "6";
            default:
              return "";
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String word = scan.nextLine().toUpperCase();
            String code, prev, soundex;
            code = word.charAt(0) + "";
            prev = getCode(word.charAt(0));
            for(int i = 1;i < word.length();i++) {
                String current = getCode(word.charAt(i));
                if(current.length() > 0 && !current.equals(prev))
                    code = code + current;
                prev = current;
            }
            soundex = (code + "0000").substring(0, 4);
            System.out.println(word + ";" + soundex);
        }
    }
}
