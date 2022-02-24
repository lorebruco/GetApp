package com.example.progettoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

     FirebaseAuth mAuth;
     ProgressBar progressBar;
     EditText username, email, password, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth =FirebaseAuth.getInstance();
        MaterialButton regbtn = (MaterialButton) findViewById(R.id.signupbtn);
        regbtn.setOnClickListener(this);

         username = (EditText) findViewById(R.id.username);
         email = (EditText) findViewById(R.id.email);
         password = (EditText) findViewById(R.id.password);
         repassword= (EditText) findViewById(R.id.repassword);

         progressBar = (ProgressBar) findViewById(R.id.progressBar);

        }

    @Override
    public void onClick(View view) {
        Check();
    }

    public void Check(){
        String username1 = username.getText().toString().trim();
        String email1 = email.getText().toString().trim();
        String password1 = password.getText().toString().trim();
        String repassword1 = repassword.getText().toString().trim();

        if(username1.isEmpty()){
            username.setError("Full name is required");
            username.requestFocus();
            return;
        }
        if(password1.isEmpty()){
            password.setError("password is required");
            password.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
            email.setError("please provide valid email");
            email.requestFocus();
            return;
        }
        if(password1.length()<6) {
            password.setError("min password lenght should be 6 characters!");
            password.requestFocus();
        }
        if(repassword1.isEmpty() || !repassword1.equals(password1)){
            repassword.setError("Password isn't equal");
            repassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword( email1, password1 )
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(username1, email1, password1);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        progressBar.setVisibility(View.VISIBLE);
                                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                        intent.putExtra("email", email.getText().toString());
                                        intent.putExtra("password", password.getText().toString());
                                        intent.putExtra("username", username.getText().toString());
                                        finish();
                                        startActivity(intent);
                                        Toast.makeText(SignUpActivity.this, "User has been Registered successfully!", Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(SignUpActivity.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                  }
                            });

                        }else{
                            Toast.makeText(SignUpActivity.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
    
}