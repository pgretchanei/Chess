package com.petro;

public interface IPiece {
    String getName();
    EPiece getKind();
    ESide getSide();
    EPosition getPosition();
    void setPosition(EPosition position);
    boolean isCaptured();
    void setCaptured();

}
