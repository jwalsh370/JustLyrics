package com.jahanwalsh.justlyrics.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;

import butterknife.Bind;
import butterknife.ButterKnife;



public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.backButton)
    Button mBackButton;
    @Bind(R.id.urlButton)
    Button mUrlButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        mBackButton.setOnClickListener(this);
    }


    public void onClick(View v) {
        if(v == mBackButton) {
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(intent);
        }

        if(v == mUrlButton) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(Constants.PROJECT_URL));
            startActivity(webIntent);
        }
    }
}
