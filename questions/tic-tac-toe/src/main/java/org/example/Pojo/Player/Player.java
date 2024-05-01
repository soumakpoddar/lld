package org.example.Pojo.Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Pojo.Piece.PlayingPiece;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private PlayingPiece piece;
}
