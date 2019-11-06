package com.myicecream.scs_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddGroupFormActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.groupName) EditText mGroupName;
    @BindView(R.id.members) EditText mMembers;
    @BindView(R.id.password) EditText mPasswordR;
    @BindView(R.id.confirmPassword) EditText mConfirmPassword;
    @BindView(R.id.add) Button mButtonAdd;
    @BindView(R.id.register) TextView mRegisterGroup;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group_form);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mButtonAdd.setOnClickListener(this);
        mRegisterGroup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == mRegisterGroup) {
            Intent add = new Intent(AddGroupFormActivity.this,)
        }
    }
}
