package com.arctoscreations.scorecard;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Billy Groves on 3/22/2017.
 */

public class ScoreCardApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
