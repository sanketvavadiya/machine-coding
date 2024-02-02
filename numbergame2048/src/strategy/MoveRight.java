package src.strategy;

public class MoveRight {
    public static void move(long[][] matrix, int base) {
        moveRight(matrix);
        merge(matrix, base);
        moveRight(matrix);
    }

    private static void merge(long[][] matrix, int base) {
        for(int i=0 ; i<matrix.length ; i++) {
            for(int j=0 ; j<matrix.length-1 ; j++) {
                if(matrix[i][j] == matrix[i][j+1]) {
                    matrix[i][j] *= base;
                    matrix[i][j+1] = 0;
                }
            }
        }
    }

    public static void moveRight(long[][] matrix) {
        for(int i=0 ; i<matrix.length ; i++) {
            int firstZero = matrix.length;
            for (int j = 0 ; j < matrix.length ; j++)
                if (matrix[i][j] == 0) {
                    firstZero = j;
                    break;
                }
            for(int j=firstZero+1 ; j<matrix.length ; j++) {
                if(matrix[i][j] != 0) {
                    matrix[i][firstZero] = matrix[i][j];
                    matrix[i][j] = 0;
                    firstZero++;
                }
            }
        }
    }
}
