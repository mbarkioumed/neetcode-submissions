class Solution {
    public void islandsAndTreasure(int[][] grid) {

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    helper(grid , 0 , i , j);
                }
            }
        }
    }

    public void helper(int[][] grid , int dist , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] < dist) return;

        grid[i][j] = dist;


        helper(grid , dist + 1 , i + 1 , j);
        helper(grid , dist + 1 , i - 1 , j);
        helper(grid , dist + 1 , i , j + 1);
        helper(grid , dist + 1 , i , j - 1);

    }
}
