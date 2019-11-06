package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GroupActivity extends AppCompatActivity {

    private ImageView mFirstGroup;
    private ImageView mSecondGroup;
    private ImageView mThirdGroup;
    private ImageView mFourthGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        mFirstGroup =(ImageView)findViewById(R.id.firstGroup);
        mSecondGroup =(ImageView)findViewById(R.id.secondGroup);
        mThirdGroup =(ImageView)findViewById(R.id.thirdGroup);
        mFourthGroup =(ImageView)findViewById(R.id.fourthGroup);

        mFourthGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent group1 = new Intent(GroupActivity.this,)
            }
        });
    }
}
