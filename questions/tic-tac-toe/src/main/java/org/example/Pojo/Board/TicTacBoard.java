package org.example.Pojo.Board;

import javafx.util.Pair;
import org.example.Pojo.Piece.PlayingPiece;
import org.example.Pojo.Player.Player;

import java.util.ArrayList;
import java.util.List;

public class TicTacBoard implements Board {
    private int n;
    private int m;
    private PlayingPiece[][] board;

    public TicTacBoard(int n, int m) {
        this.n = n;
        this.m = m;
        this.board = new PlayingPiece[n][m];
    }

    @Override
    public boolean makeMove(int x, int y, Player player) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (board[x][y] != null) {
            return false;
        }

        board[x][y] = player.getPiece();
        return true;
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == null) {
                    System.out.print("-");
                } else {
                    System.out.print(board[i][j].getPieceType().name());
                }
            }
            System.out.println();
        }
    }

    @Override
    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == null) {
                    freeCells.add(new Pair<>(i, j));
                }
            }
        }

        return freeCells;
    }

    @Override
    public boolean isGameOver(int x, int y, Player player) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagMatch = true;
        boolean antiDiagMatch = true;

        for (int i = 0; i < n; i++) {
            if (board[x][i] == null || board[x][i].getPieceType() != player.getPiece().getPieceType()) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][y] == null || board[i][y].getPieceType() != player.getPiece().getPieceType()) {
                colMatch = false;
                break;
            }
        }

        for (int i=0,j=0;i<n && j<m;i++,j++) {
            if (board[i][j] == null || board[i][j].getPieceType() != player.getPiece().getPieceType()) {
                diagMatch = false;
                break;
            }
        }

        for (int i=0,j=m-1;i<n && j>=0;i++,j--) {
            if (board[i][j] == null || board[i][j].getPieceType() != player.getPiece().getPieceType()) {
                antiDiagMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagMatch || antiDiagMatch;
    }
}
