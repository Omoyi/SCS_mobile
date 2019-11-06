package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MembersActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView mFirstGroup;
    private CardView mSecondGroup;
    private CardView mThirdGroup;
    private CardView mFourthGroup;
    private ImageView mAddGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        mFirstGroup =(CardView)findViewById(R.id.firstGroup);
        mSecondGroup =(CardView)findViewById(R.id.secondGroup);
        mThirdGroup =(CardView)findViewById(R.id.thirdGroup);
        mFourthGroup =(CardView)findViewById(R.id.fourthGroup);
        mAddGroup=(ImageView)findViewById(R.id.addGroup);

        mFirstGroup.setOnClickListener(this);
        mSecondGroup.setOnClickListener(this);
        mThirdGroup.setOnClickListener(this);
        mFourthGroup.setOnClickListener(this);
        mAddGroup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ( v == mFirstGroup){
            Intent intent1= new Intent(MembersActivity.this, Group1Activity.class);
            startActivity(intent1);
        }
        if ( v == mSecondGroup){
            Intent intent2= new Intent(MembersActivity.this, Group2.class);
            startActivity(intent2);
        }

        if ( v == mThirdGroup){
            Intent intent3= new Intent(MembersActivity.this, Group3.class);
            startActivity(intent3);
        }

        if ( v == mFourthGroup){
            Intent intent4= new Intent(MembersActivity.this, Group4Activity.class);
            startActivity(intent4);
        }
        if (v == mAddGroup){
            Intent intent5= new Intent(MembersActivity.this,AddGroupFormActivity.class);
            startActivity(intent5);
        }
    }
}
