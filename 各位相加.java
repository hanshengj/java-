给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

class Solution {
    public int addDigits(int num) {
        //递归
        // //num小于10，直接返回
        // if(num<10){
        //     return num;
        // }
        // //求各个为的和
        // int sum=0;
        // while(num!=0){
            
        //     sum+=num%10;
        //     num/=10;
        // }
        // return addDigits(sum);

        //迭代
       
    while (num >= 10) {
        int next = 0;
        while (num != 0) {
            next = next + num % 10;
            num /= 10;
        }
        num = next;
    }
    return num;
    }
}