import java.util.*;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer,Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        HashMap<Integer,Integer> degree = new HashMap<>();
        for(int node : org){
            if(node < 1 || node > 10000) return false;
            graph.put(node, new HashSet());
            degree.put(node , 0);
        }
        int number = 0;
        for(List<Integer> list : seqs){
            int size = list.size();
            number += size;
            if(list.get(0) < 1 || list.get(0) > 10000) return false;
            for(int i = 1; i < size; i++){
                if(list.get(i) < 1 || list.get(i) > 10000 || !degree.containsKey(list.get(i))) return false;
                graph.get(list.get(i-1)).add(list.get(i));
                degree.put(list.get(i),degree.get(list.get(i))+1);
            }
        }
        if(number < degree.size()) return false;
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry entry : degree.entrySet()){
            if((int)entry.getValue() == 0){
                q.offer((int)entry.getKey());
            }
        }
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(size > 1) return false;
            int temp = q.poll();
            step++;
            for(int neigh : graph.get(temp)){
                degree.put(neigh, degree.get(neigh)-1);
                if(degree.get(neigh) == 0){
                    q.offer(neigh);
                }
            }
        }

        return step == org.length?true:false;

    }
    public static void main (String args[]){
        int []org = {1,2,3};
        List<List<Integer>> seqs = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        a.add(1);
        a.add(2);
        b.add(1);
        b.add(3);
        c.add(2);
        c.add(3);
        seqs.add(a);
        seqs.add(b);
        seqs.add(c);
        SequenceReconstruction s = new SequenceReconstruction();
        System.out.println(s.sequenceReconstruction(org,seqs));
    }
}
