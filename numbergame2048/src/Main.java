package src;

import src.service.GameService;

import java.io.IOException;

public class Main {
    public static  void main(String[] args) throws IOException {
        GameService gameService = GameService.getInstance();
        gameService.initialiseBoard();
        gameService.startGame();
    }
}
