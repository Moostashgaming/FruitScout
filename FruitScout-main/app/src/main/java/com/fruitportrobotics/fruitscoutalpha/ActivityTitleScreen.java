package com.fruitportrobotics.fruitscoutalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTitleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_screen);

        // Creates button objects and attaches the ids
        Button startButton = findViewById(R.id.startButton);
        Button settingsButton = findViewById(R.id.settingsButton);
        // May be removed
        Button dataRetrievalButton = findViewById(R.id.retrieveDataButton);
        TextView titleTextView = findViewById(R.id.titleTextView);

        // Waits until the startButton is pressed and then preforms the code in the curly braces
        startButton.setOnClickListener(view -> {
            // Switches to ActivityScoutingTypeSelection
            switchActivity(ActivityScoutingTypeSelection.class,true);
        });
        // Waits until the button is pressed and then preforms the code in the curly braces
        settingsButton.setOnClickListener(view -> {
            // Switches to ActivitySettingsScreen
            switchActivity(ActivitySettingsScreen.class, true);
        });
        // TODO: May be removed, do not edit until certain
        dataRetrievalButton.setOnClickListener(view -> {

        });
    }
    // Switch Activity Method (Creates a switchActiveIntent Intent and starts the activity referenced )
    public void switchActivity(Class switchTo, Boolean finish) {
        Intent switchActivityIntent = new Intent(this, switchTo);
        startActivity(switchActivityIntent);

        if (finish) {
            this.finish();
        }
    }

    // Creates a question from raw question data for storage
    static Data.Question quesCreate(String id, String content, int type) {
        return new Data.Question(id, content, type);
    }
}