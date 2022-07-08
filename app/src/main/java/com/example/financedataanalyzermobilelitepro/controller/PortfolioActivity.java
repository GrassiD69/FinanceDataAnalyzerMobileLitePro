package com.example.financedataanalyzermobilelitepro.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.financedataanalyzermobilelitepro.R;

public class PortfolioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        Button button = findViewById(R.id.hauptmenu);
        TextView banner = findViewById(R.id.banner);
        LinearLayout layout = findViewById(R.id.linear);
        layout.addView(banner);
        layout.addView(button);

    }
}