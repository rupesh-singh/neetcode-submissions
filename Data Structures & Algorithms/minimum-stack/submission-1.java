class Node {
    int val;
    int min;
    public Node(int val,int min){
        this.val = val;
        this.min = min;
    }
}
class MinStack {
    Stack<Node> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Node(val,val));
        }
        else {
            int m = Math.min(val,st.peek().min);
            st.push(new Node(val,m));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
