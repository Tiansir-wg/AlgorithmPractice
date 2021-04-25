package edu.hit;

/**
 * 矩阵元素查找
 *
 * https://www.nowcoder.com/practice/3afe6fabdb2c46ed98f06cfd9a20f2ce?tpId=117&tqId=37788&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC86 {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        if(mat == null || mat.length == 0 || mat[0].length == 0) return null;
        for(int i = mat.length - 1;i >= 0;){
            for(int j = 0;j < mat[0].length;){
                if(mat[i][j] == x){
                    return new int[]{i, j};
                }else if(mat[i][j] < x){
                    j++;
                }else{
                    i--;
                }
            }
        }
        return null;
    }
}
