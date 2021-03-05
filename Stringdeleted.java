import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stringdeleted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        List<Character> list1 = deleted(s1, s2);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i));
        }
    }

    public static List<Character> deleted(String s1, String s2) {
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (!s2.contains(ch + "")) {
                ret.add(ch);
            }
        }
        return ret;

    }

}
