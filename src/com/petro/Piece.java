package com.petro;

public class Piece implements IPiece {

    private final ESide side;
    private final String name;
    private final EPiece piece;
    private EPosition position;
    private boolean captured;

    public Piece(ESide side, String name, EPiece piece, EPosition position) {
        this.side = side;
        this.name = name;
        this.piece = piece;
        this.position = position;
        this.captured = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EPiece getKind() {
        return piece;
    }

    @Override
    public ESide getSide() {
        return side;
    }

    @Override
    public EPosition getPosition() {
        return position;
    }

    @Override
    public void setPosition(EPosition position) {
        this.position = position;
    }

    @Override
    public boolean isCaptured() {
        return this.captured;
    }

    @Override
    public void setCaptured() {
        this.captured = true;
    }
}
