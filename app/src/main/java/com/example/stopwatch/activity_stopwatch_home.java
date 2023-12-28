package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class activity_stopwatch_home extends AppCompatActivity {
    private Chronometer stopwatch;
    private boolean timerRunning;
    private long pausedTime;
   Button btnstart, btnpause, btnreset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch_home);


        btnstart = findViewById(R.id.btnStart);
        btnpause = findViewById(R.id.btnPause);
        btnreset = findViewById(R.id.btnReset);
        stopwatch = findViewById(R.id.timer);


        btnpause.setAlpha(0);
        btnreset.setAlpha(0);



        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!timerRunning) {
                    stopwatch.setBase(SystemClock.elapsedRealtime() - pausedTime);
                    stopwatch.start();
                    timerRunning = true;
                    btnstart.animate().alpha(0);
                    btnpause.animate().alpha(1).setDuration(300).start();
                    btnreset.animate().alpha(1).setDuration(300).start();
                }
            }
        });

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerRunning) {
                    stopwatch.stop();
                    pausedTime = SystemClock.elapsedRealtime() - stopwatch.getBase();
                    timerRunning = false;
                    btnstart.animate().alpha(1).setDuration(300).start();
                }
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopwatch.setBase(SystemClock.elapsedRealtime());
                stopwatch.stop();
                pausedTime = 0;
                timerRunning = false;

                btnstart.animate().alpha(1).setDuration(300).start();
                btnpause.animate().alpha(0);
                btnreset.animate().alpha(0);
            }
        });
    }
}