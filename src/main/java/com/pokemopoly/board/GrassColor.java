package com.pokemopoly.board;

public enum GrassColor {
    GREEN(2),
    BLUE(3),
    PURPLE(4),
    RED(5),
    CROWN(6);

    private final int catchRate;

    GrassColor(int catchRate) {
        this.catchRate = catchRate;
    }

    public int getCatchRate() {
        return catchRate;
    }
}