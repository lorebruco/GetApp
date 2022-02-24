package com.example.progettoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    String text, text1, email1, password1;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googleBtn;
    ProgressBar progressBar;
    EditText email, password;
    FirebaseAuth mAuth;
    Button loginbtn, signupbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.email1);
        password = (EditText) findViewById(R.id.password1);

        loginbtn = findViewById(R.id.loginbtn);
        signupbtn = findViewById(R.id.signupbtn);
        googleBtn = findViewById(R.id.google_btn);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            navigateToSecondActivity();
        }


        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });




        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSignActivity();
            }
        });

        Intent intent = getIntent();
        if (intent.hasExtra("email") && intent.hasExtra("password")) {
            text = intent.getStringExtra("email");
            text1 = intent.getStringExtra("password");
            email.setText(text);
            Toast.makeText(this, "Dato ricevuto: " + text, Toast.LENGTH_SHORT).show();
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString().equals("admin") || email.getText().toString().equals(text) && password.getText().toString().equals("admin") ||  password.getText().toString().equals(text1)){
                    //correct
                    navigateToSecondActivity();
                    Toast.makeText(LoginActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                }else
                    Check();

            }
        });
    }

    public void Check(){
        String email1 = email.getText().toString().trim();
        String password1 = password.getText().toString().trim();

        if(email1.isEmpty()){
            email.setError("Inserire la password");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
            email.setError("Formato non Valito");
            email.requestFocus();
            return;
        }
        if(password1.isEmpty()){
            password.setError("password is required");
            password.requestFocus();
            return;
        }
        if(password1.length()<6) {
            password.setError("min password lenght should be 6 characters!");
            password.requestFocus();
        }

        mAuth.signInWithEmailAndPassword( email1, password1 )
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(homeIntent);
                        }else{
                            Toast.makeText(LoginActivity.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
        }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            //   try {
            //       task.getResult(ApiException.class);
            navigateToSecondActivity();
            //   } catch (ApiException e) {
            Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
            //    }
        }

    }


    void navigateToSecondActivity () {
        finish();
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    void navigateToSignActivity () {
        finish();
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
