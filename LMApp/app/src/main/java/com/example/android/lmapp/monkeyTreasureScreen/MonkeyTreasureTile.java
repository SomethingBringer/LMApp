package com.example.android.lmapp.monkeyTreasureScreen;

public class MonkeyTreasureTile {
    boolean visited;
    boolean occupied;
    boolean viper;
    boolean skorpio;
    boolean treasure;

    public MonkeyTreasureTile(boolean visited, boolean occupied, boolean viper, boolean skorpio, boolean treasure) {
        this.visited = visited;
        this.occupied = occupied;
        this.viper = viper;
        this.skorpio = skorpio;
        this.treasure = treasure;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isViper() {
        return viper;
    }

    public boolean isSkorpio() {
        return skorpio;
    }

    public boolean isTreasure() {
        return treasure;
    }
}
