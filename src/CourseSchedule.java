import java.util.*;

public class CourseSchedule {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int n = numCourses;
            ArrayList[] graph = new ArrayList[n];
            int degree[] = new int[n];
            for(int i = 0; i < n; i++){
                graph[i] = new ArrayList();
            }
            for(int []pre : prerequisites){
                graph[pre[1]].add(pre[0]);
                degree[pre[0]]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0 ; i < degree.length; i++){
                if(degree[i] == 0){
                    q.offer(i);
                }
            }
            int index = 0;
            int res[] = new int[n];
            while(!q.isEmpty()){
                int temp = q.poll();
                int size = graph[temp].size();
                res[index++] = temp;
                for(int i = 0 ;i < size; i++){
                    int ele = (int)graph[temp].get(i);
                    degree[ele]--;
                    if(degree[ele] == 0){
                        q.offer(ele);
                    }
                }
            }
            return index == n?res:new int[0];
        }
        public static void main(String args[]){
            CourseSchedule c = new CourseSchedule();
            int [][]a = new int[1][2];
            a[0][0]=1;
            a[0][1]=0;
            int res[] = c.findOrder(2,a);
            for(int r : res){
                System.out.println(r);
            }
        }
}
