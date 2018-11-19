import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class GetAndSetFunction {
    long diff = 5 * 60 * 1000;
    HashMap<String, Result> map = new HashMap<>();

    public String get(String key){
        if(!map.containsKey(key)) return null;
        Result result = map.get(key);
        Date now = new Date();
        if(now.after(new Date(result.d.getTime() + diff))){
            map.put(key, new Result(now, result.value));
            return null;
        }else{
            map.put(key, new Result(now, result.value));
            return result.value;
        }
    }
    public void set(String key, String value){
        Date d = new Date(new Date().getTime() - diff);
//        Date d = new Date();
        Result result = new Result(d, value);
        map.put(key, result);
    }
    class Result{
        Date d;
        String value;
        public Result(Date d, String value){
            this.d = d;
            this.value = value;
        }
    }
    public static void main(String args[]){
        GetAndSetFunction g = new GetAndSetFunction();
        g.set("b","567");
        System.out.println(g.get("b"));
        System.out.println(g.get("b"));
    }
}
