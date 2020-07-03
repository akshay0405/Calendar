package com.example.calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.calendar.Datalist;

import java.util.ArrayList;


public class Db_handler extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static final String DB_NAME="Eventdetail";
    private static final String TABLE_N="Event";
    private static final String EDate="date";
    private static final String DESC="desc";
    private static final String Title="title";


    public  Db_handler(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override

    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE "+TABLE_N+"("+EDate+" INTEGER,"+DESC+" TEXT,"+Title+" TEXT"+")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_N);
        onCreate(db);

    }
    //crud
  public void insertevent(Long date,String desc,String title){
        SQLiteDatabase database=this.getWritableDatabase();
      ContentValues contentValues=new ContentValues();
      contentValues.put(EDate,date);
      contentValues.put(DESC,desc);
      contentValues.put(DESC,title);
      database.insert(TABLE_N,null,contentValues);
      database.close();

  }
    public ArrayList<Datalist> Getevent(Long date1){
        SQLiteDatabase database=this.getWritableDatabase();
        ArrayList<Datalist> datalists2=new ArrayList<>();
        String query="SELECT desc,title FROM Event WHERE date="+date1;
        Cursor cursor=database.rawQuery(query,null);
        while (cursor.moveToNext()){
            Datalist datalist=new Datalist(1,cursor.getString(cursor.getColumnIndex(DESC)),cursor.getString(cursor.getColumnIndex(Title)));

            datalists2.add(datalist);
        }
        return datalists2;
    }

}
