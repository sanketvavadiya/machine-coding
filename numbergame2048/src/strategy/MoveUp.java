package src.strategy;

public class MoveUp {
    public static void move(long[][] matrix, int base) {
        moveUp(matrix);
        merge(matrix, base);
        moveUp(matrix);
    }

    private static void merge(long[][] matrix, int base) {
        for(int i=0 ; i<matrix.length ; i++) {
            for(int j=0 ; j<matrix.length-1 ; j++) {
                if(matrix[j][i] == matrix[j+1][i]) {
                    matrix[j][i] *= base;
                    matrix[j+1][i] = 0;
                }
            }
        }
    }

    public static void moveUp(long[][] matrix) {
        for(int i=0 ; i<matrix.length ; i++) {
            int firstZero = matrix.length;
            for (int j = 0 ; j < matrix.length ; j++)
                if (matrix[j][i] == 0) {
                    firstZero = j;
                    break;
                }
            for(int j=firstZero+1 ; j<matrix.length ; j++) {
                if(matrix[j][i] != 0) {
                    matrix[firstZero][i] = matrix[j][i];
                    matrix[j][i] = 0;
                    firstZero++;
                }
            }
        }
    }
}
