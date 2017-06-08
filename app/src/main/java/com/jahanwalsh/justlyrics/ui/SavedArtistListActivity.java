package com.jahanwalsh.justlyrics.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.adapters.FirebaseArtistViewHolder;
import com.jahanwalsh.justlyrics.models.Artist;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedArtistListActivity extends AppCompatActivity {

        private DatabaseReference mArtistReference;
        private FirebaseRecyclerAdapter mFirebaseAdapter;

        @Bind(R.id.recyclerView)
        RecyclerView mRecyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.artist_activity);
            ButterKnife.bind(this);

            mArtistReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ARTISTS);
            setUpFirebaseAdapter();
        }

        private void setUpFirebaseAdapter() {
            mFirebaseAdapter = new FirebaseRecyclerAdapter<Artist, FirebaseArtistViewHolder>
                    (Artist.class, R.layout.artist_list, FirebaseArtistViewHolder.class,
                            mArtistReference) {

                @Override
                protected void populateViewHolder(FirebaseArtistViewHolder viewHolder,
                                                  Artist model, int position) {
                    viewHolder.bindArtist(model);
                }
            };
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mFirebaseAdapter);
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            mFirebaseAdapter.cleanup();
        }
    }