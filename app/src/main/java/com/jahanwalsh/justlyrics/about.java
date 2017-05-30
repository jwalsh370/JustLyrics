package com.jahanwalsh.justlyrics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;



public class About extends AppCompatActivity {
    @Bind(R.id.aboutButton)
    Button mAboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

//        mAboutButton.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//        if(v == mAboutButton) {
//            Intent intent = new Intent(About.this, MainActivity.class);
//            startActivity(intent);
//        }
//    }
}
