package com.fruitportrobotics.fruitscoutalpha;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class ActivityCreditsScreen extends ActivityTitleScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits_screen);
    }
//    // Switch Activity Method (Creates a switchActivityIntent Intent and starts the activity referenced )
//    public void switchActivity(Class switchTo) {
//        Intent switchActivityIntent = new Intent(this, switchTo);
//        startActivity(switchActivityIntent);
//        // May cause problems
//        this.finish();
//    }
}