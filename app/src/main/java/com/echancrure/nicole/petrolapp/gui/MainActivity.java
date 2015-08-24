package com.echancrure.nicole.petrolapp.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.echancrure.nicole.petrolapp.R;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Listener attached to the buttons on the GUI layout
     */
    public void onClick(View view) {
        Log.d(TAG, "onclick received");
        Intent newActivity = null;
        switch (view.getId()) { //depending on the button pressed the correct activity is launched
            case R.id.recordFillUpButton:
                newActivity = new Intent(getApplicationContext(), RecordFillUpActivity.class);
                break;
            default:
                Log.d(TAG, "ignored click event on" + view.getId());
        }
        if (newActivity != null) startActivity(newActivity);
    }
}
