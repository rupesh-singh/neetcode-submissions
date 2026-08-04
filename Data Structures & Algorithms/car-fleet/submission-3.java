class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] data = new int[n][2];

        for(int i=0;i<n;i++){
            data[i][0] = position[i];
            data[i][1] = speed[i];
        }

        // sort based on position
        Arrays.sort(data, (a,b) -> a[0] - b[0]);

        Stack<Double> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            double time = (double)(target - data[i][0]) / data[i][1];

            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }

        }

        return st.size();

    }
}


// 0 1 4 7
// 1 2 2 1

// 10 4 3 3

// 0 2   4
// 2 3   1
// 5 2.6 6
