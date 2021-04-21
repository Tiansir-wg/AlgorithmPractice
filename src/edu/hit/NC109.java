package edu.hit;

/**
 * 岛屿数量
 *
 * https://www.nowcoder.com/practice/0c9664d1554e466aa107d899418e814e?tpId=117&tqId=37833&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC109 {

    private void dfs(char[][] grid,int i,int j){
        // 边界情况
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0');
        // 标记为已访问
        grid[i][j] = '0';
        // 上
        if(i >= 1 && grid[i - 1][j] == '1' ) dfs(grid, i - 1, j);
        // 下
        if(i + 1 < grid.length && grid[i + 1][j] == '1' ) dfs(grid, i + 1, j);
        // 左
        if(j >= 1 && grid[i][j - 1] == '1' ) dfs(grid, i, j - 1);
        // 右
        if(j + 1 < grid[0].length && grid[i][j + 1] == '1' ) dfs(grid, i, j + 1);
    }
    public int solve (char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int lands = 0;
        // 每次从一个未访问的节点开始将其周围的岛屿全部标记为已访问
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == '1'){
                    lands ++;
                    dfs(grid,i,j);
                }
            }
        }
        return lands;
    }
}
