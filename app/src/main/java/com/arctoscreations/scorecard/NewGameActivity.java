package com.arctoscreations.scorecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.arctoscreations.scorecard.data.Player;
import com.arctoscreations.scorecard.data.Score;
import io.realm.Realm;

public class NewGameActivity extends AppCompatActivity {
    private Realm realm;
    private Button addUser;
    private EditText first;
    private EditText last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        addUser = (Button) findViewById(R.id.btnCreateCard);
        first = (EditText) findViewById(R.id.etxtFirstName);
        last = (EditText) findViewById(R.id.etxtLastName);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logs to check the Edit text works
                Log.v("EditText value=", first.getText().toString() + " " + last.getText().toString());

                // Realm transaction for player 1
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Player player = realm.createObject(Player.class);
                        player.setId(1);
                        player.setFirstName(first.getText().toString());
                        player.setLastName(last.getText().toString());

                        Score p1Score = realm.createObject(Score.class);
                        p1Score.setId(1);
                        p1Score.setValue(0);

                        player.getValue().add(p1Score);
                    }
                });

                // Intent to move on to the ScoreCard Activity


            }
        });

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

