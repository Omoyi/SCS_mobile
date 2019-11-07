package com.myicecream.scs_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    private EditText mDescription;
    private Button mButtonAdd;
    private TextView mRegisterGroup;
    private ImageButton mUp;

    DatabaseReference team;
    List<AddGroupAdapter> teamMembers;
    private GridView mGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group_form);

        mGroupName = (EditText) findViewById(R.id.groupName);
        mMembers = (EditText) findViewById(R.id.members);
        mDescription = (EditText) findViewById(R.id.description);
        mButtonAdd = (Button) findViewById(R.id.add);
        mRegisterGroup = (TextView) findViewById(R.id.register);
        mGrid = (GridView) findViewById(R.id.myGrid);
        mUp=(ImageButton) findViewById(R.id.up) ;

        team = FirebaseDatabase.getInstance().getReference();
        mButtonAdd.setOnClickListener(this);
        mRegisterGroup.setOnClickListener(this);
        mUp.setOnClickListener(this);
        teamMembers = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {
        if (v == mRegisterGroup) {
            Intent add = new Intent(AddGroupFormActivity.this, RegisterMembersActivity.class);
            startActivity(add);
        }
//        if (v == mButtonAdd) {
//            Intent intent = new Intent(AddGroupFormActivity.this, MembersActivity.class);
//            startActivity(intent);
//        }
        if (v == mButtonAdd){
            addMembers();
        }
        if (v == mUp) {
            Intent intent7 = new Intent(AddGroupFormActivity.this, MembersActivity.class);
            startActivity(intent7);
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
            addGroup adapter = new addGroup(AddGroupFormActivity.this, teamMembers);
            mGrid.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

    private void addMembers() {
        String name = mGroupName.getText().toString().trim();
        String members = mMembers.getText().toString();
        String description =mDescription.getText().toString();


        if (!TextUtils.isEmpty(name)){
            String id = team.push().getKey();

            AddGroupAdapter wish = new
                    AddGroupAdapter(id, name, members,description);
            team.child(id).setValue(wish);
            Toast.makeText(this, "Saved ", Toast.LENGTH_LONG).show();

        }
    }

}
