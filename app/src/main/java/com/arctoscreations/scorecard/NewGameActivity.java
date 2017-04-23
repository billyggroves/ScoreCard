package com.arctoscreations.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arctoscreations.scorecard.data.Player;
import com.arctoscreations.scorecard.data.Score;

import io.realm.Realm;

public class NewGameActivity extends AppCompatActivity {
    private Realm realm;
    private Button addUser;
    private EditText first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        addUser = (Button) findViewById(R.id.btnCreateCard);
        first = (EditText) findViewById(R.id.etxtFirstName);

        realm = Realm.getDefaultInstance();

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logs to check the Edit text works
                Log.v("EditText value=", first.getText().toString());
                String name = first.getText().toString();
                if(name.length() > 0 && name.length() <= 20) {
                    // Realm transaction for player
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            long obj = realm.where(Player.class).count();
                            Player player = realm.createObject(Player.class, obj + 1);
                            player.setName(first.getText().toString());

                            Score p1Score = realm.createObject(Score.class);
                            p1Score.setValue(0);

                            player.getValue().add(p1Score);
                        }
                    });

                    // Intent to move on to the ScoreCard Activity
                    Intent intent = new Intent(NewGameActivity.this, ScoreCardActivity.class);
                    startActivity(intent);
                } else if(name.length() == 0){
                    Toast.makeText(NewGameActivity.this, "Please enter a name in the field above!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(NewGameActivity.this, "Please enter a name with less than 20 characters in the field above!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        realm.close();
    }


}

