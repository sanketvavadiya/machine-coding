package src.service;

import src.model.Dice;
import src.model.Ladder;
import src.model.Player;
import src.model.Snake;

import java.util.*;

public class SnakeAndLadder {
    HashMap<Integer, Snake> snakes;
    HashMap<Integer, Ladder> ladders;
    List<Player> players;
    Set<String> winners;
    Dice dice;
    int winnigPosition;

    private SnakeAndLadder() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        players = new ArrayList<>();
        winners = new HashSet<>();
        dice = Dice.getInstance();
        winnigPosition = 100;
    }

    private static final SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
    public static SnakeAndLadder getInstance() {
        return  snakeAndLadder;
    }

    public void addSnake(int head, int tail) {
        snakes.put(head, new Snake(head, tail));
    }

    public void addLadder(int start, int end) {
        snakes.put(start, new Snake(start, end));
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void startGame() {
        int playerIndex = 0; // starting with first player
        int totalPlayers = players.size();
        while(winners.size() != totalPlayers-1) {
            Player currentPlayer = players.get(playerIndex);
            if(!winners.contains(currentPlayer.getName())) {
                StringBuffer sb = new StringBuffer();
                int move = dice.rollDice();
                int nextPosition = currentPlayer.getPosition() + move;
                int finalPosition = getFinalPosition(nextPosition);
                sb.append(currentPlayer.getName() + " rolled a " + move +
                        " move from " + currentPlayer.getPosition() + " to " + finalPosition + "\n");
                currentPlayer.setPosition(finalPosition);
                if (isWinner(finalPosition)) {
                    winners.add(currentPlayer.getName());
                    sb.append(currentPlayer.getName() + " has won the match!!!\n");
                }
                System.out.print(sb);
            }
            playerIndex = (playerIndex+1) % totalPlayers;
        }
    }
    private int getFinalPosition(int position) {
        if(snakes.containsKey(position))
            return getFinalPosition(snakes.get(position).getTail());
        else if (ladders.containsKey(position))
            return getFinalPosition(ladders.get(position).getEnd());
        return position;
    }

    private boolean isWinner(int position) {
        return position == this.winnigPosition;
    }
}
