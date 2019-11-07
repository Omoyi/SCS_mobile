package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
//    static int SPLASH_TIME_OUT = 3000;
    private ImageView image, leaf;
    private  LinearLayout animText, texth, menus;
    private  Animation frombottom;

// private LinearLayout leaflet,linear;
// private Button button;
// Animation meetbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        button = (Button)findViewById(R.id.button);
//        leaflet = (LinearLayout)findViewById(R.id.linear);
//        linear = (LinearLayout)findViewById(R.id.linear);
//        meetbtn = AnimationUtils.loadAnimation(this, R.anim.meetbtn);
//        leaflet.setAnimation(meetbtn);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },SPLASH_TIME_OUT );

        frombottom = AnimationUtils.loadAnimation(this, R.anim.anim1);


        image = (ImageView) findViewById(R.id.image);
        leaf = (ImageView) findViewById(R.id.leaf);
        animText = (LinearLayout) findViewById(R.id.animText);
        texth = (LinearLayout) findViewById(R.id.explore);
//        menus = (LinearLayout) findViewById(R.id.menus);

        image.animate().translationY(-1900).setDuration(2000).setStartDelay(600);
        leaf.animate().alpha(0).setDuration(2000).setStartDelay(900);
        animText.animate().translationY(140).alpha(0).setDuration(1000).setStartDelay(600);

        texth.startAnimation(frombottom);
//        menus.startAnimation(frombottom);
    }
}
