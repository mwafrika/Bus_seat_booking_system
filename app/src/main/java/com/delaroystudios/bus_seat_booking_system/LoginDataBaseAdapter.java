package com.delaroystudios.bus_seat_booking_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mugenzi israel on 9/19/2017.
 */

public class LoginDataBaseAdapter {
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME ="LOGIN";
    public static final int NAME_COLUMN = 1;

    //static final String createDB = "create table login(id integer primary key,username text autoincrement,password text)";
  static final String DATABASE_CREATE = " CREATE TABLE " + TABLE_NAME + "(" + " ID " + " INTEGER PRIMARY KEY AUTOINCREMENT," + " USERNAME text, PASSWORD text );";
    public SQLiteDatabase db;
    private Context context ;
    private DataBaseHelper dbHelper;
    public LoginDataBaseAdapter(Context _context){
        Context context;
        context = _context;
        dbHelper = new DataBaseHelper(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
  public LoginDataBaseAdapter open() throws SQLException{
      db = dbHelper.getWritableDatabase();
      return this;
  }
  public void close(){
      db.close();
  }
  public SQLiteDatabase getDatabaseInstance(){

      return db;
  }
  public  void insertEntry(String userName,String password){
      ContentValues newValues = new ContentValues();
      newValues.put("USERNAME",userName);
      newValues.put("PASSWORD",password);
      db.insert("LOGIN",null,newValues);
  }
  public int deleteEntry(String UserName){
      String where = "USERNAME=?";
      int numberOFEntriesDeleted;
      numberOFEntriesDeleted = db.delete(
              "LOGIN",where, new String[]{
                      UserName}
      );
      return numberOFEntriesDeleted;
  }

  public String getSingleEntry(String userName){
     Cursor cursor = db.query("LOGIN",null,"USERNAME=?",new  String[]{userName},null,null,null);
      if(cursor.getCount()<1){
          cursor.close();
          return "NOT EXIST";
      }
      cursor.moveToFirst();
      String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
      cursor.close();
      return password;
  }
  public void updateEntry(String userName,String password){
      ContentValues updatedValues = new ContentValues();
      updatedValues.put("USERNAME",userName);
      updatedValues.put("PASSWORD",password);
      String where = "USERNAME = ?";
      db.update("LOGIN",updatedValues,where,new String[]{userName});
  }
}
