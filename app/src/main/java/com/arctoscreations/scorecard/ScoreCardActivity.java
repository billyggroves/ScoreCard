package com.arctoscreations.scorecard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.arctoscreations.scorecard.data.Player;

import io.realm.Realm;
import io.realm.RealmResults;


public class ScoreCardActivity extends AppCompatActivity {
    private Realm realm;
    private RecyclerView recyclerView;
    private RecyclerPlayersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();

        recyclerView = (RecyclerView) findViewById(R.id.rvPlayers);
        RealmResults<Player> players = realm.where(Player.class).findAll();
        adapter = new RecyclerPlayersAdapter(this, players, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddPlayer);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "add player", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        recyclerView.setAdapter(null);
        realm.close();
    }


}
