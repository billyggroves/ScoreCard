package com.arctoscreations.scorecard.data;

import io.realm.RealmObject;

/**
 * Created by Billy Groves on 2/13/2017.
 */

public class Participant extends RealmObject {

    private int partId;
    private MatchPlayed matchId;
    private Player playerId;
    private int partScore;

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public MatchPlayed getMatchId() {
        return matchId;
    }

    public void setMatchId(MatchPlayed matchId) {
        this.matchId = matchId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public int getPartScore() {
        return partScore;
    }

    public void setPartScore(int partScore) {
        this.partScore = partScore;
    }
}
