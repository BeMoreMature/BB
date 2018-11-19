import java.util.Stack;

public class regulationMatch {
    public boolean isMatch(String s){
        if(s.length() == 0 || s == null) return true;
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '['){
                if(!stack.isEmpty()){
                    if(stack.peek() == '{'){
                        stack.push(c);
                    }else return false;
                }else{
                    stack.push(c);
                }
                if(c == '{' && (i+1 < s.length() && s.charAt(i+1) == '[')){
                    flag = 1;
                }
            } else if( c == '('){
                if(!stack.isEmpty()){
                    if(stack.peek() == '['){
                        stack.push(c);
                    }else return false;
                }else{
                    stack.push(c);
                }
            } else if(c == '}'){
                if(flag == 0) return false;
                if(!stack.isEmpty()){
                    if(stack.peek() == '{'){
                        sb.append(stack.pop());
                        sb.append(c);
                        if(flag == 1 && stack.isEmpty()) flag = 0;
                    }else return false;
                } else  return false;
            } else if(c == ']'){
                if(!stack.isEmpty()){
                    if(stack.peek() == '['){
                        sb.append(stack.pop());
                        sb.append(c);
                    }else return false;
                } else  return false;
            } else if(c == ')'){
                if(!stack.isEmpty()){
                    if(stack.peek() == '('){
                       sb.append( stack.pop());
                       sb.append(c);
                    }else return false;
                } else  return false;
            }

        }
        String ss = sb.toString();
        for(int i = 0 ; i < ss.length(); i++){
            if(ss.charAt(i) == '{'){
                if(i-1 < 0 || (i-1 >= 0 && ss.charAt(i-1) == ')'))
                    return false;
            }
            if(ss.charAt(i) == '['){
                if(i-1 < 0 || (i-1 >= 0 && ss.charAt(i-1) != ')')){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        String s = "{{[(2+3)*(1-3)]+4}}*(14-3)";
        regulationMatch r = new regulationMatch();
        System.out.println(r.isMatch(s));
    }
}
