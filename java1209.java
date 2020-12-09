/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2020-12-09
 * Time: 23:02
 */
public class java1209 {
    public static void main(String[] args) {
        System.out.println();
        hannota(2,'A','B','C');
        System.out.println();
        hannota(3,'A','B','C');
    }
    public static  void move (char pos1,char pos2){
        System.out.println(pos1 + "->" + pos2 + " ");
    }
    public static void hannota( int n,char pos1,char pos2,char pos3){
        if (n==1){
            move(pos1,pos3);
            return;
        } else {
            hannota(n-1,pos1,pos3,pos2);
            move (pos2,pos3);
            hannota(n-1,pos2,pos1,pos3);
        }

    }
}
