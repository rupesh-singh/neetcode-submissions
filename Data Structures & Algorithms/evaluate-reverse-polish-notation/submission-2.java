class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int se = st.pop();
                int f = st.pop();
                int val = eval(f,se,s);
                st.push(val);
            }
            else {
                st.push(Integer.valueOf(s));
            }
        }

        return st.peek();
    }

    public int eval(int a, int b, String s){
        switch(s){
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
        }
        return 0;
    }
}
