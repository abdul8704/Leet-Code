// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Example 1:
// Input: root = [1,2,2,3,4,4,3]
// Output: true

// Example 2:
// Input: root = [1,2,2,null,3,null,3]
// Output: false
 
// Constraints:
// The number of nodes in the tree is in the range [1, 1000].
// -100 <= Node.val <= 100
 
// Follow up: Could you solve it both recursively and iteratively?

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
    public boolean isSymmetric(TreeNode root) {
        boolean b1 = isSame(root.left, root.right);

        return b1;
    }
    private static boolean isSame(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;

        if(left == null || right == null || left.val != right.val)
            return false;

        boolean b1 = isSame(left.left, right.right);
        boolean b2 = isSame(left.right, right.left);

        return b1 && b2;
    }

}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> aQ = new LinkedList<>();

            while(!q.isEmpty()){
                TreeNode node = q.poll();

                if(node == null)
                    level.add(-101);
                else
                    level.add(node.val);
                
                if(node != null){
                    aQ.offer(node.left);
                    aQ.offer(node.right);
                }
                
            }

            if(!palin(level))
                return false;

            q = aQ;
        }

        return true;

    }
    private static boolean palin(List<Integer> list){
        int l = 0, r = list.size() - 1;

        while (l < r){
            if(list.get(l++) != list.get(r--))
                return false;
        }

        return true;
    }
}