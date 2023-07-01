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
        View settingsLay = inflater.inflate(R.layout.settings_screen, null);

        Button backButtonSettings = findViewById(R.id.backButtonSettings);
        Button addQuestionButton = findViewById(R.id.addQuestionButton);
        Button doneBtn = quesCreateLay.findViewById(R.id.doneBtnPop);

        ChipGroup questionTypeChipGroup = quesCreateLay.findViewById(R.id.questionTypeChipGroup);

        EditText quesContent = quesCreateLay.findViewById(R.id.enterQuestionEditText);
        EditText quesId = quesCreateLay.findViewById(R.id.quesIdEdTxt);

        // Builds instance of app database
        Data.AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                Data.AppDatabase.class, "database-name").build();
        // DAO for operations with the AppDatabase
        Data.UserDao userDao = db.userDao();

        // Creating the Popupwindow
        int width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        int height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(questionCreationPopupView, width, height, true);

        addQuestionButton.setOnClickListener(view -> {
            // Shows popup screen
//            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
            popupWindow.showAsDropDown(settingsLay);
        });

            backButtonSettings.setOnClickListener(view ->{
                switchActivity(ActivityTitleScreen.class, true);
            });

            doneBtn.setOnClickListener(view -> {
            // Inserts a question created with all data gathered from popup
                popupWindow.dismiss();
                popupWindow.update();
//            userDao.insertAll(quesCreate(quesId.getText().toString(), quesContent.getText().toString(), questionTypeChipGroup.getCheckedChipId()));


        });

            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    switchActivity(ActivityTitleScreen.class, true);
                }
            });

    }
}