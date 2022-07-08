package com.example.financedataanalyzermobilelitepro.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.financedataanalyzermobilelitepro.R;
import com.example.financedataanalyzermobilelitepro.model.Stock;

/**
 * @author Damian Grassi
 * 07.07.2022
 * Class which displays a single stock and its values using a stock object given by the intent.
 */
public class StockActivity extends AppCompatActivity {
    //UI Reference Variable
    TextView stockName;

    public Stock stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        //Get the intent and set the stock by accessing the extras
        Intent intent = getIntent();
        stock = (Stock) intent.getExtras().get("stock");

        //Assign UI reference variables
        stockName = findViewById(R.id.titleBanner);

        stockName.setText(stock.getName());
        TextView r = findViewById(R.id.textView2);
        TextView r2 = findViewById(R.id.textView);
        TextView r3 = findViewById(R.id.textView3);


    }
}