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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(q.val < p.val){
            TreeNode t = q;
            q = p;
            p = t;
        }
        if(root.val < p.val){
            if(root.right == null){
            return root;
            }
            root = root.right;
            return lowestCommonAncestor( root,  p,  q);
        }else if(root.val > q.val){
            if(root.left == null){
            return root;
            }
            root = root.left;
            return lowestCommonAncestor( root,  p,  q);
        }else{return root;}
    }

}
