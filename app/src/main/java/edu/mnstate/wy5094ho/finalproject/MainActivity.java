/*source: https://www.youtube.com/watch?v=puyiZKvxBa0
        http://abhiandroid.com/ui/videoview
        Wikepedia
        https://en.wikipedia.org/wiki/Peruvian_Amazon
        https://www.google.com/destination/map/topsights?q=SITES+IN+PERU&rlz=1C1CHBF_enUS775US775&site=search&output=search&dest_mid=/m/016wzw&sa=X&ved=0ahUKEwi56JD3zoPYAhWK8YMKHZSkCJ4Q69EBCCgoATAA#trifp=skpm%3D/m/0krfy
       https://www.google.com/destination/map/topsights?q=sites+in+brazil&rlz=1C1CHBF_enUS775US775&site=search&output=search&dest_mid=/m/015fr&sa=X&ved=0ahUKEwjzxfqe1YPYAhUp2oMKHXvKC9UQ6tEBCCwoBTAA#dest_mid=/m/015fr&trifp=skpm%3D/m/03gytw%26t%3De
       https://www.google.com/destination/map/topsights?q=sites+in+south+africa&rlz=1C1CHBF_enUS775US775&site=search&output=search&dest_mid=/m/0hzlz&sa=X&ved=0ahUKEwj7y4f45IPYAhWU14MKHQjJDXIQ69EBCCgoATAA#dest_mid=/m/0hzlz&trifp=skpm%3D/m/0m5sp%26t%3De
Author: Melat Tekie
12/12/2017
Description: This application is used as a Tour guide to learn about and view countries around the world
 */

package edu.mnstate.wy5094ho.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView cont;
    private TextView vis;
    private TextView in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont = (TextView)findViewById(R.id.lbc);
        vis = (TextView)findViewById(R.id.lbv);
        in = (TextView)findViewById(R.id.lbs);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Recyclview.class);
                startActivity(intent);
            }
        });

        vis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,users.class);
                startActivity(intent);
            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,search.class);
                startActivity(intent);
            }
        });

    }
}
