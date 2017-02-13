package com.arctoscreations.scorecard.data;

import io.realm.RealmObject;

/**
 * Created by Billy Groves on 2/13/2017.
 */

public class GameUnit extends RealmObject {

    private int gameUnitId;
    private Game gameId;
    private Unit unitId;

    public int getGameUnitId() {
        return gameUnitId;
    }

    public void setGameUnitId(int gameUnitId) {
        this.gameUnitId = gameUnitId;
    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }
}
