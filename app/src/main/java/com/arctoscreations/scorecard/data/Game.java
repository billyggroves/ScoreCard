package com.arctoscreations.scorecard.data;

import io.realm.RealmObject;

/**
 * Created by Billy Groves on 2/13/2017.
 */

public class Game extends RealmObject {

    private int gameId;
    private String gameName;
    private int minNumPlayers;
    private int maxNumPlayers;

    public int getMinNumPlayers() {
        return minNumPlayers;
    }

    public void setMinNumPlayers(int minNumPlayers) {
        this.minNumPlayers = minNumPlayers;
    }

    public int getMaxNumPlayers() {
        return maxNumPlayers;
    }

    public void setMaxNumPlayers(int maxNumPlayers) {
        this.maxNumPlayers = maxNumPlayers;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
