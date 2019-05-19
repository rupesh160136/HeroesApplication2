package com.e.heroesapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GetActivity extends AppCompatActivity {
    private TextView tvdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        tvdata =findViewById(R.id.tvdata);
    }
}
