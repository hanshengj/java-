import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2020-12-06
 * Time: 19:11
 */
//求一个数列中只出现一次的数
//public class java1206 {
//    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 2, 4, 5, 5, 6};
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            count = 0;
//            for (int j = 0; j < arr.length; j++) {
//                if (arr[i] == arr[j]) {
//                    count++;
//                }
//            }
//            if (count == 1) {
//                System.out.println(arr[i]);
//            }
//        }
//    }
//}


//    //斐波那契数列非递归实现
//public class java1206 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        System.out.println(fib(num));
//    }
//
//    public static int fib(int n) {
//        int last1 = 1;
//        int last2 = 1;
//        int cur = 0;
//        for (int i = 3; i <= n; i++) {
//            cur = last1 + last2;
//            last2 = last1;
//            last1 = cur;
//        }
//        return cur;
//    }
//}

//求1！+2！+3！+4！+........+n!的和
//
//public class java1206 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            int temp = 1;
//            for (int j = 1; j <= i; j++) {
//                temp *= j;
//            }
//            sum += temp;
//        }
//        System.out.println(sum);
//    }
//}

//求 N 的阶乘
//public class java1206 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int sum = 1;
//        for (int i = 1; i <= n; i++) {
//            sum *= i;
//        }
//        System.out.println(sum);
//    }
//}

//调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
//public class java1206 {
//    public static void main(String[] args) {
//        int[] arr = {1, 3, 4, 2, 7, 5, 8, 6, 6, 4, 9};
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] % 2 != 0) {
//                    int temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//            System.out.print(arr[i]);
//        }
//    }
//}


//创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
//​ 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
//public class java1206 {
//    public static void main(String[] args) {
//
//        System.out.println(max2(1, 5));
//        System.out.println(max3(1, 9, 2));
//    }
//
//    public static int max2(int x1, int x2) {
//        return x1 > x2 ? x1 : x2;
//    }
//
//    public static int max3(int x1, int x2, int x3) {
//        int a = max2(x1, x2);
//        int b = max2(x2, x3);
//        int c = max2(a, b);
//        return c;
//    }
//}

//在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，还可以求两个小数的最大值，以及两个小数和一个整数的大小关系

//public class java1206 {
//    public static void main(String[] args) {
//        System.out.println(add(1, 2));
//        System.out.println(add(1.5, 2.0,2.3));
//        //max2(1.1, 2.2, 3);
//    }
//
//    public static int add(int x1, int x2) {
//        return x1 + x2;
//    }
//
//    public static double add(double x1, double x2, double x3) {
//        return x1 + x2 + x3;
//    }
//}


//在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
//public class java1206 {
//    public static void main(String[] args) {

//    public static void max2(double x1, double x2, int x3) {
//        double sum = x1 + x2 + x3;
//        double max, middle, min;
//        max = x1 > x2 ? x1 : x2;
//        max = max > x3 ? max : x3;
//        min = x1 < x2 ? x1 : x2;
//        min = min < x3 ? min : x3;
//        middle = sum - min - max;
//        System.out.println(max + ">" + middle + ">" + min);
//    }
//}

//递归求斐波那契数列的第 N 项
// import java.util.Scanner;
//public class java1206 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        System.out.println(fib(num));
//    }
//
//    public static int fib(int n) {
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//        return fib(n - 1) + fib(n - 2);
//    }
//}

//写一个递归方法，输入一个非负整数，返回组成它的数字之和
//public class java1206 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int sum = scanner.nextInt();
//        System.out.println(sums(sum));
//    }
//
//    public static int sums(int n) {
//        if (n / 10 == 0) {
//            return n % 10;
//        }
//        return n % 10 + sums(n / 10);
//    }
//}


//按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
//public class java1206 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        print1(num);
//    }
//    打印一个整数
//    public static void print1(int n) {
////        if (n < 10) {
////            System.out.println(n % 10);
////        }
////        print1(n / 10);
//
//        if (n > 9) {
//            print1(n/10);
//        }
//        System.out.println(n%10);
//    }
//    }

//递归求 1 + 2 + 3 + ... + 10
//public class java1206 {
//    public static void main(String[] args) {
//        System.out.println(add(5));
//    }
//    public static int add( int n){
//        if ( n==1){
//            return 1;
//        }
//        return n + add (n-1);
//    }
//    }

//递归求 N 的阶乘
//public class java1206 {
//   public static void main(String[] args) {
//       System.out.println(fac(4));
//   }
//   public static int fac ( int n){
//       if ( n==1){
//           return 1;
//       }
//       return n* fac(n-1);
//   }
//   }