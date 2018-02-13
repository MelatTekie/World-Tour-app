package edu.mnstate.wy5094ho.finalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class continent extends AppCompatActivity {
    private FrameLayout content;
    private Button lab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continent);
        content = (FrameLayout)findViewById(R.id.content);
        lab = (Button)findViewById(R.id.tour);

        BottomNavigationView nav = (BottomNavigationView)findViewById(R.id.naviagation);
        nav.setOnNavigationItemSelectedListener(mOnNaviagtionItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, (new sothf()), "fragment_sothf").commit();
        lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(continent.this,MapsActivity.class);
                startActivity(intent);
            }
        });



    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNaviagtionItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.soth:
                            getSupportFragmentManager().beginTransaction().replace(R.id.content, (new sothf()), "fragment_sothf").commit();
                            return true;
                        case R.id.afr:
                            //Toast.makeText(continent.this, "sdfsd", Toast.LENGTH_SHORT).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.content, (new afrif()), "fragment_afrif").commit();
                            return true;
                        case R.id.asi:
                            getSupportFragmentManager().beginTransaction().replace(R.id.content, (new asiaf()), "fragment_asiaf").commit();
                            return true;
                        case R.id.ast:
                            getSupportFragmentManager().beginTransaction().replace(R.id.content, (new austf()), "fragment_austf").commit();
                            return true;
                    }
                    return false;

                }

            };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    Boolean chang=true;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option1:{
                Intent intent = new Intent(continent.this,me.class);
                startActivity(intent);
            }
            return true;
            case R.id.per1:{

                Intent intent = new Intent(continent.this,continent.class);
                startActivity(intent);

            }
            return true;
            case R.id.per2:{

                Intent intent = new Intent(continent.this,Recyclview.class);
                startActivity(intent);

            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





}

