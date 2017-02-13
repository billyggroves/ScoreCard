package com.arctoscreations.scorecard.data;

import io.realm.RealmObject;

/**
 * Created by Billy Groves on 2/12/2017.
 */

public class Player extends RealmObject {

    private int playId;
    private String name;

    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
