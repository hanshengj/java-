给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，
返回从右侧所能看到的节点值。
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List <Integer> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue <TreeNode> ss=new LinkedList<>();
        ss.offer(root);
        while(!ss.isEmpty()){
          int size= ss.size();
          for (int i=0;i<size;i++){
              TreeNode node= ss.poll();
              if(node.left!=null){
                  ss.offer(node.left);
              }
              if (node.right!=null){
                  ss.offer(node.right);
              }
              if(i==size-1){
                  res.add(node.val);
              }
          }
        }
return res;
    }
}