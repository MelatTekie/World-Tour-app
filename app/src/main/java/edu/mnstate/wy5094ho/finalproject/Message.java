package edu.mnstate.wy5094ho.finalproject;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wy5094ho on 11/12/2017.
 */

public class Message {
    public static void message(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
