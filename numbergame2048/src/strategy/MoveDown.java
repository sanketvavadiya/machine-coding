package src.strategy;

public class MoveDown {
    public static void move(long[][] matrix, int base) {
        moveDown(matrix);
        merge(matrix, base);
        moveDown(matrix);
    }

    private static void merge(long[][] matrix, int base) {
        for(int i=0 ; i<matrix.length ; i++) {
            for(int j=matrix.length - 1 ; j>0 ; j--) {
                if(matrix[j][i] == matrix[j-1][i]) {
                    matrix[j][i] *= base;
                    matrix[j-1][i] = 0;
                }
            }
        }
    }

    public static void moveDown(long[][] matrix) {
        for(int i=0 ; i<matrix.length ; i++) {
            int firstZero = -1;
            for (int j = matrix.length - 1; j > 0; j--)
                if (matrix[j][i] == 0) {
                    firstZero = j;
                    break;
                }
            for(int j=firstZero-1 ; j>=0 ; j--) {
                if(matrix[j][i] != 0) {
                    matrix[firstZero][i] = matrix[j][i];
                    matrix[j][i] = 0;
                    firstZero--;
                }
            }
        }
    }
}
