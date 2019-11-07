package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView image, leaf;
    private  LinearLayout animText, texth, menus;
    private  Animation frombottom;
    @BindView(R.id.button) Button button;

// private LinearLayout leaflet,linear;
// private Button button;
// Animation meetbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        button.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        if(v == button){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        }
    }
}
