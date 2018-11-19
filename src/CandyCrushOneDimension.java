import java.util.ArrayList;
import java.util.Stack;

public class CandyCrushOneDimension {
    public String crush(String s){
        if(s.length() == 0 || s == null) return null;
        Stack<Node> stack = new Stack();
        for(char cc : s.toCharArray()){
            if(!stack.isEmpty()){
                if(cc == stack.peek().c){
                    int currCount = stack.peek().count+1;
                    if(currCount == 3){
                        stack.pop();
                        stack.pop();
                    }else{
                        stack.push(new Node(cc,currCount));
                    }
                }else{
                    stack.push(new Node(cc, 1));
                }
            }else{
                stack.push(new Node(cc,1));
            }
        }
        ArrayList<Node> list = new ArrayList<>(stack);
        String res = "";
        for(Node node : list){
            res += node.c;
        }
        return res;
    }
    public static void main(String args[]){
        String s = "ABBBA";
        CandyCrushOneDimension c = new CandyCrushOneDimension();
        System.out.println(c.crush(s));
    }
    class Node{
        char c;
        int count;
        public Node(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
}
