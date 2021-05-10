package edu.hit;

/**
 * N 皇后问题
 *
 *
 * https://www.nowcoder.com/practice/c76408782512486d91eea181107293b6?tpId=117&tqId=37811&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC39 {

    private int cnt = 0;

    public int Nqueen (int n) {
        if(n <= 1) return n;
        boolean[][] plate = new boolean[n][n];
        place(plate, 0);
        return cnt;
    }

    private void place(boolean[][] plate, int rowIndex){
        if(rowIndex >= plate.length){
            cnt++;
        }else{
            for(int j = 0;j < plate.length;j++){
                if(canPlace(plate, rowIndex, j)){
                    plate[rowIndex][j] = true;
                    place(plate, rowIndex + 1);
                    plate[rowIndex][j] = false;
                }
            }
        }
    }

    // 当前位置是否可以放置皇后
    private boolean canPlace(boolean[][] plate, int rowIndex, int colIndex){
        // 同一列
        for(int i = 0;i < rowIndex;i++){
            if(plate[i][colIndex]){
                return false;
            }
        }

        // 同一对角线
        for(int i = 0;i < rowIndex;i++){
            for(int j = 0;j < colIndex;j ++){
                if(plate[i][j] && rowIndex - i == colIndex - j){
                    return false;
                }
            }
        }

        // 同一斜对角线
        for(int i = 0;i < rowIndex;i++){
            for(int j = plate.length - 1;j > colIndex;j --){
                if(plate[i][j] && rowIndex - i == j - colIndex){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NC39 nc39 = new NC39();
        System.out.println(nc39.Nqueen(8));
    }
}
