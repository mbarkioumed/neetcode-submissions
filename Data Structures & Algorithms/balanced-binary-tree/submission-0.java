class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root ==  null) return true;
        return maxDepth(root)[0] == 0;
    }

    public int[] maxDepth(TreeNode root) {
        int[] arr = new int[2];

        if(root == null){
            arr[1] = 0;
            arr[0] = 0;
        }else{
            int[] lar = maxDepth(root.left);
            int[] rar = maxDepth(root.right);
            arr[1] = Math.max(lar[1],rar[1]) + 1;
            if(lar[0] == 0 && rar[0] == 0 && ( lar[1]-rar[1] == 1 || lar[1]-rar[1] == -1 || lar[1]-rar[1] == 0)){
                arr[0] = 0;
            }else{
                arr[0] = 1;
            }
        }
        return arr;
    }
}