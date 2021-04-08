输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
如果有多对数字的和等于s，则输出任意一对即可。

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int[]ret=new int[2];
        // for (int i=0;i<nums.length;i++){
        //     for(int j=i;j<nums.length;j++){
        //         if((nums[i] +nums[j])==target){
        //         ret[0]=nums[i];
        //         ret[1]=nums[j];
        //         break;
        //         }
        //     }
        //     if(ret[0]!=0 && ret[1]!=0)
        //     break;
        // }
        // return ret;

         int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];


    }
}