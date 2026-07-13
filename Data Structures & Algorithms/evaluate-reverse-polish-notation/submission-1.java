class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s: tokens){
            if(s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")){
                int a = st.pop();
                int b = st.pop();
                int val = process(b,a,s);
                st.push(val);

            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        
        return st.pop();
    }

    public int process(int a, int b, String op){
        switch(op){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return 0;
    }
}
