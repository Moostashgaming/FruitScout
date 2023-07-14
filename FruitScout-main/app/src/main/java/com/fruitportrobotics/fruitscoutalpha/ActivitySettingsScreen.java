package com.fruitportrobotics.fruitscoutalpha;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import androidx.room.Room;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;


public class ActivitySettingsScreen extends ActivityTitleScreen {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

        // Gets Layout Inflater and inflates the view
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View questionCreationPopupView = inflater.inflate(R.layout.questioncreation_popup_window, null);
        View quesCreateLay = inflater.inflate(R.layout.questioncreation_popup_window, null);

        Button backButtonSettings = findViewById(R.id.backButtonSettings);
        Button addQuestionButton = findViewById(R.id.addQuestionButton);

        ChipGroup questionTypeChipGroup = (ChipGroup) quesCreateLay.findViewById(R.id.questionTypeChipGroup);

        Chip typeSlider = (Chip) quesCreateLay.findViewById(R.id.typeSliderChip);
        Chip typeMultiChoice = (Chip) quesCreateLay.findViewById(R.id.typeCheckboxChip);
        Chip typeShortRes = (Chip) quesCreateLay.findViewById(R.id.typeShortResponseChip);

        EditText quesContent = (EditText) quesCreateLay.findViewById(R.id.enterQuestionEditText);
        EditText quesId = (EditText) quesCreateLay.findViewById(R.id.quesIdEdTxt);
        EditText sliderMin = (EditText) quesCreateLay.findViewById(R.id.sldrMinEdTxt);
        EditText sliderMax = (EditText) quesCreateLay.findViewById(R.id.sldrMaxEdTxt);

        // Builds instance of app database
        Data.AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                Data.AppDatabase.class, "AppDatabase").build();
        // DAO for operations with the AppDatabase
        UserDao userDao = db.userDao();

        // Creating the Popupwindow
        PopupWindow popupWindow = new PopupWindow(
                questionCreationPopupView,
                // Width
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                // Height
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                true
            );

        addQuestionButton.setOnClickListener(view -> {
            // Shows popup window
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        });

            backButtonSettings.setOnClickListener(view ->{
                switchActivity(ActivityTitleScreen.class, true);
            });

            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    userDao.insertAllQs(
                            quesCreate(
                                    quesId.getText().toString(),
                                    quesContent.getText().toString(),
                                    questionTypeChipGroup.getCheckedChipId())
                    );
                     switch (questionTypeChipGroup.getCheckedChipId()) {
                         // Slider
                         case 1000038:
                             userDao.insertAllSlideAttrs(
                                     new Data.Question.SliderAttrs(
                                             quesId.getText().toString(),
                                             Double.parseDouble(sliderMax.getText().toString()),
                                             Double.parseDouble((sliderMin.getText().toString())))
                             );
                             break;
                         // Multiple Choice
                         case 1000007:

                             break;
                         // Short Response
                         case 1000020:

                             break;

                     }
                }
            });

    }
}