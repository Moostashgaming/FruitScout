package com.fruitportrobotics.fruitscoutalpha;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

    // Dao Definition
    @androidx.room.Dao
    public interface UserDao {
        // --------------------------------------------------------------------
        // Questions
        // --------------------------------------------------------------------
        @Query("SELECT * FROM question")
        List<Data.Question> getAllQs();

        @Query("SELECT * FROM question WHERE quesId IN (:quesIds)")
        List<Data.Question> loadAllQsByIds(String[] quesIds);

        @Query("SELECT * FROM question WHERE quesId LIKE :quesId LIMIT 1")
        Data.Question findQByName(String quesId);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAllQs(Data.Question... questions);

        @Delete
        void deleteQ(Data.Question question);

        // ---------------------------------------------------------------------
        // Slider Attributes
        //----------------------------------------------------------------------
        @Query("SELECT * FROM sliderattrs")
        List<Data.Question.SliderAttrs> getAllSlideAttrs();

        @Query("SELECT * FROM sliderattrs WHERE quesId IN (:quesIds)")
        List<Data.Question.SliderAttrs> loadAllSlideAttrsByIds(String[] quesIds);

        @Query("SELECT * FROM sliderattrs WHERE quesId LIKE :quesId LIMIT 1")
        Data.Question.SliderAttrs findSlideAttrByName(String quesId);

        @Insert (onConflict = OnConflictStrategy.REPLACE)
        void insertAllSlideAttrs(Data.Question.SliderAttrs... attributes);

        @Delete
        void deleteSlideAttr(Data.Question.SliderAttrs attribute);

        // --------------------------------------------------------------------
        // Multi Choice Attributes
        // --------------------------------------------------------------------
        @Query("SELECT * FROM multiattrs")
        List<Data.Question.MultiAttrs> getAllMultiAttrs();

        @Query("SELECT * FROM multiattrs WHERE quesId IN (:quesIds)")
        List<Data.Question.MultiAttrs> loadAllMultiAttrsByIds(String[] quesIds);

        @Query("SELECT * FROM multiattrs WHERE quesId LIKE :quesId LIMIT 1")
        Data.Question.MultiAttrs findMultiAttrByName(String quesId);

        @Insert (onConflict = OnConflictStrategy.REPLACE)
        void insertAllMultiAttrs(Data.Question.MultiAttrs... attributes);

        @Delete
        void deleteMultiAttr(Data.Question.MultiAttrs attribute);

        // --------------------------------------------------------------------
        // Short Answer Attributes
        // --------------------------------------------------------------------

        @Query("SELECT * FROM shortattrs")
        List<Data.Question.ShortAttrs> getAllShortAttrs();

        @Query("SELECT * FROM ShortAttrs WHERE quesId IN (:quesIds)")
        List<Data.Question.ShortAttrs> loadAllShortAttrsByIds(String[] quesIds);

        @Query("SELECT * FROM shortattrs WHERE quesId LIKE :quesId LIMIT 1")
        Data.Question.ShortAttrs findShortAttrByName(String quesId);

        @Insert (onConflict = OnConflictStrategy.REPLACE)
        void insertAllShortAttrs(Data.Question.ShortAttrs... attributes);

        @Delete
        void deleteShortAttr(Data.Question.ShortAttrs attribute);
    }
