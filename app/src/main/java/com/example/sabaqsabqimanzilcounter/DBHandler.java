package com.example.sabaqsabqimanzilcounter;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.util.Log;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RecordBase.db";
    private static final String TABLE_NAME = "Students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_datetime = "CDate";
    private static final String COLUMN_StudentName = "CName";
    private static final String COLUMN_StudentSabaq = "CSabaq";
    private static final String COLUMN_StudentSabqi = "CSabqi";
    private static final String COLUMN_StudentManzil = "CManzil";

    private static final String COLUMN_StudentRoll = "CRoll";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"

                + COLUMN_StudentName + " TEXT,"
                + COLUMN_StudentSabaq + " TEXT,"
                + COLUMN_StudentSabqi + " TEXT,"
                + COLUMN_StudentManzil + " TEXT,"
                + COLUMN_StudentRoll + " TEXT,"
                + COLUMN_datetime + " TEXT"
    //            + COLUMN_isCorrect + " INTEGER"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertRecord( RecordClassManipulation qr) {


        String cuurentTime =getSysTime();
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_StudentName, qr.getName());
        values.put(COLUMN_StudentSabaq, qr.getSabaq());
        values.put(COLUMN_StudentSabqi, qr.getSabqi());
        values.put(COLUMN_StudentManzil, qr.getManzil());
        values.put(COLUMN_StudentRoll, qr.getRollNumber() );
        values.put(COLUMN_datetime, cuurentTime );

        db.insert(TABLE_NAME, null, values);
        //db.close();
    }


    public void deleteData() {
        SQLiteDatabase db = this.getWritableDatabase();
        //String sql = "delete from " + TABLE_NAME;
        //Cursor cursor = db.rawQuery(sql, null);
        db.delete(TABLE_NAME, null,null);
        db.close();
    }

    public List<RecordClassManipulation> selectAllresults() {
        List<RecordClassManipulation> totalresult = new ArrayList<>();

        String sql = "select * from " + TABLE_NAME +" order by id DESC"  ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        while(cursor.moveToNext()) {
            String Students=cursor.getString(1);
            String roll=cursor.getString(5);
            //String CA=cursor.getString(2);
            // int isc ;
            totalresult.add(new RecordClassManipulation(Students, "","","",roll ));
        }
        cursor.close();
       // db.close();
        return totalresult;
    }



    public void updateStudent(RecordClassManipulation studentdatachange) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_StudentSabaq, studentdatachange.getSabaq());
        values.put(COLUMN_StudentSabqi, studentdatachange.getSabqi());
        values.put(COLUMN_StudentManzil, studentdatachange.getManzil());



        db.update(TABLE_NAME, values, COLUMN_StudentName + " = ?", new String[] {studentdatachange.getName().toString()});
        db.close();
    }


    public String getSysTime(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String date=dateFormat.format(cal.getTime());
        return date;

    }




    public List<RecordClassManipulation> selectSpccificresults(String rollID) {
        List<RecordClassManipulation> totalresult = new ArrayList<>();

        String sql = "select * from " + TABLE_NAME +" where " + COLUMN_StudentRoll + " = " + "\"" +rollID+ "\""  ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        while(cursor.moveToNext()) {
            String Student=cursor.getString(1);
            String Sabaq=cursor.getString(2);
            String Sabqi=cursor.getString(3);
            String Manzil=cursor.getString(4);
            String roll=cursor.getString(5);
            //String CA=cursor.getString(2);
            // int isc ;
            totalresult.add(new RecordClassManipulation(Student, Sabaq,Sabqi,Manzil,roll ));
        }
        cursor.close();
        // db.close();
        return totalresult;
    }

}
