从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
A 不能视为 14。


class Solution {
    public boolean isStraight(int[] nums) {
        // Set <Integer> ret=new HashSet<>();
        // int max=0,min=14;
        // for (int i=0;i<nums.length;i++){
        //     //r如果为0，继续下一次循环
        //     if(nums[i]==0)
        //     {
        //         continue;
        //     }else{
        //         //如果有重复值，直接返回false
        //         if(ret.contains(nums[i])){
        //             return false;
        //         }
        //         //否则将其加入set里，并求出最大与最小值
        //         ret.add(nums[i]);
        //         max=Math.max(max,nums[i]);
        //         min=Math.min(min,nums[i]);
        //     }
        // }
        // return max-min<5;

        int sum =0;
       Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                sum++;
            }else{
                if(nums[i]==nums[i+1]) return false;
            }
        }
        return nums[nums.length-1]-nums[sum]<5;

    }
}