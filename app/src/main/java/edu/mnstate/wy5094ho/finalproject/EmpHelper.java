package edu.mnstate.wy5094ho.finalproject;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wy5094ho on 11/12/2017.
 */

public class EmpHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "emp.db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "empTable";
    public static final String EMPID = "_id";
    public static final String EMPNAME = "empName";
    public static final String EMPADDRESS = "empAddress";
    public static final String NO = "no";
    public static final String YES = "yes";




    private Context context;

    EmpHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        //Message.message(context, "Called the Constructor");
    }
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" + EMPID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    EMPNAME + " VARCHAR(255)," + NO +" VARCHAR(255),"+  YES +" VARCHAR(255),"+EMPADDRESS + " VARCHAR(255));";
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Message.message(context, "onCreate called");
        } catch (SQLException e) {
            Message.message(context, "" + e);
        }
    }
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME;
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Message.message(context, "onUpgrade called");
            db.execSQL("DROP_TABLE" + TABLE_NAME);
            onCreate(db);
        } catch (SQLException e) {
            Message.message(context, "" + e);
        }
    }
}



