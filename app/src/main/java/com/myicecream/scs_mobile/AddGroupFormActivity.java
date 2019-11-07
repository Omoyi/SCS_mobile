package com.myicecream.scs_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class AddGroupFormActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mGroupName;
    private EditText mMembers;
    private EditText mPasswordR;
    private EditText mConfirmPassword;
    private Button mButtonAdd;
    private TextView mRegisterGroup;
    DatabaseReference team;
    List<AddGroupAdapter> teamMembers;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group_form);
        mGroupName = (EditText) findViewById(R.id.groupName);
        mMembers = (EditText) findViewById(R.id.members);
        mPasswordR = (EditText) findViewById(R.id.password);
        mConfirmPassword = (EditText) findViewById(R.id.confirmPassword);
        mButtonAdd = (Button) findViewById(R.id.add);
        mRegisterGroup = (TextView) findViewById(R.id.register);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        team = FirebaseDatabase.getInstance().getReference();
        mButtonAdd.setOnClickListener(this);
        mRegisterGroup.setOnClickListener(this);
        teamMembers = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {
        if (v == mRegisterGroup) {
            Intent add = new Intent(AddGroupFormActivity.this, RegisterMembersActivity.class);
            startActivity(add);
        }
        if (v == mButtonAdd) {
            Intent intent = new Intent(AddGroupFormActivity.this, MembersActivity.class);
            startActivity(intent);
        }
    }

    protected void onStart() {
        super.onStart();
        team.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    AddGroupAdapter wish = snap.getValue(AddGroupAdapter.class);
                    teamMembers.add(wish);
                }
//            addGroup adapter = new addGroup(AddGroupFormActivity.this, teamMembers);
//            mRecyclerView.setAdapter(adapter);
//
//
//            addGroup adapter = new addGroup(AddGroupFormActivity.this, teamMembers);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}
