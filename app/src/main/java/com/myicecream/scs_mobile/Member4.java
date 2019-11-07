package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class Member4 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_member4);

    }
    public void browsi1(View view){
        Intent browsi1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Mugengano18"));
        startActivity(browsi1Intent);
    }

    public void browsi2(View view){
        Intent browsi2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/RuzindanaWendyOrnella"));
        startActivity(browsi2Intent);
    }

    public void browsi3(View view){
        Intent browsi3Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/niygomhonor"));
        startActivity(browsi3Intent);
    }

    public void browsi4(View view){
        Intent browsi4Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/esthcarelle"));
        startActivity(browsi4Intent);
    }
}
