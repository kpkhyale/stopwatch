package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   Button btn;
    Animation animImage, animText, animButton;
  ImageView mainImage;
  TextView mainTxt, subTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.btnGo);
        mainImage = findViewById(R.id.mainImg);
        mainTxt = findViewById(R.id.mainText);
        subTxt = findViewById(R.id.subText);

        animImage = AnimationUtils.loadAnimation(this, R.anim.alg);
        animText = AnimationUtils.loadAnimation(this, R.anim.btgone);
        animButton = AnimationUtils.loadAnimation(this, R.anim.btgtwo);


        mainImage.startAnimation(animImage);
        mainTxt.startAnimation(animText);
        subTxt.startAnimation(animText);
        btn.startAnimation(animButton);



        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_stopwatch_home.class);
                startActivity(intent);
            }
        });
    }
}