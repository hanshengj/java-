
<font face= 楷体>用队列实现（先进后出）
1、如果根不为空，那么根入队
2、如果队列不为空，则将队头元素保存在临时变量cur里，并打印，
3、判断cur的左右子树是否为空，不为空则入队
4、如果队列为空，则表示遍历结束。

```java
 // 层序遍历
    void levelOrderTraversal(BTNode root) {
        if(root == null) return;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        //队列不为空，一直循环步骤2、3，知道列表为空
        while (!queue.isEmpty()) {
            BTNode cur = queue.poll();
            System.out.print(cur.val +" ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
```

[力扣真题](https://leetcode-cn.com/problems/binary-tree-level-order-traversal)

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    //List<List<Integer>> ret相当于“二维队列”
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        //level存放每一层数据
            List<Integer> level = new ArrayList<Integer>();
            //currentLevelSize代表每一层有多少个元素
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                //左右节点入队
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //将每一层元素放到“二位队列中”
            ret.add(level);
        }
        
        return ret;
    }
}
```