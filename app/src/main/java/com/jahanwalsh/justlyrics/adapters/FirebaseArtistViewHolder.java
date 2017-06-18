package com.jahanwalsh.justlyrics.adapters;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
<<<<<<< HEAD
import android.widget.ImageButton;
=======
>>>>>>> 43ef0b79d0064aec66feceb926a2ac4a08441d5b
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.ui.ArtistDetailActivity;
import com.jahanwalsh.justlyrics.ui.MainActivity;
import com.jahanwalsh.justlyrics.util.ItemTouchHelperAdapter;
import com.jahanwalsh.justlyrics.util.ItemTouchHelperViewHolder;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseArtistViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

<<<<<<< HEAD

=======
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
>>>>>>> 43ef0b79d0064aec66feceb926a2ac4a08441d5b

    public ImageView mAlbumImageView;


        View mView;
        Context mContext;

        public FirebaseArtistViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mContext = itemView.getContext();
        }

        public void bindArtist(Artist artist) {
            TextView lyricTextView = (TextView) mView.findViewById(R.id.lyricTextView);
<<<<<<< HEAD
            ImageView albumImageView = (ImageView) mView.findViewById(R.id.albumImageView);

            lyricTextView.setText(artist.getLyric());

        }

=======
            mAlbumImageView = (ImageView) mView.findViewById(R.id.albumArtImageView);
            TextView nameTextView = (TextView) mView.findViewById(R.id.artistNameTextView);
            TextView trackTextView = (TextView) mView.findViewById(R.id.trackTextView);

//            Picasso.with(mContext)
////                    .load(artist.getImageUrl())
//                    .resize(MAX_WIDTH, MAX_HEIGHT)
//                    .centerCrop()
//                    .into(mAlbumImageView);

            lyricTextView.setText(artist.getLyric());
//            nameTextView.setText(artist.getName());
//            trackTextView.setText(artist.gettrack());


        }

//        @Override
//        public void onClick(View view) {
//            final ArrayList<Artist> artists = new ArrayList<>();
//            DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ARTISTS);
//            ref.addListenerForSingleValueEvent(new ValueEventListener() {
//
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                        artists.add(snapshot.getValue(Artist.class));
//                    }
//
//                    int itemPosition = getLayoutPosition();
//
//                    Intent intent = new Intent(mContext, ArtistDetailActivity.class);
//                    intent.putExtra("position", itemPosition);
//                    intent.putExtra("artists", Parcels.wrap(artists));
//                    mContext.startActivity(intent);
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//                }
//            });
//        }

>>>>>>> 43ef0b79d0064aec66feceb926a2ac4a08441d5b
    @Override
    public void onItemSelected() {
        Log.d("Animation", "onItemSelected");

        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.drag_scale_on);
        set.setTarget(itemView);
        set.start();
    }

    @Override
    public void onItemClear() {
        Log.d("Animation", "onItemClear");

        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.drag_scale_off);
        set.setTarget(itemView);
        set.start();
    }


}

