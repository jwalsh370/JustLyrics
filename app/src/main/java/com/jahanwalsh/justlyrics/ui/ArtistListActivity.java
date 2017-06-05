package com.jahanwalsh.justlyrics.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.adapters.ArtistListAdapter;
import com.jahanwalsh.justlyrics.models.Artist;



import java.util.ArrayList;





public class ArtistListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

    }
}