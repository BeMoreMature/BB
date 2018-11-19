import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.TreeSet;

public class FindMinDiffPair {
    public int[] findPair(int arr[]){
        int res[] = new int[2];
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i+1] - arr[i] < min){
                min = arr[i+1] - arr[i];
                res[0] = arr[i];
                res[1] = arr[i+1];
            }
        }
        return res;
    }

    public int findPairWithoutSort(int arr[]){
        int res[] = new int[2];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i : arr){
            if(set.contains(i)) return 0;
            set.add(i);
        }
        int min = Integer.MAX_VALUE;
        int pre = Integer.MAX_VALUE;
        for(int i : set){
            if(pre != Integer.MAX_VALUE)
                min = Math.min(i - pre, min);
            pre = i;
        }
        return min;
    }
    public static void main(String args[]){
        int arr[] = new int[]{100,90,80,6,5,9};
        FindMinDiffPair f = new FindMinDiffPair();
//        int res [] = f.findPair(arr);
//        for(int i : res){
//            System.out.println(i);
//        }
        System.out.println(f.findPairWithoutSort(arr));
    }
}
