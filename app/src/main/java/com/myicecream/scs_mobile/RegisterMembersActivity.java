package com.myicecream.scs_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterMembersActivity extends AppCompatActivity implements View.OnClickListener {
   @BindView(R.id.choose) ImageButton mUpload;
    private ImageView profile;
    private Button imgUr;
    @BindView(R.id.name) EditText mName;
    public static final String TAG = RegisterMembersActivity.class.getSimpleName();

    //    TextView mLoginTextView;
//    @BindView(R.id.upload) Button upload;
//    @BindView(R.id.up) Button mUp;
//    @BindView(R.id.name) EditText mName;
//    @BindView(R.id.descr) EditText mDescr;
    @BindView(R.id.addMember) Button mRegister;
    @BindView(R.id.retour) ImageButton mReturn;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mAuthProgressDialog;

    Uri imgUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    MemberData user = new MemberData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_members);
        ButterKnife.bind(this);

        mRegister.setOnClickListener(this);
        mUpload.setOnClickListener(this);
        mReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mRegister) {
            mName.getText().toString().length();
            mName.setError("Member name is required");

            Intent intent = new Intent(RegisterMembersActivity.this,MembersActivity.class);
            startActivity(intent);
        }
        if (v == mUpload){
            ImageChooser();
        }
        if (v == mReturn){
            Intent retour = new Intent(RegisterMembersActivity.this,AddGroupFormActivity.class);
        }
    }

    private void ImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }
}