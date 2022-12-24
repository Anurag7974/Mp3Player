package com.example.musicmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button button3;
    private Button button4;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button3 =findViewById(R.id.button3);
        button4 =findViewById(R.id.button4);
        seekBar =findViewById(R.id.seekBar);
        //MediaPlay using local source.
       mediaPlayer = MediaPlayer.create(this, R.raw.songs);
       mediaPlayer.start();

       seekBar.setMax(mediaPlayer.getDuration());
       seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               if(fromUser){
                   mediaPlayer.seekTo(progress);
               }

           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });


       //  MediaPlay using Remote Source.
//        mediaPlayer = new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource ("http://fricking.ninja/DIY/index/GSM/Ringtones/Adagio.For.Strings.mp3");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//           @Override
//           public void onPrepared(MediaPlayer mp) {
//               Toast.makeText(MainActivity.this, "Ready To Start", Toast.LENGTH_SHORT).show();
//               mp.start();
//               seekBar.setMax(mediaPlayer.getDuration());
//               seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//                   @Override
//                   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                       if(fromUser){
//                           mediaPlayer.seekTo(progress);
//                       }
//
//                   }
//
//                   @Override
//                   public void onStartTrackingTouch(SeekBar seekBar) {
//
//                   }
//
//                   @Override
//                   public void onStopTrackingTouch(SeekBar seekBar) {
//
//                   }
//               });
//           }
//       });



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
    }
}