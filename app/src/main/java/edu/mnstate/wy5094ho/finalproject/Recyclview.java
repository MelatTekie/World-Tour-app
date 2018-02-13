package edu.mnstate.wy5094ho.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Recyclview extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private List<String> listData = new ArrayList<>();
    private List<Integer>image = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclview);

        setupList();
        build();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
      RecycleAdpter adpter = new RecycleAdpter(image,listData,this);
        recyclerView.setAdapter(adpter);


    }

    private void build() {
        image.add(R.drawable.per);
        image.add(R.drawable.braz);
        image.add(R.drawable.so);
        image.add(R.drawable.melat1);
        image.add(R.drawable.in);
        image.add(R.drawable.chi);
        image.add(R.drawable.austri);
    }

    private void setupList() {
        listData.add("Visit Peru");
        listData.add("Visit Brazil");
        listData.add("Visit SouthAfrica");
        listData.add("Visit Egypt");
        listData.add("Visit India");
        listData.add("Visit China");
        listData.add("Visit Australia");


//        for(int i = 1 ; i<=10 ; i++)
//            listData.add("Click me "+ i);
    }

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
                Intent intent = new Intent(Recyclview.this,me.class);
                startActivity(intent);
            }
            return true;
            case R.id.per1:{

                Intent intent = new Intent(Recyclview.this,continent.class);
                startActivity(intent);

            }
            return true;
            case R.id.per2:{

                Intent intent = new Intent(Recyclview.this,Recyclview.class);
                startActivity(intent);

            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
