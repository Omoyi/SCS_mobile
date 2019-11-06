package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

public class Member1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member1);


    }
    public void browser(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Imaraika"));
        startActivity(browserIntent);
    }

    public void browser1(View view){
        Intent browser1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Sangwa-C"));
        startActivity(browser1Intent);
    }

    public void browser3(View view){
        Intent browser2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lyndaflower"));
        startActivity(browser2Intent);
    }

    public void browser2(View view){
        Intent browser3Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Eliane-5"));
        startActivity(browser3Intent);
    }
}
