package com.fruitportrobotics.fruitscoutalpha;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

public class Data {
//     Defines a Database entity with a primary key of id and two columns (context and type)
//    @Entity
//    public class Questions {
//        @PrimaryKey
//        @NonNull
//        public String id;
//
//        @ColumnInfo(name = "content")
//        public String content;
//
//        @ColumnInfo(name = "type")
//        public int type;
//    }
    // The DAO used for operations with the Database
    @Entity
    public static class Question {
        @ColumnInfo(name = "content")
        String quesContent;
        @ColumnInfo(name = "type")
        int quesType;
        @PrimaryKey
        @NonNull
        String quesId;
        // Constructor
        public Question(String id, int type, String content) {
            quesType = type;
            quesContent = content;
            quesId = id;
        }

        public Question() {

        }

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
    @Dao
    public interface UserDao {
        @Query("SELECT * FROM question")
        List<Data.Question> getAll();

        @Query("SELECT * FROM question WHERE quesId IN (:quesIds)")
        List<Question> loadAllByIds(String[] quesIds);

        @Query("SELECT * FROM question WHERE quesId LIKE :quesId LIMIT 1")
        Question findByName(String quesId);

//        @Update
//        Questions update(String id);

        @Insert
        void insertAll(Question... questions);

        @Delete
        void delete(Question question);
    }

    @Database(entities = {Question.class}, version = 1)
    public static abstract class AppDatabase extends RoomDatabase {
        public abstract UserDao userDao();
    }

//    public Questions QuestionToQuestions(Question question) {
//        return new Questions;
//    }


}
