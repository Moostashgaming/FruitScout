package com.fruitportrobotics.fruitscoutalpha;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.lang.reflect.Array;


public class ActivityPopup extends ActivityTitleScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questioncreation_popup_window);

        ChipGroup questionTypeChipGroup = findViewById(R.id.questionTypeChipGroup);
        Chip typeSliderChip = findViewById(R.id.typeSliderChip);
        Chip typeShortResponseChip = findViewById(R.id.typeShortResponseChip);
        Chip typeCheckboxChip = findViewById(R.id.typeCheckboxChip);

        Button doneBtn = findViewById(R.id.doneBtnPop);

        EditText quesContent = findViewById(R.id.enterQuestionEditText);

        doneBtn.setOnClickListener(view -> {
            quesCreate(quesContent.getText().toString(), questionTypeChipGroup.getCheckedChipId());
        });
    }
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