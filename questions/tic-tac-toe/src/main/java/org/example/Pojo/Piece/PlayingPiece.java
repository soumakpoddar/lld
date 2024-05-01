package org.example.Pojo.Piece;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Enum.PieceType;

@AllArgsConstructor
@Data
public class PlayingPiece {
    private PieceType pieceType;
}
