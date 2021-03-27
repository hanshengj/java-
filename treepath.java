给定一个二叉树，返回所有从根节点到叶子节点的路径。

class Solution {
    List<String> paths = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        findPaths(root, "");
        return paths;
    }

    public void findPaths(TreeNode root, String path) {
        // 遇到空树返回
        if (root == null) {
            return;
        }
        // 否则节点加入路径
        path += String.valueOf(root.val);
        // 如果是叶子节点，路径已完整
        if (root.left == null && root.right == null) {
            paths.add(path);
        } else {    // 否则还没完整，需要加上"->"，继续递归其左右子树构建路径
            path += "->";
            findPaths(root.left, path);
            findPaths(root.right, path);
        }
    }
}