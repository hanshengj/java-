给定一个二叉树，检查它是否是镜像对称的。如下图就是一颗对称二叉树。

思路：判断树的左右子树是否对称，在判断左子树的左子树是否与右子树的右子树对称，判断右子树的左子树是否与左子树的右子树对称，
若都满足则该树是对称的，否则不对称

class Solution {
public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
         if(leftTree == null && rightTree != null || leftTree != null && rightTree == null ) {
             return false;
         }
         if(leftTree == null && rightTree == null) {
             return true;
         }
         if(leftTree.val != rightTree.val) return false;

         return isSymmetricChild(leftTree.left,rightTree.right) && 
         isSymmetricChild(leftTree.right,rightTree.left) ;
     }


    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }
}