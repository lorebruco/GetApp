package com.example.progettoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name,email;
    Button signOutBtn, promemoriabtn;
    Button medbtn;
    ImageView flags, esci;
    Spinner spinner;
    String lingua;
    TextView testo1 , testo2, testo3, testo4, testo01, testo02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        esci = findViewById(R.id.indietro);
        spinner = findViewById(R.id.spinner);
        flags = findViewById(R.id.flag);

        email = findViewById(R.id.username);
        signOutBtn = findViewById(R.id.signout);
        medbtn = findViewById(R.id.infobtn);
        promemoriabtn = findViewById(R.id.dispensabtn);

        testo01 = findViewById(R.id.textView2);
        testo02 = findViewById(R.id.textView3);
        testo1 = findViewById(R.id.indicazioni);
        testo2 = findViewById(R.id.fase1);
        testo3 = findViewById(R.id.fase2);
        testo4 = findViewById(R.id.fase3);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            name.setText(personName);
            email.setText(personEmail);
        }

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                flags.setImageResource(CountryData.countryFlag[spinner.getSelectedItemPosition()]);
                lingua();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        esci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Statistics.class));
            }
        });

        medbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lingua();

                Intent intent = new Intent(HomeActivity.this, ProdottiActivity.class);
                intent.putExtra("Lingua", lingua);
                startActivity(intent);
            }
        });

        promemoriabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ReminderActivity.class));
            }
        });

    }

   void lingua()
  {
        if(spinner.getSelectedItemPosition() == 0)
        {
            lingua = "ing";
            medbtn.setText("Medicine");
            promemoriabtn.setText("Promemory");
            testo01.setText("You don't know what to do?");
            testo02.setText("Visit the medicines section, add products or update on the Covid-19 pandemic");
            testo1.setText("Prevention");
            testo2.setText("Avold close \n contact");
            testo3.setText("clean your\n hand often");
            testo4.setText("wear a \n face mask");


        }

        if(spinner.getSelectedItemPosition() == 1)
        {
            lingua = "it";
            medbtn.setText("Medicine");
            promemoriabtn.setText("Armadio");
            testo1.setText("Prevenzioni");
            testo01.setText("Non sai cosa fare?");
            testo02.setText("Visita la sezione dei medicinali, aggiungi prodotti nella dispensa o aggiornati sulla pandemia Covid-19");
            testo2.setText("Mantieni la \ndistanza");
            testo3.setText("lavati spesso \nle mani");
            testo4.setText("indossa la\nmascherina");
        }
  }

    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });
    }
}