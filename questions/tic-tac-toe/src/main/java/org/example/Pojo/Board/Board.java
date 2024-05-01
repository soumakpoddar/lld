package org.example.Pojo.Board;

import javafx.util.Pair;
import org.example.Pojo.Player.Player;

import java.util.List;

public interface Board {
    public boolean makeMove(int x, int y, Player player);
    public void printBoard();
    public List<Pair<Integer, Integer>> getFreeCells();
    public boolean isGameOver(int x, int y, Player player);
}
