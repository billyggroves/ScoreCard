package com.arctoscreations.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new_game) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.deleteAll();
                }
            });
            Intent intent = new Intent(AddScoreActivity.this, NewGameActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
