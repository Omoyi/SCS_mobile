package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class Member2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member2);


    }
    public void browse1(View view){
        Intent browse1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/kimbagira"));
        startActivity(browse1Intent);
    }

    public void browse2(View view){
        Intent browse2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ahiodette"));
        startActivity(browse2Intent);
    }

    public void browse3(View view){
        Intent browse3Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lyndaflower"));
        startActivity(browse3Intent);
    }

    public void browse4(View view){
        Intent browse4Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Eliane-5"));
        startActivity(browse4Intent);
    }
}
