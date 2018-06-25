package com.redfox.chess.board;

import com.redfox.chess.pieces.*;
import com.redfox.chess.pieces.factory.BlackFactory;
import com.redfox.chess.pieces.factory.PieceFactory;
import com.redfox.chess.pieces.factory.WhiteFactory;
import com.redfox.chess.util.Color;
import com.redfox.chess.util.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;

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
        PieceFactory blackFactory = new BlackFactory();
        PieceFactory whiteFactory = new WhiteFactory();

        //Initialize black
        board[0][1].setPiece(blackFactory.createKnight(0));
        board[0][6].setPiece(blackFactory.createKnight(1));

        board[0][2].setPiece(blackFactory.createBishop(0));
        board[0][5].setPiece(blackFactory.createBishop(1));


        //Initialize white
        board[2][2].setPiece(whiteFactory.createKnight(0));
        board[7][6].setPiece(whiteFactory.createKnight(1));

        board[3][2].setPiece(whiteFactory.createBishop(0));
        board[7][5].setPiece(whiteFactory.createBishop(1));


    }


    public List<Piece> getTakenPieces(Color color) {
        if (color == Color.B) {
            return removedPiecesBlack;
        }
        return removedPiecesWhite;
    }

    private void takePiece(int x, int y) {
        Piece piece = getPieceAtBox(x, y);
        piece.setTaken();
        if (piece.getColor() == Color.B) {
            removedPiecesBlack.add(piece);
        } else {
            removedPiecesWhite.add(piece);
        }
        removePiece(x, y);

    }


    public Piece getPieceAtBox(int x, int y) {
        if (isValidPosition(x, y)) {
            return board[x][y].getPiece();
        }
        return null;
    }

    private void removePiece(int source_x, int source_y) {
        board[source_x][source_y].removePiece();
    }

    private void setPiece(Piece piece, int dest_x, int dest_y) {
        board[dest_x][dest_y].setPiece(piece);
    }


    private void updatePieceStatus(Piece piece, int source_x, int source_y, int finalX, int finalY) {
        removePiece(source_x, source_y);
        setPiece(piece, finalX, finalY);
    }

    private boolean isValidPosition(int x, int y) {
        return (x >= 0 && x <= 8) && (y >= 0 && y <= 8);
    }

    public Integer[] movePiece(Color color, int source_x, int source_y, int dest_x, int dest_y) throws InvalidMoveException {
        //check source and destination cordinates are inside the board
        if (!isValidPosition(source_x, source_y) || !isValidPosition(dest_x, dest_y)) {
            throw new InvalidMoveException("Provided coordinates are out of the board");
        }
        int finalX = dest_x;
        int finalY = dest_y;
        Piece piece = getPieceAtBox(source_x, source_y);
        if (piece == null) throw new InvalidMoveException("source cordinates are invalid");
        if (piece.getColor() != color) throw new InvalidMoveException("You can't move pieces of another color");

        Path path = piece.getValidPath(source_x, source_y, dest_x, dest_y);
        if (path != null) {
            List<Integer[]> tracePath = path.getTracePath();
            for (Integer[] pos : tracePath) {
                Piece other = getPieceAtBox(pos[0], pos[1]);
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
                if (getPieceAtBox(i,j) == null) {
                    System.out.print(board[i][j].getColor() + "    ");
                } else {
                    System.out.print(getPieceAtBox(i, j).getName() + "  ");
                }
            }
            System.out.println();
        }
    }
}
