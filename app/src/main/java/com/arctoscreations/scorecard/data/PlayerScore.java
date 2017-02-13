package com.arctoscreations.scorecard.data;

import io.realm.RealmObject;

/**
 * Created by Billy Groves on 2/13/2017.
 */

public class PlayerScore extends RealmObject {

    private int scoreId;
    private Player playerId;
    private Game gameId;
    private int score;

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
