package com.jahanwalsh.justlyrics.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.jahanwalsh.justlyrics.models.Lyric;
import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ArtistDetailFragment extends Fragment  implements View.OnClickListener  {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    @Bind(R.id.lyricTextView)
    TextView mLyricLabel;
    @Bind(R.id.artistNameTextView)
    TextView mNameLabel;
    @Bind(R.id.trackTextView)
    TextView mTrackLabel;
    @Bind(R.id.albumImageView)
    ImageView mImgLabel;

    @Bind(R.id.saveArtistButton)
    Button mSaveArtistButton;

    private Artist mArtist;
    private Lyric mLyrics;

    public static ArtistDetailFragment newInstance(Artist artist) {
        ArtistDetailFragment artistDetailFragment = new ArtistDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("artist", Parcels.wrap(artist));
        artistDetailFragment.setArguments(args);
        return artistDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArtist = Parcels.unwrap(getArguments().getParcelable("artist"));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artist_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mArtist.getAlbumArt())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mImgLabel);


//        mLyricLabel.setText(mLyrics.getLyric());
        mNameLabel.setText(mArtist.getName());
        mTrackLabel.setText(mArtist.getTrack());


        mSaveArtistButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        if (v == mSaveArtistButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();

            DatabaseReference artistRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_ARTISTS)
                    .child(uid);

            DatabaseReference pushRef = artistRef.push();
            String pushId = pushRef.getKey();
            mArtist.setPushId(pushId);
            pushRef.setValue(mArtist);

            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }

    }
}

