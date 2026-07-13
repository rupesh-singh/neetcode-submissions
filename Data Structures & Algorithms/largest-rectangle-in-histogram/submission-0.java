class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = Integer.MIN_VALUE;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            // monotonically increasing stack
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                // current index whose value we want to calculate
                int currentIndex = st.pop();
                int nextSmallerElementIndex = i;
                int previousSmallerElementIndex = (st.isEmpty()) ? -1 : st.peek();
                int width = nextSmallerElementIndex - previousSmallerElementIndex -1;
                int tempArea = heights[currentIndex] * width;
                area = Math.max(area,tempArea);
            }
            st.push(i);
        }

        int nextSmallerElementIndex = n;
        while(!st.isEmpty()){
            int currentIndex = st.pop();
            int previousSmallerElementIndex = (st.isEmpty()) ? -1 : st.peek();
            int width = nextSmallerElementIndex - previousSmallerElementIndex -1;
            int tempArea = heights[currentIndex] * width;
            area = Math.max(area,tempArea);
        }

        return area;
    }
}
