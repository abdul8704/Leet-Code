// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
// The path sum of a path is the sum of the node's values in the path.
// Given the root of a binary tree, return the maximum path sum of any non-empty path.

// Example 1:
// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

// Example 2:
// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 
// Constraints:
// The number of nodes in the tree is in the range [1, 3 * 104].
// -1000 <= Node.val <= 1000

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
    private static int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if(root == null)
            return 0;

        getMax(root);
        return max;
    }
    private static int getMax(TreeNode node){
        int local = Integer.MIN_VALUE;

        if(node == null)
            return 0;
        
        int l_path = getMax(node.left);
        int r_path = getMax(node.right);

        local = Math.max(local, l_path + node.val);   // assuming there's more tree, up, do we dont take  this root as turning point
        local = Math.max(local, r_path + node.val);
        local = Math.max(local, node.val);

        max = Math.max(max, l_path + r_path + node.val);  // assuming this is the final tree, and taking this root as turning point
        max = Math.max(local, max);                      // max of both

        return local;
    }
}