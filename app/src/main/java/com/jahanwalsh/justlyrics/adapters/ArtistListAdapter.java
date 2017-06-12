package com.jahanwalsh.justlyrics.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.ui.ArtistDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;


public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.ArtistViewHolder> {
    @Bind(R.id.saveArtistButton)
    Button mSaveArtistButton;



    private ArrayList<Artist> mArtists = new ArrayList<>();
    private Context mContext;

    public ArtistListAdapter(Context context, ArrayList<Artist> artists) {
        mContext = context;
        mArtists = artists;
    }

    @Override
    public ArtistListAdapter.ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_list, parent, false);
        ArtistViewHolder viewHolder = new ArtistViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ArtistListAdapter.ArtistViewHolder holder, int position) {
        holder.bindArtist(mArtists.get(position));
    }

    @Override
    public int getItemCount() {

        return mArtists.size();
    }


    public class ArtistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.lyricTextView)
        TextView mLyricTextView;

        private Context mContext;

        public ArtistViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }



        public void bindArtist(Artist artist) {

            mLyricTextView.setText(artist.getLyric());
        }

        @Override
        public void onClick(View v) {
            Log.d("click listener", "working");
            int itemPosition = getLayoutPosition();


            Intent intent = new Intent(mContext, ArtistDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("artist", Parcels.wrap(mArtists));
            mContext.startActivity(intent);
            Artist artist = mArtists.get(itemPosition);
            Log.i("TestArtist", artist.getLyric());



            }
        }

    }

