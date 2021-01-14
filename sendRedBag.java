import java.util.Random;
import java.util.Scanner;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-14
 * Time: 12:51
 */

//变量说明
//total 红包的总金额
//count 红包的个数
//min 最小的红包值
//max 最大的红包值
//bound 红包的范围
//safe 随机产生的红包金额
//money 最终的红包大小
public class sendRedBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("请输入红包总金额");
        double total = sc.nextDouble();
        System.out.println("请输入红包个数");
        int count = sc.nextInt();
        double min = 0.01;
        
        for (int i = 1; i < count; i++) {
//            本次可分配的最大红包金额=可分配的金额-（红包个数-已经发出的个数）*红包的最小金额；
            double max = total - (count - i) * min;
            double bound = max - min;
            double safe = (double) random.nextInt((int) (bound * 100)) / 100;
            double money = safe + min;//红包不可能为0，加最小值是防止safe为0；
            total -= money;
            System.out.println("第" + i + "个红包为：" + String.format("%.2f", money) + " 元");
        }
        System.out.println("第" + count + "个红包为：" + String.format("%.2f", total) + " 元");
        sc.close();
    }
}
