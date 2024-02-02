package src.strategy;

public class MoveLeft {
    public static void move(long[][] matrix, int base) {
        moveLeft(matrix);
        merge(matrix, base);
        moveLeft(matrix);
    }

    private static void merge(long[][] matrix, int base) {
        for(int i=0 ; i<matrix.length ; i++) {
            for(int j=matrix.length - 1 ; j>0 ; j--) {
                if(matrix[i][j] == matrix[i][j-1]) {
                    matrix[i][j] *= base;
                    matrix[i][j-1] = 0;
                }
            }
        }
    }

    public static void moveLeft(long[][] matrix) {
        for(int i=0 ; i<matrix.length ; i++) {
            int firstZero = -1;
            for (int j = matrix.length - 1; j > 0; j--)
                if (matrix[i][j] == 0) {
                    firstZero = j;
                    break;
                }
            for(int j=firstZero-1 ; j>=0 ; j--) {
                if(matrix[i][j] != 0) {
                    matrix[i][firstZero] = matrix[i][j];
                    matrix[i][j] = 0;
                    firstZero--;
                }
            }
        }
    }
}
