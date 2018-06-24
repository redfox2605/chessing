package com.redfox.chess.board;

import com.redfox.chess.pieces.Path;
import com.redfox.chess.pieces.Piece;
import com.redfox.chess.util.Color;
import com.redfox.chess.pieces.Knight;
import com.redfox.chess.util.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChessBoard {

    private Box[][] board;
    private List<Piece> removedPiecesBlack;
    private List<Piece> removedPiecesWhite;


    public ChessBoard() {
        this.removedPiecesBlack = new ArrayList<>();
        this.removedPiecesWhite = new ArrayList<>();
        this.board = new Box[8][8];
        //Initialize Cells
        int last = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = last % 2 == 0 ? new Box(Color.W) : new Box(Color.B);
                last++;
            }
            last--;
        }
    }


    public void initializeBoard() {
        System.out.println("initializing board");
        //Initialize black
        board[0][1].setPiece(new Knight(0, Color.B));
        board[0][6].setPiece(new Knight(1, Color.B));

        //Initialize white
        board[2][2].setPiece(new Knight(0, Color.W));
        board[7][6].setPiece(new Knight(1, Color.W));


    }


    private void takePiece(int x, int y) {
        Piece piece = board[x][y].getPiece();
        piece.setTaken();
        if (piece.getColor() == Color.B) {
            removedPiecesBlack.add(piece);
        } else {
            removedPiecesWhite.add(piece);
        }
        removePiece(x, y);

    }

    public void removePiece(int source_x, int source_y) {
        board[source_x][source_y].removePiece();
    }

    public void setPiece(Piece piece, int dest_x, int dest_y) {
        board[dest_x][dest_y].setPiece(piece);
    }


    private void updatePieceStatus(Piece piece, int source_x, int source_y, int finalX, int finalY) {
        removePiece(source_x, source_y);
        setPiece(piece, finalX, finalY);
    }

    public Integer[] movePiece(Color color, int source_x, int source_y, int dest_x, int dest_y) throws InvalidMoveException {
        int finalX = dest_x;
        int finalY = dest_y;
        Piece piece = board[source_x][source_y].getPiece();
        if (piece == null) throw new InvalidMoveException("source cordinates are invalid");
        if (piece.getColor() != color) throw new InvalidMoveException("You can't move pieces of another color");

        Path path = piece.getValidPath(source_x, source_y, dest_x, dest_y);
        if (path != null) {
            List<Integer[]> tracePath = path.getTracePath();
            for (Integer[] pos : tracePath) {
                Piece other = board[pos[0]][pos[1]].getPiece();
                if (other != null) {
                    if (other.getColor() == color) {
                        throw new InvalidMoveException("there is a piece of your color in the path to your destination");
                    }
                    takePiece(pos[0], pos[1]);
                    System.out.println(piece.getName() + " has taken " + other.getName());
                    finalX = pos[0];
                    finalY = pos[1];
                    break;
                }
            }
            updatePieceStatus(piece, source_x, source_y, finalX, finalY);
            return new Integer[]{finalX, finalY};
        }
        throw new InvalidMoveException("this is an illegal move for " + piece.getName());
    }

    public void showBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getPiece() == null) {
                    System.out.print(board[i][j].getColor() + "    ");
                } else {
                    System.out.print(board[i][j].getPiece().getName() + "  ");
                }
            }
            System.out.println();
        }
    }
}
