package com.jahanwalsh.justlyrics.adapters;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.util.ItemTouchHelperViewHolder;

public class FirebaseArtistViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {



    public ImageView mLyricTextView;


        View mView;
        Context mContext;

        public FirebaseArtistViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mContext = itemView.getContext();
        }

        public void bindArtist(Artist artist) {
            TextView lyricTextView = (TextView) mView.findViewById(R.id.lyricTextView);
            ImageView dragIcon = (ImageView) mView.findViewById(R.id.dragIcon);

            lyricTextView.setText(artist.getLyric());

        }

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

