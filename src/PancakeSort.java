public class PancakeSort {

    public static void flip(int arr[], int k){
        int halfLength = (k + 1)/2;
        for(int i = 0 ; i < halfLength; i++){
            int temp = arr[i];
            arr[i] = arr[k - 1 - i];
            arr[k - 1 - i] = temp;
        }
    }
    static int findMaxIndex(int arr[] , int index){
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int i = 0 ; i <= index; i++ ){
            if(arr[i] > max){
                max = arr[i];
                res = i;
            }
        }
        return res;
    }
    static int[] pancakeSort(int[] arr) {
        // your code goes here
        for(int i = arr.length - 1; i >= 0; i--){
            int maxIndex = findMaxIndex(arr,i);
            flip(arr,maxIndex+1);
            flip(arr,i+1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,5,4,3,2};
        int res[] = pancakeSort(arr);
        for(int i : res){
            System.out.println(i);
        }
    }


}
