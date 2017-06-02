package com.jahanwalsh.justlyrics.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.models.Artist;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.ArtistViewHolder> {
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


    public class ArtistViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.artistImageView)
        ImageView mArtistImageView;
        @Bind(R.id.artistNameTextView)
        TextView mNameTextView;
        @Bind(R.id.songTextView)
        TextView mSongTextView;
        @Bind(R.id.lyricTextView)
        TextView mLyricTextView;

        private Context mContext;

        public ArtistViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindArtist(Artist artist) {
            mNameTextView.setText(artist.getName());
//            mSongTextView.setText(artist.getName().get(0));
//            mLyricTextView.setText("Lyric: " + artist.getLyric());
        }
    }
}
