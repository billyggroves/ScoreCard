package com.arctoscreations.scorecard.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Billy Groves on 3/10/2017.
 */

public class Player extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private RealmList<Score> value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public RealmList<Score> getValue() {
        return value;
    }

    public void setValue(RealmList<Score> value) {
        this.value = value;
    }
}
