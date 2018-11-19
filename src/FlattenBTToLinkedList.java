import java.util.Stack;

public class FlattenBTToLinkedList {
//    public TreeNode pre;
//    public void flatten(TreeNode root) {
//        if(root == null) return;
//        flatten(root.right);
//        flatten(root.left);
//        root.right = pre;
//        root.left = null;
//        pre = root;
//    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
//            System.out.println(temp.val);
            if(!stack.isEmpty()){
                temp.left = stack.peek();
                temp.right = null;
            }

        }

    }

    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
            System.out.println(temp.val);
        }

    }

    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
            System.out.println(temp.val);
        }

    }
    public void inOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null){
            stack.push(curr);
            curr = curr.right;
        }
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            TreeNode left = temp.left;
            while(left != null){
                stack.push(left);
                left = left.right;
            }
        }
    }
    public static void main(String args[]){
        String a[] = {"1","2","5","3","4","null","6"};
//        String a[] = {"4","2","5","1","3"};
        TreeNode root = SecondLargeNumberInBST.buildTree(a);
        FlattenBTToLinkedList f = new FlattenBTToLinkedList();
//        f.flatten(root);
//        f.preOrder(root);
        f.postOrder(root);
//            f.inOrder(root);
    }
}
