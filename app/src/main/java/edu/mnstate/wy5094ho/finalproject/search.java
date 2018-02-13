package edu.mnstate.wy5094ho.finalproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class search extends AppCompatActivity {
    private EmpHelper empHelper;
    private SQLiteDatabase db;
    private TextView sa;
    private TextView da;
    saverpage rp = new saverpage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        empHelper = new EmpHelper(this);
        sa = (TextView) findViewById(R.id.most);
        da = (TextView) findViewById(R.id.leadt);

    }

    public void MostLiked(View v){
        saverpage rp = new saverpage();
        db = empHelper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT yes FROM empTable", null);
        try {
            if (cs != null) {
                if (cs.moveToFirst()) {
                    String em2 = cs.getString(cs.getColumnIndex("yes"));
                    sa.append(em2+"\n");

                    while(cs.moveToNext())
                    {
                        em2 = cs.getString(cs.getColumnIndex("yes"));
                        sa.append(em2+"\n");
                    }

                }
            }
        } finally {
            cs.close();
        }


    }

    public void LeastLiked(View v){
        saverpage rp = new saverpage();
        rp.db = empHelper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT empName, empAddress, yes, no FROM empTable", null);
        try {
            if (cs != null) {
                if (cs.moveToFirst()) {
                    String em2 = cs.getString(cs.getColumnIndex("no"));
                    da.append(em2+"\n");

                    while(cs.moveToNext())
                    {
                        em2 = cs.getString(cs.getColumnIndex("no"));
                        da.append(em2+"\n");
                    }

                }
            }
        } finally {
            cs.close();
        }


        }

    }


