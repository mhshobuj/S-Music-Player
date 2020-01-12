package com.example.smusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button playBT, pauseBT, stopBT;
    private MediaPlayer mediaPlayer;
    private int pauseCurrentPossition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBT = findViewById(R.id.playButton);
        pauseBT = findViewById(R.id.pauseButton);
        stopBT = findViewById(R.id.stopButton);

        playBT.setOnClickListener(this);
        pauseBT.setOnClickListener(this);
        stopBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.playButton:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                    mediaPlayer.start();
                }
                else if (!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPossition);
                    mediaPlayer.start();
                }
                break;

            case R.id.pauseButton:
                if (mediaPlayer !=null) {
                    mediaPlayer.pause();
                    pauseCurrentPossition = mediaPlayer.getCurrentPosition();
                }
                break;

            case R.id.stopButton:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;
        }

    }
}
