package edu.mnstate.wy5094ho.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class visitperu extends AppCompatActivity {
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitperu);
        //Uri uri = Uri.parse("https://www.youtube.com/watch?v=Zk9J5xnTVMA");
        VideoView simpleVideoView = (VideoView) findViewById(R.id.myvideo); // initiate a video view
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.peruv));
        simpleVideoView.start();
       // create an object of media controller
        MediaController mediaController = new MediaController(this);
// initiate a video view
        VideoView myvideo = (VideoView) findViewById(R.id.myvideo);
// set media controller object for a video view
        simpleVideoView.setMediaController(mediaController);
        next = (Button)findViewById(R.id.button2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(visitperu.this,saverpage.class);
                startActivity(intent);
            }
        });
    }
}
