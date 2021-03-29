请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

class Solution {
    public String replaceSpace(String s) {
        //方法1
        //return s.replace(" ","%20");


        //方法2
        StringBuilder ret=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char a= s.charAt(i);
            if(a==' '){
                ret.append("%20");
            }else{
                ret.append(a);
            }
        }
        return ret.toString();
    }
}