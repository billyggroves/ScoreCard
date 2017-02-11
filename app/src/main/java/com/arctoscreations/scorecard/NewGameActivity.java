package com.arctoscreations.scorecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class NewGameActivity extends AppCompatActivity {
    EditText etPlayer1, etPlayer2, etPlayer3, etPlayer4, etPlayer5, etPlayer6, etPlayer7,
             etPlayer8, etPlayer9, etPlayer10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        Spinner spNumPlayers = (Spinner) findViewById(R.id.ddlNumPlayers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numPlayers, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumPlayers.setAdapter(adapter);
        etPlayer1 = (EditText) findViewById(R.id.etxtPlayer1);
        etPlayer2 = (EditText) findViewById(R.id.etxtPlayer2);
        etPlayer3 = (EditText) findViewById(R.id.etxtPlayer3);
        etPlayer4 = (EditText) findViewById(R.id.etxtPlayer4);
        etPlayer5 = (EditText) findViewById(R.id.etxtPlayer5);
        etPlayer6 = (EditText) findViewById(R.id.etxtPlayer6);
        etPlayer7 = (EditText) findViewById(R.id.etxtPlayer7);
        etPlayer8 = (EditText) findViewById(R.id.etxtPlayer8);
        etPlayer9 = (EditText) findViewById(R.id.etxtPlayer9);
        etPlayer10 = (EditText) findViewById(R.id.etxtPlayer10);

        spNumPlayers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        etPlayer1.setVisibility(View.VISIBLE);
                        etPlayer2.setVisibility(View.VISIBLE);
                        etPlayer3.setVisibility(View.INVISIBLE);
                        etPlayer4.setVisibility(View.INVISIBLE);
                        etPlayer5.setVisibility(View.INVISIBLE);
                        etPlayer6.setVisibility(View.INVISIBLE);
                        etPlayer7.setVisibility(View.INVISIBLE);
                        etPlayer8.setVisibility(View.INVISIBLE);
                        etPlayer9.setVisibility(View.INVISIBLE);
                        etPlayer10.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        etPlayer1.setVisibility(View.VISIBLE);
                        etPlayer2.setVisibility(View.VISIBLE);
                        etPlayer3.setVisibility(View.VISIBLE);
                        etPlayer4.setVisibility(View.INVISIBLE);
                        etPlayer5.setVisibility(View.INVISIBLE);
                        etPlayer6.setVisibility(View.INVISIBLE);
                        etPlayer7.setVisibility(View.INVISIBLE);
                        etPlayer8.setVisibility(View.INVISIBLE);
                        etPlayer9.setVisibility(View.INVISIBLE);
                        etPlayer10.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        etPlayer1.setVisibility(View.VISIBLE);
                        etPlayer2.setVisibility(View.VISIBLE);
                        etPlayer3.setVisibility(View.VISIBLE);
                        etPlayer4.setVisibility(View.VISIBLE);
                        etPlayer5.setVisibility(View.INVISIBLE);
                        etPlayer6.setVisibility(View.INVISIBLE);
                        etPlayer7.setVisibility(View.INVISIBLE);
                        etPlayer8.setVisibility(View.INVISIBLE);
                        etPlayer9.setVisibility(View.INVISIBLE);
                        etPlayer10.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        etPlayer1.setVisibility(View.VISIBLE);
                        etPlayer2.setVisibility(View.VISIBLE);
                        etPlayer3.setVisibility(View.VISIBLE);
                        etPlayer4.setVisibility(View.VISIBLE);
                        etPlayer5.setVisibility(View.VISIBLE);
                        etPlayer6.setVisibility(View.INVISIBLE);
                        etPlayer7.setVisibility(View.INVISIBLE);
                        etPlayer8.setVisibility(View.INVISIBLE);
                        etPlayer9.setVisibility(View.INVISIBLE);
                        etPlayer10.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        etPlayer1.setVisibility(View.VISIBLE);
                        etPlayer2.setVisibility(View.VISIBLE);
                        etPlayer3.setVisibility(View.VISIBLE);
                        etPlayer4.setVisibility(View.VISIBLE);
                        etPlayer5.setVisibility(View.VISIBLE);
                        etPlayer6.setVisibility(View.VISIBLE);
                        etPlayer7.setVisibility(View.INVISIBLE);
                        etPlayer8.setVisibility(View.INVISIBLE);
                        etPlayer9.setVisibility(View.INVISIBLE);
                        etPlayer10.setVisibility(View.INVISIBLE);
                        break;
                    case 5:
                        etPlayer1.setVisibility(View.VISIBLE);
                        etPlayer2.setVisibility(View.VISIBLE);
                        etPlayer3.setVisibility(View.VISIBLE);
                        etPlayer4.setVisibility(View.VISIBLE);
                        etPlayer5.setVisibility(View.VISIBLE);
                        etPlayer6.setVisibility(View.VISIBLE);
                        etPlayer7.setVisibility(View.VISIBLE);
                        etPlayer8.setVisibility(View.INVISIBLE);
                        etPlayer9.setVisibility(View.INVISIBLE);
                        etPlayer10.setVisibility(View.INVISIBLE);
                        break;
                    case 6:
                        etPlayer1.setVisibility(View.VISIBLE);
                        etPlayer2.setVisibility(View.VISIBLE);
                        etPlayer3.setVisibility(View.VISIBLE);
                        etPlayer4.setVisibility(View.VISIBLE);
                        etPlayer5.setVisibility(View.VISIBLE);
                        etPlayer6.setVisibility(View.VISIBLE);
                        etPlayer7.setVisibility(View.VISIBLE);
                        etPlayer8.setVisibility(View.VISIBLE);
                        etPlayer9.setVisibility(View.INVISIBLE);
                        etPlayer10.setVisibility(View.INVISIBLE);
                        break;
                    case 7:
                        etPlayer1.setVisibility(View.VISIBLE);
                        etPlayer2.setVisibility(View.VISIBLE);
                        etPlayer3.setVisibility(View.VISIBLE);
                        etPlayer4.setVisibility(View.VISIBLE);
                        etPlayer5.setVisibility(View.VISIBLE);
                        etPlayer6.setVisibility(View.VISIBLE);
                        etPlayer7.setVisibility(View.VISIBLE);
                        etPlayer8.setVisibility(View.VISIBLE);
                        etPlayer9.setVisibility(View.VISIBLE);
                        etPlayer10.setVisibility(View.INVISIBLE);
                        break;
                    case 8:
                        etPlayer1.setVisibility(View.VISIBLE);
                        etPlayer2.setVisibility(View.VISIBLE);
                        etPlayer3.setVisibility(View.VISIBLE);
                        etPlayer4.setVisibility(View.VISIBLE);
                        etPlayer5.setVisibility(View.VISIBLE);
                        etPlayer6.setVisibility(View.VISIBLE);
                        etPlayer7.setVisibility(View.VISIBLE);
                        etPlayer8.setVisibility(View.VISIBLE);
                        etPlayer9.setVisibility(View.VISIBLE);
                        etPlayer10.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
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

