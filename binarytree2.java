输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
只能调整树中结点指针的指向。

public class Solution {
    public TreeNode prev = null;//上一次打印的节点
    public void ConvertChild(TreeNode pCur) {
    //ConvertChild方法进行中序遍历，将树变为链表
        if(pCur == null) return;
        ConvertChild(pCur.left);
        pCur.left = prev;
        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        ConvertChild(pRootOfTree);
        //找头结点
        TreeNode head = pRootOfTree;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }
}