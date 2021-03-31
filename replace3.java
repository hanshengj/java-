在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
class Solution {
    public char firstUniqChar(String s) {
        if(s==null) return ' ';
        char[] arr=s.toCharArray();
        Map<Character,Boolean> map =new HashMap<>();
        for (char c:arr){
            map.put(c,!map.containsKey(c));
        }
        for (char c: arr){
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }
}

用两个栈实现队列
class CQueue {
    Stack <Integer> st1=new Stack<>();
    Stack <Integer> st2=new Stack<>();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        st1.add(value);

    }
    
    public int deleteHead() {
        if(st1.isEmpty()&&st2.isEmpty()){
            return -1;
        }
        if(st2.isEmpty()){
        while(!st1.isEmpty()){
            st2.add(st1.pop());
        }
        }
        return st2.pop();

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */