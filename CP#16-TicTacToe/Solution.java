import java.io.*;
import java.util.*;

class Solution {

    char [][] tct = new char [3][3];

    public static void main (String [] args) throws IOException {
        Solution s = new Solution();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            for (int i = 0; i < 3; i++) 
                s.tct[i] = br.readLine().toCharArray();
            
            // X and O count
            int X = 0, O = 0;
            for (int j = 0; j < 3; j++) for (int k = 0; k < 3; k++) 
                if (s.tct[j][k] == 'X') X++; 
                else if (s.tct[j][k] == 'O') O++;
            
            boolean checkWin;
            if(X == O) 
                checkWin = s.checkCharXO('X');
            else if(X - 1 == O) 
                checkWin = s.checkCharXO('O');
            else checkWin = false;
    
            if(checkWin == true)
                System.out.println("yes");
            else
                System.out.println("no");
            br.readLine();
        }
    }
    
    public boolean checkCharXO(char ch) {
        if (tct[0][0] == ch && tct[0][1] == ch &&  tct[0][2] == ch) return false;
        if (tct[1][0] == ch && tct[1][1] == ch &&  tct[1][2] == ch) return false;
        if (tct[2][0] == ch && tct[2][1] == ch &&  tct[2][2] == ch) return false;
        if (tct[0][0] == ch && tct[1][0] == ch &&  tct[2][0] == ch) return false;
        if (tct[0][1] == ch && tct[1][1] == ch &&  tct[2][1] == ch) return false;
        if (tct[0][2] == ch && tct[1][2] == ch &&  tct[2][2] == ch) return false;
        if (tct[0][0] == ch && tct[1][1] == ch &&  tct[2][2] == ch) return false;
        if (tct[0][2] == ch && tct[1][1] == ch &&  tct[2][0] == ch) return false;
        return true;
    }
}
