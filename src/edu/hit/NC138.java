package edu.hit;

/**
 * 矩阵最长递增路径
 *
 * https://www.nowcoder.com/practice/7a71a88cdf294ce6bdf54c899be967a2?tpId=117&tqId=37850&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC138 {

    // memo[i][j]表示从矩阵(i,j)位置开始的最长长度
    private int[][] memo;

    public int solve (int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        // 行数和列数
        int rows = matrix.length, cols = matrix[0].length;
        // 最长长度
        int maxValue = 0;
        // 初始化备忘录
        memo = new int[rows][cols];
        // 遍历每一个节点,计算从该位置开始的最长长度
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                maxValue = Math.max(walk(matrix, i, j, -1), maxValue);
            }
        }
        return maxValue;
    }

    private int walk(int[][] matrix,int i, int j,int lastValue){
        int maxLen = 0;
        if(lastValue >= matrix[i][j]) return maxLen;
        // 当前位置开始的最长长度已知
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        // 上
        if(i > 0){
            maxLen = Math.max(maxLen, walk(matrix,i - 1,j, matrix[i][j]));
        }
        // 左
        if(j > 0){
            maxLen = Math.max(maxLen, walk(matrix,i,j - 1, matrix[i][j]));
        }
        // 下
        if(i < matrix.length - 1){
            maxLen = Math.max(maxLen, walk(matrix,i + 1, j, matrix[i][j]));
        }
        // 右
        if(j < matrix[0].length - 1){
            maxLen = Math.max(maxLen, walk(matrix,i, j + 1, matrix[i][j]));
        }
        // 更新当前位置开始的最长长度
        memo[i][j] = maxLen + 1;
        return maxLen + 1;
    }



    public static void main(String[] args) {
        NC138 nc138 = new NC138();
        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(nc138.solve(arr));
    }
}
