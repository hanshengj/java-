import java.util.*;

public class Bonus {
    public int getMost(int[][] board) {
        // write code here
        return most(board,0,0);
    }
    public static int most(int [][] b ,int x,int y){
        if(x>5 || y>5){
            return 0;
        }
        if( x== 5&& y==5){
            return b[x][y];
        }
        
        int sum = b[x][y];
        int right=0,down=0;
        right += most(b,x+1,y);
        down += most(b,x ,y+1);
       return  sum +=Math.max(right,down);
    }
}