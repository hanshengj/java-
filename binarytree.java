给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
方法一
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}


方法二


class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
         if(root == null) return list ;
            list.add(root.val);
            //System.out.print(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        
        return list;
    }
}

给定一个二叉树的根节点 root ，返回它的 中序 遍历


class Solution { 
    List <Integer> list=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
    if (root==null) return list;
    inorderTraversal(root.left);
    list.add(root.val);
    inorderTraversal(root.right);
    return list;
    }
}

给定一个二叉树，返回它的 后序 遍历。


class Solution {
    List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
    if (root==null) return list;
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    list.add(root.val);
    return list;
    }
}
```
