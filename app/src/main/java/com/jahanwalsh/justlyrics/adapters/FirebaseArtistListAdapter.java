package com.jahanwalsh.justlyrics.adapters;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.util.ItemTouchHelperAdapter;
import com.jahanwalsh.justlyrics.util.OnStartDragListener;

public class FirebaseArtistListAdapter extends FirebaseRecyclerAdapter<Artist, FirebaseArtistViewHolder> implements ItemTouchHelperAdapter {

    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseArtistListAdapter(Class<Artist> modelClass, int modelLayout,
                                     Class<FirebaseArtistViewHolder> viewHolderClass,
                                     Query ref, OnStartDragListener onStartDragListener, Context context) {

        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void populateViewHolder(final FirebaseArtistViewHolder viewHolder, Artist model, int position) {
        viewHolder.bindArtist(model);

        viewHolder.mAlbumImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }
}