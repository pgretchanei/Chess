package com.petro;

public class Game {
    private EGameState state;
    private Player white;
    private Player black;
    private ESide nextToMove;

    public Game() {
        white = new Player(ESide.WHITE);
        black = new Player(ESide.BLACK);
        nextToMove = ESide.WHITE;
        state = EGameState.IN_PROGRESS;
    }

    private boolean isLegalMove(Player player, EPosition start, EPosition end){
        // 0. Offers of draw and resignations - return true
        // 1. Determine if there is a piece that belongs to the current player at this square
        // 2. Determine if a piece can move(pinned to king)
        // 3. Determine if there are pieces(friendly/enemy) enroute(blocking) to the end square
        // 4. Determine if there is a firendly piece at the end square
        if(isDrawOrResignOffer(start))
            return true;

        boolean isThere = isPiecePresent(start);
        boolean isDestTakenFriendly = isDestinationTakenFriendly(end);
        boolean canMove = canPieceMove(start);
        boolean isBlocked = isPieceBlocked(start, end);
        return isThere && canMove && !isBlocked && !isDestTakenFriendly;
    }

    public void makeMove(EPosition start, EPosition end){
        Player currentPlayer;
        Player otherPlayer;
        if(nextToMove.equals(ESide.WHITE)){
            currentPlayer = white;
            otherPlayer = black;
        }else{
            currentPlayer = black;
            otherPlayer = white;
        }

        if(isLegalMove(currentPlayer, start, end)){
            if(start.equals(EPosition.DRAW)) {
                currentPlayer.setOfferedDraw(true);
                updateGameState();
                return;
            }
            if(start.equals(EPosition.RESIGN)){
                currentPlayer.setResigned();
                updateGameState();
                return;
            }

            executeMove(currentPlayer, start, end);
            if(needToUpdateOtherPlayer(otherPlayer, end)) {
                capturePiece(otherPlayer, end);
            }
            updateNextToMove();
        }else{
            System.out.println("Illegal Move");
        }


    }

    private void executeMove( Player player, EPosition start, EPosition end){
        System.out.println("Executing a move for " + player.getSide() + ": from '" + start + "' to '" + end);
        player.updatePiece( start, end);
    }

    // check if anyone won or a draw
    public boolean end(){
        return state.equals(EGameState.BLACK_WON)
                || state.equals(EGameState.WHITE_WON)
                || state.equals(EGameState.DRAW);
    }

    public ESide getNextToMove() {
        return nextToMove;
    }

    private Player getNextToMovePlayer(){
        Player nextToMove;
        if(getNextToMove().equals(ESide.WHITE)) {
             nextToMove = white;
        }else{
            nextToMove = black;
        }

        return nextToMove;
    }

    private void updateNextToMove(){
        if(getNextToMove().equals(ESide.WHITE)) {
            nextToMove = ESide.BLACK;
        }else{
            nextToMove = ESide.WHITE;
        }
    }

    private boolean needToUpdateOtherPlayer(Player player, EPosition position){
        boolean needToUpdate = false;
        if(player.isPiecePresentAtPosition(position))
            needToUpdate = true;

        return needToUpdate;
    }

    private void capturePiece(Player player, EPosition position){
        player.capturePiece(position);
    }

    private boolean isPiecePresent(EPosition position){
        // TODO: implement this
        return true;
    }

    private boolean canPieceMove(EPosition position){
        //TODO: implement this
        return true;
    }

    private boolean isPieceBlocked(EPosition start, EPosition end){
        // TODO: implement this
        return false;
    }

    private boolean isDestinationTakenFriendly(EPosition destination){
        return false;
    }

    private boolean isDrawOrResignOffer(EPosition start){
        boolean isDrawResign = false;
        if(start.equals(EPosition.DRAW) || start.equals(EPosition.RESIGN))
            isDrawResign = true;
        return isDrawResign;
    }

    public void updateGameState(){
        if(nextToMove.equals(ESide.WHITE) && white.getResigned())
            state = EGameState.BLACK_WON;
        if(nextToMove.equals(ESide.BLACK) && black.getResigned())
            state = EGameState.WHITE_WON;
        if(white.getOfferedDraw() && black.getOfferedDraw())
            state = EGameState.DRAW;
    }

    public EPosition convertToEnum(String input){
        input = input.toUpperCase();
        EPosition position;
        switch (input){
            case "A1":
                position = EPosition.A1;
                break;
            case "A2":
                position = EPosition.A2;
                break;
            case "A3":
                position = EPosition.A3;
                break;
            case "A4":
                position = EPosition.A4;
                break;
            case "A5":
                position = EPosition.A5;
                break;
            case "A6":
                position = EPosition.A6;
                break;
            case "A7":
                position = EPosition.A7;
                break;
            case "A8":
                position = EPosition.A8;
                break;
            case "B1":
                position = EPosition.B1;
                break;
            case "B2":
                position = EPosition.B2;
                break;
            case "B3":
                position = EPosition.B3;
                break;
            case "B4":
                position = EPosition.B4;
                break;
            case "B5":
                position = EPosition.B5;
                break;
            case "B6":
                position = EPosition.B6;
                break;
            case "B7":
                position = EPosition.B7;
                break;
            case "B8":
                position = EPosition.B8;
                break;
            case "C1":
                position = EPosition.C1;
                break;
            case "C2":
                position = EPosition.C2;
                break;
            case "C3":
                position = EPosition.C3;
                break;
            case "C4":
                position = EPosition.C4;
                break;
            case "C5":
                position = EPosition.C5;
                break;
            case "C6":
                position = EPosition.C6;
                break;
            case "C7":
                position = EPosition.C7;
                break;
            case "C8":
                position = EPosition.C8;
                break;
            case "D1":
                position = EPosition.D1;
                break;
            case "D2":
                position = EPosition.D2;
                break;
            case "D3":
                position = EPosition.D3;
                break;
            case "D4":
                position = EPosition.D4;
                break;
            case "D5":
                position = EPosition.D5;
                break;
            case "D6":
                position = EPosition.D6;
                break;
            case "D7":
                position = EPosition.D7;
                break;
            case "D8":
                position = EPosition.D8;
                break;
            case "E1":
                position = EPosition.E1;
                break;
            case "E2":
                position = EPosition.E2;
                break;
            case "E3":
                position = EPosition.E3;
                break;
            case "E4":
                position = EPosition.E4;
                break;
            case "E5":
                position = EPosition.E5;
                break;
            case "E6":
                position = EPosition.E6;
                break;
            case "E7":
                position = EPosition.E7;
                break;
            case "E8":
                position = EPosition.E8;
                break;
            case "F1":
                position = EPosition.F1;
                break;
            case "F2":
                position = EPosition.F2;
                break;
            case "F3":
                position = EPosition.F3;
                break;
            case "F4":
                position = EPosition.F4;
                break;
            case "F5":
                position = EPosition.F5;
                break;
            case "F6":
                position = EPosition.F6;
                break;
            case "F7":
                position = EPosition.F7;
                break;
            case "F8":
                position = EPosition.F8;
                break;
            case "G1":
                position = EPosition.G1;
                break;
            case "G2":
                position = EPosition.G2;
                break;
            case "G3":
                position = EPosition.G3;
                break;
            case "G4":
                position = EPosition.G4;
                break;
            case "G5":
                position = EPosition.G5;
                break;
            case "G6":
                position = EPosition.G6;
                break;
            case "G7":
                position = EPosition.G7;
                break;
            case "G8":
                position = EPosition.G8;
                break;
            case "H1":
                position = EPosition.H1;
                break;
            case "H2":
                position = EPosition.H2;
                break;
            case "H3":
                position = EPosition.H3;
                break;
            case "H4":
                position = EPosition.H4;
                break;
            case "H5":
                position = EPosition.H5;
                break;
            case "H6":
                position = EPosition.H6;
                break;
            case "H7":
                position = EPosition.H7;
                break;
            case "H8":
                position = EPosition.H8;
                break;
            case "DRAW":
                position = EPosition.DRAW;
                break;
            case "RESIGN":
                position = EPosition.RESIGN;
            default:
                position = EPosition.ERROR;
        }
        return position;
    }
}
