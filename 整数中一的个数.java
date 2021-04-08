请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String s=Integer.toBinaryString(n);
        char []ret=s.toCharArray();
        int sum=0;
        for(char c:ret){
            if(c=='1'){
                sum++;
            }
        }
        return sum;
        
    }
}