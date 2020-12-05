import java.util.Scanner;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2020-12-05
 * Time: 9:26
 */
public class zhiyinshu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int num = scanner.nextInt();
        System.out.print(num + "=");
        for (int i = 2; i <= num; i++) {
            while (num != i) {
                if (num % i == 0) {
                    System.out.print(i + "*");
                    num /= i;
                } else {
                    break;
                }
            }
        }
        System.out.print(num);
    }


}
