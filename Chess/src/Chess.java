import java.util.ArrayList;

public class Chess {

    public class ChessBoard {
        int sizeOfSquares;
        final int NUMBER_OF_SQUARES = 64;
        int boardSize = sizeOfSquares * 8;
        ArrayList<Square> squares = new ArrayList<Square>();

        public ArrayList<Square> getSquares() {
            return squares;
        }

        ChessBoard() {
            /*create new chess board*/
            for (int i = 1; i <= NUMBER_OF_SQUARES; i++) {
                Piece piece;// = new Pawns(i,ChessColors.Black);
                switch (i) {
                    case 1:
                    case 8:
                        piece = new Rook(i, ChessColors.Black);
                        break;
                    case 2:
                    case 7:
                        piece = new Knight(i, ChessColors.Black);
                        break;
                    case 3:
                    case 6:
                        piece = new Bishop(i, ChessColors.Black);
                        break;
                    case 4:
                        piece = new Queen(i, ChessColors.Black);
                        break;
                    case 5:
                        piece = new King(i, ChessColors.Black);
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        piece = new Pawns(i, ChessColors.Black);
                        break;
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                        piece = new Pawns(i, ChessColors.White);
                        break;
                    case 57:
                    case 64:
                        piece = new Rook(i, ChessColors.White);
                        break;
                    case 58:
                    case 63:
                        piece = new Knight(i, ChessColors.White);
                        break;
                    case 59:
                    case 62:
                        piece = new Bishop(i, ChessColors.White);
                        break;
                    case 60:
                        piece = new Queen(i, ChessColors.White);
                        break;
                    case 61:
                        piece = new King(i, ChessColors.White);
                        break;
                    default:
                        piece = null;
                }

                squares.add(new Square(i, piece));
                if (piece != null) {
                    System.out.print(" " + piece.nameOfPieces);
                } else {
                    System.out.print("  ");
                }

                if (i % 8 == 0) {
                    System.out.println();
                }
            }
        }
    }

    public class Square {
        int id;
        /*Square also have two kind color*/
        ChessColors type;

        /*If have any piece is true*/
        boolean haveAnyPiece;

        /*which piece is stay on this square, if doesn't have any piece say 'null'*/
        Piece piece;

        /*Position*/
        int row;
        int col;

        public Piece getPiece() {
            return piece;
        }

        Square(int _id, Piece _piece) {
            /*id is 1~64*/
            this.id = _id;
            this.piece = _piece;

            /*convert to row and col*/
            int row = (_id / 8) + 1;
            int col = _id % 8;
            row = col == 0 ? row - 1 : row;
            col = col == 0 ? 8 : col;
            System.out.print(" " + row);
            System.out.print(col);
        }

        Square() {

        }
    }

    private enum ChessColors {
        Black,
        White
    }

    public enum NameOfPieces {
        /*capital is White, lower case is black*/
        K("White King"),
        k("Black King"),
        Q("White Queen"),
        q("Black Queen"),
        B("White Bishop"),
        b("Black Bishop"),
        N("White Knight"),
        n("Black Knight"),
        R("White Rook"),
        r("Black Rook"),
        P("White Pawn"),
        p("Black Pawn");

        private final String label;

        public String getLabel() {
            return label;
        }

        private NameOfPieces(String label) {
            this.label = label;
        }
    }

    public abstract class Piece {
        int id;
        ChessColors color;
        NameOfPieces nameOfPieces;
        Square StayPosition;

        public NameOfPieces getNameOfPieces() {
            return nameOfPieces;
        }

        /*every pieces can move and they have different rule so use 'abstract'*/
        public abstract void Move(int row, int col);

        public Square GetRecommendMove() {

            /*just for now no error*/
            return new Square();
        }

        public void die() {

        }
    }

    private class King extends Piece {

        King(int id, ChessColors Color) {
            this.id = id;
            this.color = Color;
            nameOfPieces = this.color == ChessColors.White ? NameOfPieces.K : NameOfPieces.k;
        }

        @Override
        public void Move(int row, int col) {

        }
    }

    private class Queen extends Piece {

        Queen(int id, ChessColors Color) {
            this.id = id;
            this.color = Color;
            nameOfPieces = this.color == ChessColors.White ? NameOfPieces.Q : NameOfPieces.q;
        }

        @Override
        public void Move(int row, int col) {

        }
    }

    private class Rook extends Piece {

        Rook(int id, ChessColors Color) {
            this.id = id;
            this.color = Color;
            nameOfPieces = this.color == ChessColors.White ? NameOfPieces.R : NameOfPieces.r;
        }

        @Override
        public void Move(int row, int col) {

        }
    }

    private class Bishop extends Piece {

        Bishop(int id, ChessColors Color) {
            this.id = id;
            this.color = Color;
            nameOfPieces = this.color == ChessColors.White ? NameOfPieces.B : NameOfPieces.b;
        }

        @Override
        public void Move(int row, int col) {

        }
    }

    private class Knight extends Piece {

        Knight(int id, ChessColors Color) {
            this.id = id;
            this.color = Color;
            nameOfPieces = this.color == ChessColors.White ? NameOfPieces.N : NameOfPieces.n;
        }

        @Override
        public void Move(int row, int col) {

        }
    }

    private class Pawns extends Piece {

        Pawns(int id, ChessColors Color) {
            this.id = id;
            this.color = Color;
            nameOfPieces = this.color == ChessColors.White ? NameOfPieces.P : NameOfPieces.p;
        }

        @Override
        public void Move(int row, int col) {

        }
    }
}
