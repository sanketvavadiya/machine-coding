package src.model;

import java.util.Random;

public class Board {
    int SIZE;
    long[][] matrix;
    int base;
    int maxNumber;
    long[] randomHelper;
    long winnigNumber;

    Random random;
    public Board(int size, int base, int maxNumber) {
        this.SIZE = size;
        this.base = base;
        this.maxNumber = maxNumber - 1; // to avoid generating winning number
        matrix = new long[SIZE][SIZE];
        randomHelper = new long[this.maxNumber];
        random = new Random();
        winnigNumber = (long) Math.pow(base, maxNumber);
        fillRandomHelper();
    }

    private void fillRandomHelper() {
        for(int i=0 ; i<randomHelper.length ; i++)
            randomHelper[i] = (long) Math.pow(base, i+1);
    }

    public long generateNumber() {
        int index = (Math.abs(random.nextInt()) % maxNumber);
        return randomHelper[index];
    }

    public int[] generateCell() {
        int[] cell = new int[2];
        while(true) {
            int i = (Math.abs(random.nextInt()) % SIZE);
            int j = (Math.abs(random.nextInt()) % SIZE);
            if(matrix[i][j] == 0)
                return new int[]{i, j};
        }
    }

    public int getSIZE() {
        return SIZE;
    }

    public void setSIZE(int SIZE) {
        this.SIZE = SIZE;
    }

    public long[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(long[][] matrix) {
        this.matrix = matrix;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public long[] getRandomHelper() {
        return randomHelper;
    }

    public void setRandomHelper(long[] randomHelper) {
        this.randomHelper = randomHelper;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public long getWinnigNumber() {
        return winnigNumber;
    }

    public void setWinnigNumber(long winnigNumber) {
        this.winnigNumber = winnigNumber;
    }
}
