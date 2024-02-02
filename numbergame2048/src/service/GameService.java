package src.service;

import src.model.Board;
import src.strategy.MoveDown;
import src.strategy.MoveLeft;
import src.strategy.MoveRight;
import src.strategy.MoveUp;

import java.util.Scanner;

public class GameService {
    private static final GameService gameService = new GameService();
    private Board board;

    private GameService() {

    }

    public static GameService getInstance() {
        return gameService;
    }

    public void initialiseBoard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Board size: ");
        int size = sc.nextInt();
        System.out.print("Base: ");
        int base = sc.nextInt();
        System.out.print("Max number: ");
        int maxNubmer = sc.nextInt();
        board = new Board(size, base, maxNubmer);
        generateNext();
        generateNext();
        printBoard();
    }

    private void generateNext() {
        long[][] matrix = board.getMatrix();
        int [] cell = board.generateCell();
        long number = board.generateNumber();
        matrix[cell[0]][cell[1]] = number;
    }

    private void printBoard() {
        System.out.println("--------------------");
        for(int i=0 ; i<board.getSIZE() ; i++) {
            for (int j = 0; j < board.getSIZE(); j++)
                System.out.print(board.getMatrix()[i][j] + " ");
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        long[][] matrix = board.getMatrix();
        while(true) {
            System.out.println("a: left | s: down | d: right | w: up");
            System.out.print("Move: ");
            char move = sc.next().charAt(0);
            switch (move) {
                case 'a':
                    MoveRight.move(matrix, board.getBase());
                    break;
                case 's':
                    MoveDown.move(matrix, board.getBase());
                    break;
                case 'd':
                    MoveLeft.move(matrix, board.getBase());
                    break;
                case 'w':
                    MoveUp.move(matrix, board.getBase());
                    break;
            }
            generateNext();
            printBoard();
            int status = checkStatus();
            if(status == 1) {
                System.out.println("You won!");
                return;
            }
            if(status == -1) {
                System.out.println("Game over!");
                return;
            }
        }
    }

    private int checkStatus() {
        long[][] matrix = board.getMatrix();
        for (long[] row : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (row[j] == board.getWinnigNumber())
                    return 1;
                if (row[j] == 0)
                    return 0;
            }
        }

        for(int i=0 ; i<matrix.length-1 ; i++) {
            for(int j=0 ; j<matrix.length-1 ; j++) {
                if(matrix[i][j] == matrix[i][j+1])
                    return 0;
                if(matrix[j][i] == matrix[j+1][i])
                    return 0;
            }
        }
        return -1;
    }
}
