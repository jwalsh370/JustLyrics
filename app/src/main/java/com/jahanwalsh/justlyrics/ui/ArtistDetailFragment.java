package com.jahanwalsh.justlyrics.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.models.Artist;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ArtistDetailFragment extends Fragment implements View.OnClickListener {

    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    @Bind(R.id.artistNameTextView)
    TextView mNameLabel;
    @Bind(R.id.websiteTextView)
    TextView mWebsiteLabel;
    @Bind(R.id.artistImageView)
    ImageView mImageLabel;
    @Bind(R.id.trackTextView) TextView mTrackLabel;

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

        Picasso.with(view.getContext())
                .load(mArtist.getImg())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mImageLabel);


        mNameLabel.setText(mArtist.getName());
        mTrackLabel.setText(mArtist.getTrack());
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

    }
}