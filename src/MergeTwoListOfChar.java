import java.util.*;

public class MergeTwoListOfChar {
    public ArrayList<Character> merge(ArrayList<Character> a , ArrayList<Character> b){
        HashMap<Character,HashSet<Character>> graph = new HashMap<>();
        HashMap<Character,Integer> degree = new HashMap<>();
        for(char c : a){
            graph.put(c, new HashSet<>());
            degree.put(c, 0);
        }
        for(char c : b){
            graph.put(c, new HashSet<>());
            degree.put(c, 0);
        }
        for(int i = 0; i < a.size() - 1; i++){
            graph.get(a.get(i)).add(a.get(i+1));
            degree.put(a.get(i+1),degree.get(a.get(i+1))+1);
        }
        for(int i = 0; i < b.size() - 1; i++){
            graph.get(b.get(i)).add(b.get(i+1));
            degree.put(b.get(i+1),degree.get(b.get(i+1))+1);
        }

        Queue<Character> q = new LinkedList<>();
        for(char c : degree.keySet()){
            if(degree.get(c) == 0){
                q.offer(c);
            }
        }
        ArrayList<Character> res = new ArrayList<>();
        while(!q.isEmpty()){
            char temp = q.poll();
            res.add(temp);
            int size = graph.get(temp).size();
            for(int i = 0 ; i < size; i++){
                ArrayList<Character> list = new ArrayList<>(graph.get(temp));
                char key = list.get(i);
                degree.put(key, degree.get(key)-1);
                if(degree.get(key) == 0){
                    q.offer(key);
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        ArrayList<Character> a = new ArrayList<>(Arrays.asList('C','B','D','F','H'));
        ArrayList<Character> b = new ArrayList<>(Arrays.asList('J','B','K','H','A'));
        MergeTwoListOfChar m = new MergeTwoListOfChar();
        m.merge(a,b).forEach(System.out::print);
    }
}
