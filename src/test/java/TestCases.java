


import com.redfox.chess.board.ChessBoard;
import com.redfox.chess.util.Color;
import com.redfox.chess.util.InvalidMoveException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCases {


    private ChessBoard chessBoard;

    @Before
    public void initObjects() {
        chessBoard = new ChessBoard();
        chessBoard.initializeBoard();
    }

    @Test
    public void checkTakenPieces() throws InvalidMoveException {

        assertTrue(chessBoard.getTakenPieces(Color.W).isEmpty());
        //Black knight moves from pos 0 1 to 2 2 and takes White knight
        chessBoard.movePiece(Color.B, 0, 1, 2, 2);
        assertEquals(chessBoard.getTakenPieces(Color.W).size(), 1);
        assertEquals(chessBoard.getTakenPieces(Color.W).get(0).getColor(), Color.W);
        chessBoard.showBoard();
    }

    @Test
    public void checkBishop() throws InvalidMoveException {
        //Expect to move bishop from 2,3 to 0,5 in order to take enemy bishop
        chessBoard.movePiece(Color.W, 3, 2, 0, 5);
        assertEquals(chessBoard.getPieceAtBox(0, 5).getName(), "BW0");
        assertEquals(chessBoard.getPieceAtBox(0, 5).getColor(), Color.W);

        //checks that we have take a B piece
        assertTrue(chessBoard.getTakenPieces(Color.B).size() == 1);
        chessBoard.showBoard();

    }

    @Test(expected = InvalidMoveException.class)
    public void checkInvalidMovement() throws InvalidMoveException {
        //chessBoard.showBoard();
        //try to move bishop straight forward instead of diagonal expected invalid move Exception
        chessBoard.movePiece(Color.B, 0, 2, 1, 2);
    }


}
