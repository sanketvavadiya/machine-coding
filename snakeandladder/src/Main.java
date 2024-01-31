package src;

import src.service.SnakeAndLadder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SnakeAndLadder snakeAndLadder = SnakeAndLadder.getInstance();

        int snakes = Integer.parseInt(br.readLine().trim());
        while(snakes-- > 0) {
            String[] snake = br.readLine().trim().split(" ");
            int head = Integer.parseInt(snake[0]);
            int tail = Integer.parseInt(snake[1]);
            snakeAndLadder.addSnake(head, tail);
        }

        int ladders = Integer.parseInt(br.readLine().trim());
        while(ladders-- > 0) {
            String[] ladder = br.readLine().trim().split(" ");
            int start = Integer.parseInt(ladder[0]);
            int end = Integer.parseInt(ladder[1]);
            snakeAndLadder.addLadder(start, end);
        }

        int players = Integer.parseInt(br.readLine().trim());
        while(players-- > 0) {
            String name = br.readLine().trim();
            snakeAndLadder.addPlayer(name);
        }

        snakeAndLadder.startGame();
    }
}
