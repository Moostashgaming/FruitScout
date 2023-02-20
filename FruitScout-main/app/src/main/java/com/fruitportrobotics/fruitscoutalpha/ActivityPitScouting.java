package com.fruitportrobotics.fruitscoutalpha;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// Could cause problems
public class ActivityPitScouting extends ActivityTitleScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pit_scouting_input_screen);
    }
    // TODO: Alter switch activity method to close activities after checking for unsaved data
    // Switch Activity Method (Creates a switchActiveIntent Intent and starts the activity referenced )
//    public void switchActivity(Class switchTo, boolean finish) {
//        Intent switchActivityIntent = new Intent(this, switchTo);
//        startActivity(switchActivityIntent);
//
//        if (finish) {
//            this.finish();
//        }
//    }
}