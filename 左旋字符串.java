字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
该函数将返回左旋转两位得到的结果"cdefgab"。



class Solution {
    public String reverseLeftWords(String s, int n) {

        // //方法一
        // //先将字符串根据位置分割成前后两部分
        // String s1=s.substring(0,n);
        // String s2=s.substring(n);
        // //将后半部分与前半部分进行拼接
        //  String ret=s2+s1;
        //  return ret;

        //方法二
        //StringBuilder根据for循环进行拼接
        StringBuilder ret=new StringBuilder();
        for (int i=n;i<s.length();i++){
            ret.append(s.charAt(i));
        }
        for (int i=0;i<n;i++){
            ret.append(s.charAt(i));
        }
        return ret.toString();

    }
}