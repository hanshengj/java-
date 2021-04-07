写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 
四则运算符号

class Solution {
    public int add(int a, int b) {
        int sum=a^b;//无进位和
        int carry=(a&b)<<1;//有进位和，右移一位
        // 当进位为 0 时跳出
        while(b!=0){
            a=sum;
            b=carry;
            sum=a^b;
            carry=(a&b)<<1;
        }
        return a;
    }
}