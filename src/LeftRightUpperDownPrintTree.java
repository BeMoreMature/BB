import java.util.LinkedList;
import java.util.Queue;

public class LeftRightUpperDownPrintTree {
    public void print(TreeNode root){
        Queue<TreeNode> q = new LinkedList();
        TreeNode curr = root;
        while(curr != null){
            q.offer(curr);
            curr = curr.left;
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ;i < size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null) q.offer(temp.left);
                TreeNode right = temp.right;
                while(right != null){
                    TreeNode rLeft = right.left;
                    if(rLeft != null){
                        q.offer(rLeft);
                        rLeft = rLeft.left;
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        String a[] = {"3", "2", "6", "1", "4", "5", "7"};
        TreeNode root = SecondLargeNumberInBST.buildTree(a);
        LeftRightUpperDownPrintTree l = new LeftRightUpperDownPrintTree();
        l.print(root);
    }
}
