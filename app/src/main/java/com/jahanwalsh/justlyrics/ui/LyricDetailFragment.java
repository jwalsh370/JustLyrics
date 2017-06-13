package com.jahanwalsh.justlyrics.ui;

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

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jahanwalsh on 6/13/17.
 */

public class LyricDetailFragment extends Fragment   {

    @Bind(R.id.lyricTextView)
    TextView mLyricLabel;


    private Lyric mLyrics;

    public static LyricDetailFragment newInstance(Lyric lyric) {
        LyricDetailFragment lyricDetailFragment = new LyricDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("artist", Parcels.wrap(lyric));
        lyricDetailFragment.setArguments(args);
        return lyricDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLyrics = Parcels.unwrap(getArguments().getParcelable("lyric"));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artist_detail, container, false);
        ButterKnife.bind(this, view);




        mLyricLabel.setText(mLyrics.getLyric());
        return view;
    }


}
