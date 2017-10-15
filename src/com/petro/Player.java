package com.petro;

public class Player implements IPlayer {

    // constants for names of pieces
    private static final String Pawn = "Pawn";
    private static final String Rook = "Rook";
    private static final String Knight = "Knight";
    private static final String Bishop = "Bishop";
    private static final String Queen = "Queen";
    private static final String King = "King";
    private static final Integer numOfPieces = 16;

    private ESide side;
    private Piece[] pieces = new Piece[numOfPieces];
    private boolean offeredDraw = false;
    private boolean resigned = false;

    public Player(ESide side) {
        this.side = side;
        InitializePieces(getSide());
    }

    @Override
    public ESide getSide() {
        return side;
    }

    public boolean isPiecePresentAtPosition(EPosition position){
        int index = 0;
        boolean found = false;
        while(!found && index < numOfPieces){
            if(pieces[index].getPosition().equals(position)) {
                found = true;
                break;
            }
            index++;
        }
        return found;
    }

    public void updatePiece(EPosition start, EPosition end){
        boolean updated = false;
        int index = 0;
        while(!updated && index < 16){
            Piece current = pieces[index];
            if(current.getPosition().equals(start)){
                current.setPosition(end);
                updated = true;
            }
            index++;
        }
        recallDrawOffer();
    }

    public void capturePiece(EPosition position){
        int index = 0;
        while(index < numOfPieces) {
            if (pieces[index].isCaptured() == false) {
                pieces[index].setCaptured();
                break;
            }
            index++;
        }
    }

    public void setResigned(){
        resigned = true;
    }

    public boolean getResigned(){
        return resigned;
    }

    private void recallDrawOffer(){
        if(getOfferedDraw())
            setOfferedDraw(false);
    }

    public void setOfferedDraw(boolean offeredDraw) {
        this.offeredDraw = offeredDraw;
    }

    public boolean getOfferedDraw(){
        return this.offeredDraw;
    }

    public Piece getPieceOnSquare(EPosition square){
        Piece pieceHere = null;
        int index = 0;
        boolean found = false;
        while(!found && index < numOfPieces){
            if(pieces[index].getPosition().equals(square)) {
                pieceHere = pieces[index];
                break;
            }
            index++;
        }
        return pieceHere; // should never be null here


    }

    private void InitializePieces( ESide side){

        // initialize 8 Pawns
        if(side.equals(ESide.WHITE)) {
            pieces[0] = new Piece(side, Pawn, EPiece.PAWN, EPosition.A2);
            pieces[1] = new Piece(side, Pawn, EPiece.PAWN, EPosition.B2);
            pieces[2] = new Piece(side, Pawn, EPiece.PAWN, EPosition.C2);
            pieces[3] = new Piece(side, Pawn, EPiece.PAWN, EPosition.D2);
            pieces[4] = new Piece(side, Pawn, EPiece.PAWN, EPosition.E2);
            pieces[5] = new Piece(side, Pawn, EPiece.PAWN, EPosition.F2);
            pieces[6] = new Piece(side, Pawn, EPiece.PAWN, EPosition.G2);
            pieces[7] = new Piece(side, Pawn, EPiece.PAWN, EPosition.H2);

            // initialize 2 Rooks
            pieces[8] = new Piece(side, Rook, EPiece.ROOK, EPosition.A1);
            pieces[9] = new Piece(side, Rook, EPiece.ROOK, EPosition.H1);

            // initialize 2 Knights
            pieces[10] = new Piece(side, Knight, EPiece.KNIGHT, EPosition.B1);
            pieces[11] = new Piece(side, Knight, EPiece.KNIGHT, EPosition.G1);

            // initialize 2 Bishops
            pieces[12] = new Piece(side, Bishop, EPiece.BISHOP, EPosition.C1);
            pieces[13] = new Piece(side, Bishop, EPiece.BISHOP, EPosition.F1);

            // initialize Queen & King
            pieces[14] = new Piece(side, Queen, EPiece.QUEEN, EPosition.D1);
            pieces[15] = new Piece(side, King, EPiece.KING, EPosition.E1);
        }else{
            pieces[0] = new Piece(side, Pawn, EPiece.PAWN, EPosition.A7);
            pieces[1] = new Piece(side, Pawn, EPiece.PAWN, EPosition.B7);
            pieces[2] = new Piece(side, Pawn, EPiece.PAWN, EPosition.C7);
            pieces[3] = new Piece(side, Pawn, EPiece.PAWN, EPosition.D7);
            pieces[4] = new Piece(side, Pawn, EPiece.PAWN, EPosition.E7);
            pieces[5] = new Piece(side, Pawn, EPiece.PAWN, EPosition.F7);
            pieces[6] = new Piece(side, Pawn, EPiece.PAWN, EPosition.G7);
            pieces[7] = new Piece(side, Pawn, EPiece.PAWN, EPosition.H7);

            // initialize 2 Rooks
            pieces[8] = new Piece(side, Rook, EPiece.ROOK, EPosition.A8);
            pieces[9] = new Piece(side, Rook, EPiece.ROOK, EPosition.H8);

            // initialize 2 Knights
            pieces[10] = new Piece(side, Knight, EPiece.KNIGHT, EPosition.B8);
            pieces[11] = new Piece(side, Knight, EPiece.KNIGHT, EPosition.G8);

            // initialize 2 Bishops
            pieces[12] = new Piece(side, Bishop, EPiece.BISHOP, EPosition.C8);
            pieces[13] = new Piece(side, Bishop, EPiece.BISHOP, EPosition.F8);

            // initialize Queen & King
            pieces[14] = new Piece(side, Queen, EPiece.QUEEN, EPosition.D8);
            pieces[15] = new Piece(side, King, EPiece.KING, EPosition.E8);
        }

    }
}
