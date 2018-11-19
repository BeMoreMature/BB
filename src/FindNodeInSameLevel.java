import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindNodeInSameLevel {
    public List<Integer> findSiblings(TreeNode root, TreeNode node){
        if(root == null || node == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size; i++){
                TreeNode temp = q.poll();
                level.add(temp.val);
                if(level.contains(node.val) && i == size - 1){
                    return level;
                }
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
        }
        return null;
    }
    public static void main(String args[]){
        String a[] = {"1","2","5","3","4","null","6"};
        TreeNode root = SecondLargeNumberInBST.buildTree(a);
        FindNodeInSameLevel f = new FindNodeInSameLevel();
        List<Integer> res = f.findSiblings(root, new TreeNode(6));
        for(Integer node : res){
            System.out.println(node);
        }
    }
}
