package com.delaroystudios.bus_seat_booking_system;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mugenzi israel on 9/19/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
  public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
      super(context,name,factory,version);
  }

    private static final String TABLE_NAME = "LOGIN";
    static final String DATABASE_CREATE = "CREATE TABLE" + TABLE_NAME + "(" + " ID " + " INTEGER PRIMARY KEY AUTOINCREMENT," + " USERNAME text, PASSWORD text );";
  @Override
    public void onCreate(SQLiteDatabase _db){
     _db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
  }
  @Override
    public void onUpgrade(SQLiteDatabase _db,int _oldVersion,int _newVersion){
     Log.w("TaskDBAdapter","Upgrading from version"+_oldVersion+"to"+_newVersion+
             ",which will destroy all old data") ;
      _db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      onCreate(_db);
  }
}
