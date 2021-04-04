一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

//动态规划
class Solution {
    public int numWays(int n) {
       int [] arr=new int[n+1];
       for (int i=0;i<=n;i++){
           if(i==0 |i==1){
               arr[i]=1;
           }else{
           arr[i]=(arr[i-1]+arr[i-2])%1000000007;
           }
       }
       return arr[n];
    }
}

//迭代法
class Solution {
    public int numWays(int n) {
        int a=1,b=1;
        for(int i=0;i<n;i++){
            int sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;

    }
}
