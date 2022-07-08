package com.example.financedataanalyzermobilelitepro.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.financedataanalyzermobilelitepro.R;
import com.example.financedataanalyzermobilelitepro.model.Stock;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Damian Grassi
 * 07.07.2022
 * Main class which shows a list of stock using a csv which contains the S&P 500 stocks
 */
public class MainActivity extends AppCompatActivity {
    ArrayList<Stock> stocks;
    InputStream inputStream = new InputStream() {
        @Override
        public int read() throws IOException {
            return 0;
        }
    };
    LinearLayout buttonLayout;
    LinearLayout linear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLayout = findViewById(R.id.buttonLayout);
        linear = findViewById(R.id.linearLayout);
        Button button = findViewById(R.id.button3);


        read();
        addButtons();


    }

    public void read(){

        stocks = new ArrayList<>();
        try {
            Resources res = getResources();
            InputStream inputStream = res.openRawResource(R.raw.constituents);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            CSVReader reader = new CSVReader(inputStreamReader);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                stocks.add(new Stock(nextLine[0],nextLine[1],nextLine[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
        }
    }

    //code from stack overflow https://stackoverflow.com/questions/11710200/android-programmatically-adding-buttons-to-a-layout
    public void addButtons(){

        for (int i = 0; i < stocks.size(); i++) {
            Button btn = new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            btn.setText(stocks.get(i).getName());
            btn.setId(i);
            buttonLayout.addView(btn);

            final Stock stock = stocks.get(i);

            btn.setOnClickListener(v -> {

                Intent send = new Intent(getApplicationContext(), StockActivity.class);
                send.putExtra("stock", stock);
                startActivity(send);

            });

        }
    }




}



