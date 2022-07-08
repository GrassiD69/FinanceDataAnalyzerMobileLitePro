package com.example.financedataanalyzermobilelitepro.service;

import static java.time.Instant.now;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;

public class stockDataGetter extends Service {
    String symbol;
    Timestamp minDate = new Timestamp(System.currentTimeMillis());

    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        stockDataGetter getService() {
            // Return this instance of LocalService so clients can call public methods
            return stockDataGetter.this;
        }
    }
    public IBinder onBind(Intent intent) {
        return binder;
    }


    public stockDataGetter(String symbol)
    {
        this.symbol = symbol;
    }






}
