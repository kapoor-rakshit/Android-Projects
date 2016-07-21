package rkapoors.loginpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by KAPOOR's on 20-07-2016.
 */
public class LoginAdapter {

    static final String databasename="login.db";
    static final int databaseversion=1;
    public static final int namecolumn=1;

    static final String databasecreate="create table "+"login"+"("+"id"+" integer primary key autoincrement,"+"USERNAME text,PASSWORD text);";

    public SQLiteDatabase db;

    private final Context ct;

    private databasehelper dbhelper;
    public LoginAdapter(Context _ct)
    {
        ct=_ct;
        dbhelper=new databasehelper(ct,databasename,null,databaseversion);
    }
    public LoginAdapter open() throws SQLiteException
    {
        db=dbhelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }
    public SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }
    public void insertentry(String user,String pass)
    {
        ContentValues newval=new ContentValues();

        newval.put("USERNAME",user);
        newval.put("PASSWORD",pass);

        db.insert("login",null,newval);
    }
    public void deleteentry(String user)
    {
        String where="USERNAME=?";
        db.delete("login",where,new String[]{user});
    }
    public String getPassword(String user)
    {
        Cursor cr=db.query("login",null,"USERNAME=?",new String[]{user},null,null,null);
        if(cr.getCount()<1)
        {
            cr.close();
            return "not exist";
        }
        cr.moveToFirst();
        String pass=cr.getString(cr.getColumnIndex("PASSWORD"));
        cr.close();
        return pass;
    }
    public void updateentry(String user,String pass)
    {
        ContentValues updateval=new ContentValues();

        updateval.put("USERNAME",user);
        updateval.put("PASSWORD",pass);

        String where="USERNAME=?";
        db.update("login",updateval,where,new String[]{user});
    }
}
