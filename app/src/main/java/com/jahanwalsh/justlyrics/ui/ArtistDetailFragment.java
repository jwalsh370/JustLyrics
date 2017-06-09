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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.models.Artist;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ArtistDetailFragment extends Fragment  implements View.OnClickListener  {
    @Bind(R.id.artistNameTextView)
    TextView mNameLabel;
    @Bind(R.id.lyricTextView)
    TextView mLyricLabel;
    @Bind(R.id.websiteTextView)
    TextView mWebsiteLabel;
    @Bind(R.id.trackTextView) TextView mTrackLabel;
    @Bind(R.id.saveArtistButton)
    Button mSaveArtistButton;

    private Artist mArtist;

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

        mLyricLabel.setText(mArtist.getLyric());
        mWebsiteLabel.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mArtist.getWebsite()));
            startActivity(webIntent);
        }


        if (v == mSaveArtistButton) {
            DatabaseReference artistRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_ARTISTS);
            artistRef.push().setValue(mArtist);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();

         }
    }
}