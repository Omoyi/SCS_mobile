package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Member1 extends AppCompatActivity {

    GridView gridView;
    private int [] picture = { R.drawable.image4,
            R.drawable.image8,
            R.drawable.image7,
            R.drawable.image3,
            R.drawable.iiiii,
            R.drawable.image5,
            R.drawable.image2,
            R.drawable.back,
            R.drawable.pic3,
            R.drawable.pic4
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member1);
    }
}
