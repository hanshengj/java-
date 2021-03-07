给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足： 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。

解题思路：遍历字符串，如果是左括号，则入栈，有括号的话看他是否与栈顶
的左括号匹配，若匹配将其弹出栈，继续往后遍历字符串，当字符串遍历完且栈为空的时候，
说明匹配。

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                //说明当前遍历到的字符是左括号
                stack.push(ch);
            }else {
                //1、判断当前的栈是否是空的
                if(stack.empty()) {
                    System.out.println("右括号多");
                    return false;//代表右括号多
                }
                //2、拿到栈顶元素，看栈顶元素是否和当前的字符匹配，如果匹配当前栈顶元素出栈
                char topch = stack.peek();
                if(topch == '{' && ch == '}' || topch == '[' && ch == ']' || topch == '(' && ch == ')') {
                    stack.pop();
                }else{
                    System.out.println("左右括号不匹配");
                    return false;//代表左右括号不匹配
                }
            }
        }
        if(!stack.empty()) {
            System.out.println("左括号多");
            return false;//代表左括号多
        }
        return true;
    }
}