class Solution {
    Map<Integer, List<Integer>> map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();

        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[1], k -> new LinkedList<>()).add(pre[0]);
        }

        for(int i = 0; i < numCourses; i++){
           if(isPartOfCycle(i, new int[numCourses])) return false;
        }

        return true;
    }

    public boolean isPartOfCycle(int cur, int[] vis){
        if(vis[cur] == 1) return true;
        vis[cur] = 1;
        if(!map.containsKey(cur)) return false;
        for(int i : map.get(cur)){
            if(isPartOfCycle(i,vis)) return true;
            vis = new int[vis.length];
            vis[cur] = 1;
        }

        return false;
    }
}
