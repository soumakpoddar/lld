package org.example;

import org.example.Pojo.Board.Board;
import org.example.Pojo.Board.TicTacBoard;
import org.example.Pojo.Piece.PieceO;
import org.example.Pojo.Piece.PieceX;
import org.example.Pojo.Player.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;

public class Game {
    private Deque<Player> players;
    private Board gameBoard;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        players = new ArrayDeque<>();
        Player player1 = new Player("Player 1", new PieceX());
        Player player2 = new Player("Player 2", new PieceO());
        players.add(player1);
        players.add(player2);

        gameBoard = new TicTacBoard(3,3);
    }

    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {
            Player currentPlayer = players.poll();
            gameBoard.printBoard();

            List<Pair<Integer, Integer>> freeCells = gameBoard.getFreeCells();
            if (freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column : ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] split = s.split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            boolean makeMove = gameBoard.makeMove(x, y, currentPlayer);
            if (!makeMove) {
                System.out.println("Invalid move. Try again.");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);

            boolean winner = gameBoard.isGameOver(x, y, currentPlayer);
            if (winner) {
                noWinner = false;
                return currentPlayer.getName() + " wins!";
            }
        }

        return "tie";
    }
}