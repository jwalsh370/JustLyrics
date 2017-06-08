package com.jahanwalsh.justlyrics.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.ui.ArtistDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseArtistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        View mView;
        Context mContext;

        public FirebaseArtistViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindArtist(Artist artist) {
            TextView lyricTextView = (TextView) mView.findViewById(R.id.lyricTextView);

            lyricTextView.setText(artist.getLyric());
        }

        @Override
        public void onClick(View view) {
            final ArrayList<Artist> artists = new ArrayList<>();
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ARTISTS);
            ref.addListenerForSingleValueEvent(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        artists.add(snapshot.getValue(Artist.class));
                    }

                    int itemPosition = getLayoutPosition();

                    Intent intent = new Intent(mContext, ArtistDetailActivity.class);
                    intent.putExtra("position", itemPosition + "");
                    intent.putExtra("restaurants", Parcels.wrap(artists));

                    mContext.startActivity(intent);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }
    }

