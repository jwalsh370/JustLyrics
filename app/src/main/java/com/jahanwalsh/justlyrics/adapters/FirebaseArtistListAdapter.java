package com.jahanwalsh.justlyrics.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.ui.ArtistDetailActivity;
import com.jahanwalsh.justlyrics.util.ItemTouchHelperAdapter;
import com.jahanwalsh.justlyrics.util.OnStartDragListener;
import org.parceler.Parcels;
import java.util.ArrayList;
import java.util.Collections;

public class FirebaseArtistListAdapter extends FirebaseRecyclerAdapter<Artist, FirebaseArtistViewHolder> implements ItemTouchHelperAdapter {

    private DatabaseReference mRef;
    private ChildEventListener mChildEventListener;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ArrayList<Artist> mArtists = new ArrayList<>();



    public FirebaseArtistListAdapter(Class<Artist> modelClass, int modelLayout,
                                     Class<FirebaseArtistViewHolder> viewHolderClass,
                                     Query ref, OnStartDragListener onStartDragListener, Context context) {

        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mArtists.add(dataSnapshot.getValue(Artist.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mArtists, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        mArtists.remove(position);
        getRef(position).removeValue();

    }

    private void setIndexInFirebase() {
        for (Artist artist : mArtists) {
            int index = mArtists.indexOf(artist);
            DatabaseReference ref = getRef(index);
            artist.setIndex(Integer.toString(index));
            ref.setValue(artist);
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        setIndexInFirebase();
        mRef.removeEventListener(mChildEventListener);
    }

    @Override
    protected void populateViewHolder(final FirebaseArtistViewHolder viewHolder, Artist model, int position) {
        viewHolder.bindArtist(model);

        viewHolder.mLyricTextView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }

        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ArtistDetailActivity.class);
                intent.putExtra("position", viewHolder.getAdapterPosition());
                intent.putExtra("artists", Parcels.wrap(mArtists));
                mContext.startActivity(intent);
            }
        });

    }

        }

