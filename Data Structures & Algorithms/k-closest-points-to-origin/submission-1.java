class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[0]*a[0] + a[1]*a[1], b[0]*b[0] + b[1]*b[1]);
        });

        for(int[] point : points){
            heap.offer(point);
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(i < k){
            int[] cur = heap.poll();
            res[i][0] = cur[0];
            res[i][1] = cur[1];
            i++;
        }

        return res;
    }
}
