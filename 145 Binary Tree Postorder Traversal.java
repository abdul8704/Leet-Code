// Given the root of a binary tree, return the postorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [3,2,1]

// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [4,6,7,5,2,9,8,3,1]

// Example 3:
// Input: root = []
// Output: []

// Example 4:
// Input: root = [1]
// Output: [1]

// Constraints:
// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
 
// Follow up: Recursive solution is trivial, could you do it iteratively?


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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        traverse(root, list);

        return list;
    }

    private static void traverse(TreeNode root, List<Integer> list){
        if(root == null)
            return ;

        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> anotherStack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop(); // take  a node, 

            anotherStack.push(node);  // push it to stack, becaUSE the reverse iteration of this is post order

            if(node.left != null)
                stack.push(node.left);

            if(node.right != null)
                stack.push(node.right);
        }

        while(!anotherStack.isEmpty())
            list.add(anotherStack.pop().val);

        return list;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = stack.peek(); 

                if(temp.right != null)
                    curr = temp.right;
                else{
                    temp = stack.peek();
                    stack.pop();
                    list.add(temp.val);

                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.peek();
                        stack.pop();
                        list.add(temp.val);
                    }
                }
            }
        }


        return list;
    }
}