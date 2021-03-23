给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。

如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
class Solution {
    public int binaryGap(int n) {

     String str=Integer.toBinaryString(n);
      char[] temp=str.toCharArray();
       List<Integer> list=new ArrayList<>();
         int sum=0;
         for (int i=0;i<temp.length;i++){
       if(temp[i]=='1'){
         list.add(i);
           sum++;
        }
          }
                if(sum<2){
                   return 0;
                 }
          int max=1;
           for(int i=0;i<list.size()-1;i++){
          if((list.get(i+1)-list.get(i))>max){
        max=list.get(i+1)-list.get(i);
          }
        }
     return max;
    }
}