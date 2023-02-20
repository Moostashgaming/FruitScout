package com.fruitportrobotics.fruitscoutalpha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class ActivityScoutingTypeSelection extends ActivityTitleScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scouting_type_input_screen);

        // Creates button objects and attaches the ids
        Button pitScoutingButton = findViewById(R.id.pitScoutingButton);
        Button matchScoutingButton = findViewById(R.id.matchScoutingButton);
        Button backButton = findViewById(R.id.backButtonScoutingSelection);

        pitScoutingButton.setOnClickListener(view -> {
        // Switches to ActivityPitScouting
        switchActivity(ActivityPitScouting.class, true);
        });

        matchScoutingButton.setOnClickListener(view -> switchActivity(ActivityMatchScouting.class, true));

        backButton.setOnClickListener(view -> switchActivity(ActivityTitleScreen.class, true));
    }

//      // Switch Activity Method (Creates a switchActiveIntent Intent and starts the activity referenced)
//    public void switchActivity(Class switchTo) {
//        Intent switchActivityIntent = new Intent(this, switchTo);
//        startActivity(switchActivityIntent);
//        // May cause problems
//        this.finish();
//    }
}