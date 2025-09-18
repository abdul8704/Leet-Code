// Given a binary tree, determine if it is height-balanced.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: true

// Example 2:
// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false

// Example 3:
// Input: root = []
// Output: true
 
// Constraints:
// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        return h(root) != -1? true: false;
    }
    private static int h(TreeNode root){
        if(root == null)
            return 0;
        
        int l = h(root.left);

        if(l == -1)
            return -1;

        int r = h(root.right);

        if(r == -1)
            return -1;

        l++; r++;

        return Math.abs(l-r) <= 1 ? Math.max(l, r): -1;
    }
}