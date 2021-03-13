前序遍历：用一个临时变量cur遍历树，若cur不为空，打印并将cur入栈，若cur为空则弹出栈顶元素，
cur等于栈顶元素的右子树，若cur还为空则继续弹出栈顶元素并将其右子树赋值给cur，然后cur继续判断是否为空，
不为空则入栈，一直这样做，直到栈为空

中序是出栈的时候打印，前序是入栈的时候打印，其他都一样；

后续遍历：用一个临时变量cur遍历树，若cur不为空，打印并将cur入栈，若cur为空，则获得栈顶元素（==不是弹出==），
若栈顶元素的右为空，且已经被打印过了，就弹出栈顶的元素，若不为空且没被打印过，则将栈顶元素的右子树赋值给cur，继续循环；


 // 前序遍历
    void preOrderTraversalNor(BTNode root) {
        if(root == null) return;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            BTNode top = stack.pop();
            cur = top.right;
        }
        System.out.println();
    }
    
    // 中序遍历
    void inOrderTraversalNor(BTNode root) {
        if(root == null) return;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
        System.out.println();
    }


    // 后序遍历
    void postOrderTraversalNor(BTNode root) {
        if(root == null) return;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        BTNode prev = null;//用于标记是否被打印过
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.peek();
            if(top.right == null || top.right == prev) {
                stack.pop();
                System.out.print(top.val+" ");
                prev = top;
                //prev始终存的都是最近一次被打印的元素
            }else {
                cur = top.right;
            }
        }
        System.out.println();
    }
