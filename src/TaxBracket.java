public class TaxBracket {
    final double []threshold = {0,20000,30000,35000,40000,45000,50000};
    final double []percentage = {0.1,0.2,0.3,0.4,0.5,0.6,0.7};
    public double calculateTax(double s){
        int length = threshold.length;
        int res = 0;
        int index = 0;
        int start = 0, end = length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(threshold[mid] <= s){
                start = mid;
            }else{
                end = mid;
            }
        }
        index = start;
        res += (s - threshold[index]) * percentage[index];
        for(int i = 0; i < index; i++){
            res += (threshold[i+1] - threshold[i]) * percentage[i];
        }
        return res;

    }

    public static void main(String args[]){
        double salary = 46000.0;
        TaxBracket t = new TaxBracket();
        System.out.println(t.calculateTax(salary));
    }
}
