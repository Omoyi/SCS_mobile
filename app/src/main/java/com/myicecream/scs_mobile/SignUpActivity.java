package com.myicecream.scs_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{



        public static final String TAG = SignUpActivity.class.getSimpleName();
        @BindView(R.id.createUserButton)
        Button mCreateUserButton;
        @BindView(R.id.nameEditText)
        EditText mNameEditText;
        @BindView(R.id.emailEditText) EditText mEmailEditText;
        @BindView(R.id.passwordEditText) EditText mPasswordEditText;
        @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
        @BindView(R.id.loginTextView) TextView mLoginTextView;
        @BindView(R.id.profile) ImageView profile;
         @BindView(R.id.choose) Button choose;
        @BindView(R.id.upload) Button upload;

        private FirebaseAuth mAuth;
        private FirebaseAuth.AuthStateListener mAuthListener;
        private ProgressDialog mAuthProgressDialog;
        private String mName;

        Uri imgUri;
        StorageReference storageReference;
        DatabaseReference databaseReference;
        User user = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
            ButterKnife.bind(this);
            mLoginTextView.setOnClickListener(this);
            mCreateUserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String username= mNameEditText.getText().toString().trim();
                    user.setMemberName(username);
                    databaseReference.push().setValue(user);
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            });

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageChooser();
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageUploader();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");
        storageReference = FirebaseStorage.getInstance().getReference("Images");
            mAuth = FirebaseAuth.getInstance();
            createAuthStateListener();
            createAuthProgressDialog();
        }

    private void ImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }
    private String getExtension(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
    private void ImageUploader() {
        StorageReference reference = storageReference.child(System.currentTimeMillis()+"."+getExtension(imgUri));
        reference.putFile(imgUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        // Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText(SignUpActivity.this,"Profile set successfully", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK && data != null && data.getData() != null){
            imgUri = data.getData();
            profile.setImageURI(imgUri);
        }
    }

    public void createAuthProgressDialog(){
            mAuthProgressDialog = new ProgressDialog(this);
            mAuthProgressDialog.setTitle("Loading...");
            mAuthProgressDialog.setMessage("Authenticating with Firebase...");
            mAuthProgressDialog.setCancelable(true);
        }
        @Override
        public void onClick(View view){
            if(view == mLoginTextView){
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            } if (view == mCreateUserButton){
                createNewUser();
            }
        }
        public void createNewUser(){
            final String name = mNameEditText.getText().toString().trim();
            final String email = mEmailEditText.getText().toString().trim();
            String password = mPasswordEditText.getText().toString().trim();
            String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();
            mName = mNameEditText.getText().toString().trim();
            boolean validEmail = isValidEmail(email);
            boolean validName = isValidName(name);
            boolean validPassword = isValidPassword(password, confirmPassword);
            if (!validEmail || !validName || !validPassword) return;
            mAuthProgressDialog.show();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    mAuthProgressDialog.dismiss();
                    if (task.isSuccessful()){
                        Log.d(TAG, "Authentication successful");
                        createFirebaseUserProfile(task.getResult().getUser());
                    }else {
                        Toast.makeText(SignUpActivity.this,"Authentication failed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        private void createAuthStateListener(){
            mAuthListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    final FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user != null){
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                }
            };
        }
        @Override
        public void onStart(){
            super.onStart();
            mAuth.addAuthStateListener(mAuthListener);
        }
        @Override
        public void onStop(){
            super.onStop();
            if(mAuthListener != null){
                mAuth.removeAuthStateListener(mAuthListener);
            }
        }
        private boolean isValidEmail(String email) {
            boolean isGoodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
            if(!isGoodEmail){
                mEmailEditText.setError("Please enter a valid email address");
                return false;
            }
            return isGoodEmail;
        }
        private boolean isValidName(String name){
            if(name.equals("")){
                mNameEditText.setError("Please enter your name");
                return false;
            }
            return true;
        }
        private boolean isValidPassword(String password, String confirmPassword){
            if(password.length() < 6){
                mPasswordEditText.setError("Please create a password containing at least 6 characters");
                return false;
            } else if (!password.equals(confirmPassword)){
                mPasswordEditText.setError("Passwords do not match");
                return false;
            }
            return true;
        }
        private void createFirebaseUserProfile(final FirebaseUser user){
            UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder()
                    .setDisplayName(mName)
                    .build();
            user.updateProfile(addProfileName)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Log.d(TAG, user.getDisplayName());
                                Toast.makeText(SignUpActivity.this, "The display name has ben set", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
