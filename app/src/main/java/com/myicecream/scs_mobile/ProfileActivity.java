package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);
    }

    public void browser1(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is my subject text");
        this.startActivity(Intent.createChooser(emailIntent, null));
    }

    public void browser2(View view){
        String PhoneNum = "+250 787971925";
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+Uri.encode(PhoneNum.trim())));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }

    public void browser4(View view){
        Intent browser4Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Omoyi"));
        startActivity(browser4Intent);
    }


    public void browser2E(View view){
        String PhoneNum = "+250 785454250";
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+Uri.encode(PhoneNum.trim())));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }

    public void browser4E(View view){
        Intent browser4Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Nyirate"));
        startActivity(browser4Intent);
    }
}
