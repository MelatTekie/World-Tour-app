package edu.mnstate.wy5094ho.finalproject;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class saverpage extends AppCompatActivity {
    private EmpHelper empHelper;
    public static SQLiteDatabase db;
    EditText empName;
    EditText empLName;
    EditText AusV;
    EditText AusL;
    static ArrayList<String> holder = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saverpage);
        empName = (EditText) findViewById(R.id.name);
        empLName = (EditText)findViewById(R.id.lname);
        AusV = (EditText)findViewById(R.id.av);
        AusL = (EditText)findViewById(R.id.al);
        empHelper = new EmpHelper(this);

    }
    public void addEmp(View v) {
        String eName = empName.getText().toString();
        String lName = empLName.getText().toString();
        String ASV = AusV.getText().toString();
        String ASl = AusL.getText().toString();
        db = empHelper.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(empHelper.EMPNAME, eName);
        cVals.put(empHelper.EMPADDRESS, lName);
        cVals.put(empHelper.YES, ASV);
        cVals.put(empHelper.NO, ASl);
        long id = db.insert(empHelper.TABLE_NAME, null, cVals);
        if (id > 0) {
            Message.message(this, "sucess - added to db ");


            db = empHelper.getReadableDatabase();
            Cursor cs = db.rawQuery("SELECT empName, empAddress, yes, no FROM empTable", null);
            try {
                holder.clear();
                if (cs != null) {
                    if (cs.moveToFirst()) {
                        String em = cs.getString(cs.getColumnIndex("empName"));
                        String em1 = cs.getString(cs.getColumnIndex("empAddress"));
                        String em2 = cs.getString(cs.getColumnIndex("yes"));
                        String em3 = cs.getString(cs.getColumnIndex("no"));
                        holder.add(em +" " + em1+" "+ em2+" "+em3);
                        while(cs.moveToNext())
                        {
                            em = cs.getString(cs.getColumnIndex("empName"));
                            em1 = cs.getString(cs.getColumnIndex("empAddress"));
                          em2 = cs.getString(cs.getColumnIndex("yes"));
                             em3 = cs.getString(cs.getColumnIndex("no"));
                            holder.add(em +" " + em1+" "+ em2+" "+em3);
                        }

                    }
                }
            } finally {
                cs.close();
            }
        } else

        {
            Message.message(this, "unsucessful--no add");


        }
    }

}