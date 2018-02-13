package edu.mnstate.wy5094ho.finalproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class users extends AppCompatActivity {
    private EmpHelper empHelper;
    private SQLiteDatabase db;
    private TextView sa;
    private EditText gt;
    saverpage rp = new saverpage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        empHelper = new EmpHelper(this);
        sa = (TextView) findViewById(R.id.display);
        gt = (EditText)findViewById(R.id.namerr);

        for (int i = 0; i <rp.holder.size() ; i++) {
            sa.append(rp.holder.get(i)+"\n");

        }
    }
    public void deleter(View v) {

        saverpage rp = new saverpage();
        rp.db = empHelper.getWritableDatabase();


        String acName =" ";
        acName = gt.getText().toString();

        rp.db.delete("empTable", "empAddress" + "=" + "'"+acName+"'", null);
        rp.holder.clear();

        db = empHelper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT empName, empAddress FROM empTable", null);
        try {
            rp.holder.clear();
            if (cs != null) {
                if (cs.moveToFirst()) {
                    String em = cs.getString(cs.getColumnIndex("empName"));
                    String em1 = cs.getString(cs.getColumnIndex("empAddress"));
                    rp.holder.add(em +" " + em1);
                    while(cs.moveToNext())
                    {
                        em = cs.getString(cs.getColumnIndex("empName"));
                        em1 = cs.getString(cs.getColumnIndex("empAddress"));

                        rp.holder.add(em +" " + em1);
                    }

                }
            }
        } finally {
            cs.close();
        }
        sa.setText("");
        for (int i = 0; i <rp.holder.size() ; i++) {
            sa.append(rp.holder.get(i)+"\n");

        }


    }
}
