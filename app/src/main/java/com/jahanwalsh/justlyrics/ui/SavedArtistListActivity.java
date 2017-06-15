package com.jahanwalsh.justlyrics.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.adapters.FirebaseArtistListAdapter;
import com.jahanwalsh.justlyrics.adapters.FirebaseArtistViewHolder;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.util.OnStartDragListener;
import com.jahanwalsh.justlyrics.util.SimpleItemTouchHelperCallback;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedArtistListActivity extends AppCompatActivity implements OnStartDragListener {

        private DatabaseReference mArtistReference;
        private FirebaseArtistListAdapter mFirebaseAdapter;
        private ItemTouchHelper mItemTouchHelper;

        @Bind(R.id.recyclerView)
        RecyclerView mRecyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_artists);
            ButterKnife.bind(this);

            setUpFirebaseAdapter();
        }

        private void setUpFirebaseAdapter() {

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();

            mArtistReference = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_ARTISTS)
                    .child(uid);

            mFirebaseAdapter = new FirebaseArtistListAdapter(Artist.class, R.layout.artist_list_item_drag, FirebaseArtistViewHolder.class,
                            mArtistReference, this, this);


            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mFirebaseAdapter);

            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);

            mItemTouchHelper = new ItemTouchHelper(callback);
            mItemTouchHelper.attachToRecyclerView(mRecyclerView);

            mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                @Override
                public void onItemRangeInserted(int positionStart, int itemCount) {
                    super.onItemRangeInserted(positionStart, itemCount);
                    mFirebaseAdapter.notifyDataSetChanged();
                }
            });

        }

        @Override
         public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
            mItemTouchHelper.startDrag(viewHolder);
    }


        @Override
          protected void onDestroy() {
            super.onDestroy();
            mFirebaseAdapter.cleanup();
        }


    }