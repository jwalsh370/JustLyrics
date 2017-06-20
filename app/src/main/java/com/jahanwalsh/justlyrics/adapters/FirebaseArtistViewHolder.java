package com.jahanwalsh.justlyrics.adapters;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.util.ItemTouchHelperViewHolder;

import butterknife.Bind;

public class FirebaseArtistViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {


    public ImageView mImageView;

     View mView;
        Context mContext;

        public FirebaseArtistViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mContext = itemView.getContext();
        }

        public void bindArtist(Artist artist) {
            TextView lyricTextView = (TextView) mView.findViewById(R.id.lyricTextView);

            mImageView = (ImageView) mView.findViewById(R.id.imageView);

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

