// Given the root of a binary tree, return the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
// The length of a path between two nodes is represented by the number of edges between them.

// Example 1
// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

// Example 2:
// Input: root = [1,2]
// Output: 1
 
// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -100 <= Node.val <= 100

import java.util.HashMap;

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
    private static HashMap<TreeNode, Integer> map;

    public int diameterOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        return maxi(root, 0);
    }
    private static int height(TreeNode node){
        if(node == null)
            return 0;
        
        if(map.containsKey(node))
            return map.get(node);
        
        int lHeight = height(node.left) + 1;
        int rHeight = height(node.right) + 1;

        map.put(node, Math.max(lHeight, rHeight));
        return Math.max(lHeight, rHeight);
    }
    private static int maxi(TreeNode node, int max){
        if(node == null)
            return max;
        
        int left = height(node.left);
        int right = height(node.right);

        max = Math.max(max, left + right);
        max = Math.max(max, maxi(node.left, max));
        max = Math.max(max, maxi(node.right, max));

        return max;
    }
}

class Solution2 {
    private static int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    private static int helper(TreeNode node){
        if(node == null)
            return 0;
        
        int l_tall = helper(node.left );
        int r_tall = helper(node.right);

        max = Math.max(max, l_tall + r_tall);

        return Math.max(l_tall, r_tall) + 1;
    }
}