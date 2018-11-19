import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SecondLargeNumberInBST {
    public int findSecondMaximumValue(TreeNode root, int res[]) {
        if(root == null) return 0;
        findSecondMaximumValue(root.right,res);
        if(root.val >= res[0]){
            res[0] = root.val;
        }else if(root.val > res[1]){
            res[1] = root.val;
        }
        findSecondMaximumValue(root.left,res);
        return res[1] == Integer.MIN_VALUE?-1:res[1];
    }

    public static TreeNode buildTree(String [] a){
        if(a == null) return null;
        TreeNode root = new TreeNode(Integer.parseInt(a[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 1;
        while(index < a.length){
            TreeNode temp = q.poll();
            if(!a[index].equals("null")){
                temp.left = new TreeNode(Integer.parseInt(a[index]));
                q.offer(temp.left);
            }
            index++;
            if(index < a.length && !a[index].equals("null")){
                temp.right = new TreeNode(Integer.parseInt(a[index]));
                q.offer(temp.right);
            }
            index++;
        }
        return root;
    }
    public static void main(String args[]){
        String a[] = {"5","3","6","2","4","null","null","1"};
        TreeNode root = buildTree(a);
        SecondLargeNumberInBST s = new SecondLargeNumberInBST();
        int res[] = new int[2];
        res[0] = Integer.MIN_VALUE;
        res[1] = Integer.MIN_VALUE;
        System.out.println(s.findSecondMaximumValue(root,res));
    }

}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}