class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] car = new int[n][2];

        for(int i=0;i<n;i++){
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        Arrays.sort(car,(a,b) -> b[0] - a[0]);
        Stack<Double> st = new Stack<>();
        for(int[] c: car){
            double time = (double) (target - c[0])/ c[1]; 
            if(st.isEmpty() || time > st.peek()){
                st.push(time);
            }
        }

        return st.size();
    }
}
