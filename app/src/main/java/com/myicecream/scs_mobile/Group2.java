package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Group2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group2);
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
        Intent browse3Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/nice-nicole"));
        startActivity(browse3Intent);
    }

    public void browse4(View view){
        Intent browse4Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/BlandineK"));
        startActivity(browse4Intent);
    }
}