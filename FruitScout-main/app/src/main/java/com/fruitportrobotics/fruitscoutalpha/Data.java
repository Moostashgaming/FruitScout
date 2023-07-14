package com.fruitportrobotics.fruitscoutalpha;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;

public class Data {
    @Entity
    public static class Question {
        @ColumnInfo(name = "content")
        String quesContent;
        @ColumnInfo(name = "type")
        int quesType;
        @PrimaryKey
        @NonNull
        String quesId;

        /**
         * Slider question attributes (Data class)
         */
        @Entity
        public static class SliderAttrs {
            @PrimaryKey
            @NonNull
            String quesId;

            @ColumnInfo(name = "slider_max")
            double sliderMaximum;

            @ColumnInfo(name = "slider_min")
            double sliderMinimum;

            /**
             * Constructor used for creating attributes to be stored
             * @param id The id of the question for the attributes to be packaged with
             * @param sliderMax The maximum range of the slider
             * @param sliderMin The minimum range of the slider
             */
            public SliderAttrs(String id, double sliderMax, double sliderMin) {
                quesId = id;
                sliderMaximum = sliderMax;
                sliderMinimum = sliderMin;
            }

            public SliderAttrs(){}
        }

        /**
         * Multiple choice question attributes (Data Class)
         */
        @Entity
        public static class MultiAttrs {
            @PrimaryKey
            @NonNull
            String quesId;

            /**
             * Constructor used for creating attributes to be stored
             * @param id
             */
            public MultiAttrs(String id) {
                quesId = id;
            }

            public MultiAttrs(){}
        }

        /**
         * Short Answer question attributes (Data Class)
         */
        @Entity
        public static class ShortAttrs {
            @PrimaryKey
            @NonNull
            String quesId;

            /**
             * Constructor used for creating attributes to be stored
             * @param id
             */
            public ShortAttrs(String id) {
                quesId = id;
            }

            public ShortAttrs(){}
        }

        /*Constructor for data storage */
        public Question(String id, String content, int type) {
            quesType = type;
            quesContent = content;
            quesId = id;
        }

        public Question() {}

        public static String getString(Data.Question question) {
            return question.quesContent;
        }
        public static int getType(Data.Question question) {
            return question.quesType;
        }

        public static String getId(Data.Question question) {
            return question.quesId;
        }
    }

    // Database Definition
    @Database(entities = {Question.class, Question.SliderAttrs.class, Question.MultiAttrs.class, Question.ShortAttrs.class}, version = 1)
    public static abstract class AppDatabase extends RoomDatabase {
        public abstract UserDao userDao();

        public static final String NAME = "AppDatabase";
    }
}
