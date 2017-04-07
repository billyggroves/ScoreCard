package com.arctoscreations.scorecard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.arctoscreations.scorecard.data.Player;
import com.arctoscreations.scorecard.data.Score;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by Billy Groves on 4/2/2017.
 */

public class AddScoreRVAdapter extends RealmRecyclerViewAdapter<Player, AddScoreRVAdapter.MyViewHolder> {

    private int position;

    public void updatePosition(int position) {
        this.position = position;
    }

        public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvName;
        TextView tvScore;
        Space space;
        EditText etNewScore;
        Button btnAddScore;
        Realm realm;

        MyViewHolder(final View view){
            super(view);

            realm = Realm.getDefaultInstance();

            tvName = (TextView) view.findViewById(R.id.tvPlayerName);
            tvScore = (TextView) view.findViewById(R.id.tvCurrentScore);
            space = (Space) view.findViewById(R.id.listSpace);
            etNewScore = (EditText) view.findViewById(R.id.etNewPoints);
            clear(view);
            btnAddScore = (Button) view.findViewById(R.id.btnAddScore);
            btnAddScore.setOnClickListener(this);

        }

            @Override
            public void onClick(View v) {
                try {
                    realm.executeTransaction(new Realm.Transaction() {

                        @Override
                        public void execute(Realm realm) {
                            //Converts edittext text to int
                            int newPoints = Integer.valueOf(etNewScore.getText().toString());
                            System.out.println(newPoints);

                            //Converts textview score to int
                            int oldPoints = Integer.valueOf(tvScore.getText().toString());

                            //New score object
                            Score score = new Score();
                            //Adds new points added to the player's current points
                            score.setValue(oldPoints + newPoints);

                            //Finds Player at the position
                            Player player = realm.where(Player.class).equalTo("id", getAdapterPosition() + 1).findFirst();
                            //Adds new score object to player's score RealmList
                            player.getValue().add(score);

                            tvScore.setText(String.valueOf(player.getValue().last().getValue()));
                        }
                    });

                    Toast.makeText(v.getContext(), "You added: " + etNewScore.getText() + " points to "
                            + tvName.getText() + "'s score!", Toast.LENGTH_SHORT).show();

                    clear(v);
                    space.setVisibility(space.GONE);
                    etNewScore.setVisibility(etNewScore.GONE);
                    btnAddScore.setVisibility(btnAddScore.GONE);
                } catch (NumberFormatException ex){
                    Toast.makeText(v.getContext(), "Please enter a value!", Toast.LENGTH_SHORT).show();
                }
            }

            public void clear(View v) {
                etNewScore.setText("");
            }
        }

    private LayoutInflater inflater;

    public AddScoreRVAdapter (final Context context, final OrderedRealmCollection<Player> realmResults, final boolean automaticUpdate){
        super(realmResults, automaticUpdate);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType){
        View itemView = inflater.inflate(R.layout.custom_new_score_list_item, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position){
        Player obj = getItem(position);

        holder.tvName.setText(obj.getFirstName() + " " + obj.getLastName());
        holder.tvScore.setText(String.valueOf(obj.getValue().last().getValue()));
    }

}
