import java.util.LinkedList;
import java.util.Queue;

public class D3M2GetTarget {
    String D = "/3";
    String M = "*2";
    public String calculate(int target){
        Queue<Integer> q = new LinkedList<>();
        String res = "";
        q.offer(target);
        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp == 1) return "1"+res;
            if(temp % 2 == 0){
                res = M + res;
                q.offer(temp / 2);
            }else {
                res = D + res;
                q.offer(temp * 3 + 1);
            }
        }
        return res;
    }
    public static void main(String args[]){
        D3M2GetTarget d = new D3M2GetTarget();
        System.out.println(d.calculate(11));
        System.out.println(d.calculate(7));
    }
}
