/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    static List<Integer> al = new ArrayList<>();
    static int i=0;
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    public int next() {
        return al.get(i++);
    }
    
    public boolean hasNext() {
        return i < al.size();
    }
    public void inorder(TreeNode root)
    {
        if(root == null) return ;
        inorder(root.left);
        al.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */