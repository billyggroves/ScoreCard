package com.arctoscreations.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.arctoscreations.scorecard.data.Player;

import io.realm.Realm;
import io.realm.RealmResults;

public class AddScoreActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Realm realm;
    AddScoreRVAdapter adapter;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_score);

        //initiates realm
        realm = Realm.getDefaultInstance();

        //Sets adapter
        setUpAdapter();

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Intent to move back to the ScoreCard Activity
                Intent intent = new Intent(AddScoreActivity.this, ScoreCardActivity.class);
                startActivity(intent);

            }
        });

    }

    private void setUpAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.rvAddScore);
        RealmResults<Player> players = realm.where(Player.class).findAll();
        adapter = new AddScoreRVAdapter(this, players, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        recyclerView.setAdapter(null);
        realm.close();
    }

}
