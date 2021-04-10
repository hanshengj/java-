
颠倒给定的 32 位无符号整数的二进制位。
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret=0;
        for (int i=0 ;i<32 ;i++){
            ret=(ret<<1) + (n>>i & 1);
        }
        return ret;
        
    }
}