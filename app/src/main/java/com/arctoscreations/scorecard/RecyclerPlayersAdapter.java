package com.arctoscreations.scorecard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arctoscreations.scorecard.data.Player;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;


/**
 * Created by Billy Groves on 3/27/2017.
 */

public class RecyclerPlayersAdapter extends RealmRecyclerViewAdapter<Player, RecyclerPlayersAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvScore;

        MyViewHolder(final View view){
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvPlayerName);
            tvScore = (TextView) view.findViewById(R.id.tvPlayerScore);
        }
    }

    private LayoutInflater inflater;

    public RecyclerPlayersAdapter(final Context context, final OrderedRealmCollection<Player> realmResults, final boolean automaticUpdate){
        super(realmResults, automaticUpdate);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType){
        View itemView = inflater.inflate(R.layout.custom_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position){
        Player obj = getItem(position);

        holder.tvName.setText(obj.getName());
        holder.tvScore.setText(String.valueOf(obj.getValue().last().getValue()));
    }

}
