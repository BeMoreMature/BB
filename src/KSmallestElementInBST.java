import java.util.Stack;

public class KSmallestElementInBST {
    int res = 0;
    int count = 0;
//    recursive
//    public int kthSmallest(TreeNode root, int k) {
//        helper(root,k);
//        return res;
//    }
//    public void helper(TreeNode root, int k){
//        if(root == null) return;
//        helper(root.left,k);
//        count++;
//        if(count == k){
//            res = root.val;
//            return;
//        }
//        helper(root.right,k);
//    }

//    iterative
//    public int kthSmallest(TreeNode root, int k){
//        Stack<TreeNode> stack = new Stack<>();
//        while(root != null){
//            stack.push(root);
//            root = root.left;
//        }
//        while(!stack.isEmpty()){
//            TreeNode temp = stack.pop();
//            k--;
//            if(k == 0){
//                return temp.val;
//            }
//            TreeNode right = temp.right;
//            if(right != null){
//                stack.push(right);
//                right = right.left;
//            }
//        }
//        return -1;
//    }
    public int kthSmallest(TreeNode root, int k){
        int count = countNode(root.left);
        if(k == count+1) return root.val;
        else if(k < count+1){
            kthSmallest(root.left,k);
        }else{
            kthSmallest(root.right,k-count-1);
        }
        return -1;
    }
    public int countNode(TreeNode root){
        if(root == null) return 0;
        return 1+countNode(root.left)+countNode(root.right);
    }
    public static void main(String args[]){
        KSmallestElementInBST k = new KSmallestElementInBST();
        String b[] = {"3","1","4","null","2"};
        System.out.println(k.kthSmallest(SecondLargeNumberInBST.buildTree(b),3));
    }
}
