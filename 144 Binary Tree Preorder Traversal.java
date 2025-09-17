// Given the root of a binary tree, return the preorder traversal of its nodes' values.
// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [1,2,4,5,6,7,3,8,9]

// Example 3:
// Input: root = []
// Output: []

// Example 4:
// Input: root = [1]
// Output: [1]

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
 
// Follow up: Recursive solution is trivial, could you do it iteratively?

import java.util.*;

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

class Solution { //iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root; // start from root

        while(curr != null || !stack.isEmpty()){
            while(curr != null){                        // visit a node and go to it's leftmost node 
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();                    // when leftmost node is reached, pop from stack and go to right child
            curr = curr.right;
        }

        return list;
    }
}

class Solution2 { // recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverse(root, list);

        return list;
    }
    private static void traverse(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        
        list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);

    }
}