import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class fourSum {
    public static int[] find(int arr[], int s){
        int res[] = new int[4];
        ArrayList<int []> list = new ArrayList();
        if(arr.length < 4) return new int[0];
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length - 3; i++){
            for(int j = i + 1; j < arr.length - 2; j++){
                int start = j + 1, end = arr.length - 1, sum = s - arr[i] - arr[j];
                while(start < end){
                    if(sum == arr[start] + arr[end]){
                        res[0] = arr[i];
                        res[1] = arr[j];
                        res[2] = arr[start];
                        res[3] = arr[end];
                        return res;
                    }else if( sum < arr[start] + arr[end]){
                        end--;
                    }else{
                        start++;
                    }

                }
            }
        }
        System.out.println("list.size() = " + list.size());
        for(int []i : list){
            for(int k = 0; k < i.length; k++){
                System.out.print(i[k]+" ");
            }
            System.out.println();
        }
        Collections.sort(list, new Comparator<int []>(){
            public int compare(int[] i1, int[] i2){
                return Integer.compare(i1[0], i2[0]);
            }
        });
        int r[] = list.get(0);
        return r;
    }
    public static void main(String args[]){
        int a[] = new int[]{2,7,4,0,9,5,1,3};
        int s = 20;
        int res[] = find(a,s);
        for(int i : res){
            System.out.println(i);
        }
    }
}
