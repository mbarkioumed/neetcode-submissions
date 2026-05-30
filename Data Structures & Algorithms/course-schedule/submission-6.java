class Solution {
    Map<Integer, List<Integer>> map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();

        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[1], k -> new LinkedList<>()).add(pre[0]);
        }

        int[] vis = new int[numCourses]; // One array to rule them all
        for(int i = 0; i < numCourses; i++){
            if(isPartOfCycle(i, vis)) return false;
        }

        return true;
    }

    public boolean isPartOfCycle(int cur, int[] vis){
        if(vis[cur] == 1) return true;
        if(vis[cur] == 2) return false; 
        
        vis[cur] = 1;
        if(!map.containsKey(cur)) {
            vis[cur] = 2; 
            return false;
        }
        
        for(int i : map.get(cur)){
            if(isPartOfCycle(i, vis)) return true;
        }

        vis[cur] = 2; 
        return false;
    }
}
