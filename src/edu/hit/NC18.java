package edu.hit;

/**
 * 顺时针旋转矩阵
 *
 * https://www.nowcoder.com/practice/2e95333fbdd4451395066957e24909cc?tpId=117&tqId=37790&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC18 {
    // 两次翻转
    public int[][] rotateMatrix_v1(int[][] mat, int n) {
        // 右对角线翻转
        // 注意只需要翻转对称轴左边的
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n - i - 1;j ++){
                mat[i][j] =  mat[i][j] ^  mat[n - j - 1][n - i - 1];
                mat[n - j - 1][n - i - 1] = mat[i][j] ^  mat[n - j - 1][n - i - 1];
                mat[i][j] =  mat[i][j] ^  mat[n - j - 1][n - i - 1];
            }
        }

        // 横向对称轴翻转
        for(int i = 0;i < n / 2;i++){
            for(int j = 0;j < n;j++){
                mat[i][j] =  mat[i][j] ^  mat[n - 1 - i][j];
                mat[n - 1- i][j] =  mat[i][j] ^  mat[n - 1 - i][j];
                mat[i][j] =  mat[i][j] ^  mat[n - 1 - i][j];
            }
        }
        return mat;
    }

    // 直接翻转
    public int[][] rotateMatrix(int[][] mat, int n) {
        int[][] ret = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j ++){
                // 注意方向
                ret[i][j] = mat[j][n - i - 1];
            }
        }
        return ret;
    }
}
