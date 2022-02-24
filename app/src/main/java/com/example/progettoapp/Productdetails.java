package com.example.progettoapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Productdetails extends AppCompatActivity {

    TextView nomeProdotto, descrizione, cat1, cat2, cat3;
    String text, lin, test;
    EditText titolo;
    ImageView back, prodotto, sitoinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);

        back = findViewById(R.id.indietro);
        nomeProdotto = (TextView) findViewById(R.id.titolo);
        descrizione = (TextView) findViewById(R.id.textView13);
        prodotto = findViewById(R.id.imageViewProdotto);
        cat1 =findViewById(R.id.textView7);
        cat2 =findViewById(R.id.textView10);
        sitoinfo = findViewById(R.id.sitoMed);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Productdetails.this, ProdottiActivity.class);
                startActivity(backIntent);
                finish();
            }
        });

        Intent intent = getIntent();
                if (intent.hasExtra("Tachipirina"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.tachipirina.it/prodotti/compresse/"));
                            startActivity(viewIntent);
                        }
                    });

                        prodotto.setImageResource(R.drawable.tachipirinap);
                        text = intent.getStringExtra("Tachipirina");
                        nomeProdotto.setText("TACHIPIRINA");
                        descrizione.setText("Per gli adulti La dose raccomandata è di 1 compressa da ripetere se necessario dopo 4 ore, senza superare le 6 somministrazioni al giorno. Nel caso di forti dolori o febbre alta, 2 compresse da 500 mg da ripetere se necessario dopo non meno di 4 ore.Per i bambini  è indispensabile rispettare la dose definita in funzione del loro peso corporeo");
                        cat1.setText("Testa");
                        cat2.setText("Dolori");
                }

                if (intent.hasExtra("Moment"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.imalditesta.com/i-nostri-prodotti/mal-di-testa/moment/"));
                            startActivity(viewIntent);
                        }
                    });

                    prodotto.setImageResource(R.drawable.momentp);
                    text = intent.getStringExtra("Moment");
                    nomeProdotto.setText("MOMENT");
                    descrizione.setText("Può essere assunto anche a stomaco vuoto a partire dai 12 anni di età. Una compressa contiene  normalemente 400 mg");
                    cat1.setText("Testa");
                    cat2.setVisibility(View.INVISIBLE);
                }

                if (intent.hasExtra("Aspirina"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.aspirina.it/prodotti/aspirina-act-dolore-infiammazione/"));
                            startActivity(viewIntent);
                        }
                    });

                    prodotto.setImageResource(R.drawable.aspirinap);
                    text = intent.getStringExtra("Aspirina");
                    nomeProdotto.setText("ASPIRINA");
                    descrizione.setText("Deve essere assunta con un’adeguata quantità di liquidi. 1 compressa, ripetendo la dose se necessario dopo che saranno trascorse almeno 4-6 ore. Per un dosaggio giornaliero massimo di 3 compresse. Può iniziare ad agire contro il dolore dopo cinque minuti.");
                    cat1.setText("Testa");
                    cat2.setText("Dolori");

                }

                if (intent.hasExtra("Froben"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.lineafroben.it/it-it/prodotti/froben-gola-spray"));
                            startActivity(viewIntent);
                        }
                    });

                    prodotto.setImageResource( R.drawable.frobenp);
                    text = intent.getStringExtra("Froben");
                    nomeProdotto.setText("FROBEN");
                    descrizione.setText("2 spruzzi per 3 volte al giorno, indirizzati direttamente sulla parte interessata. Non usi FROBEN per periodi prolungati e non superi le dosi consigliate. Si rivolga al medico se non si sente meglio o si sente peggio dopo un breve periodo di trattamento l’utilizzo di FROBEN  nella popolazione pediatrica non è raccomandato.");
                    cat1.setText("Gola");
                    cat2.setVisibility(View.INVISIBLE);

                }

                if (intent.hasExtra("Buscopon"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.buscopan.it/prodotti-buscopan-compresse"));
                            startActivity(viewIntent);
                        }
                    });

                    prodotto.setImageResource( R.drawable.buscoponp);
                    text = intent.getStringExtra("Buscopon");
                    nomeProdotto.setText("BUSCOPAN");
                    descrizione.setText("Buscopan®️ compresse può essere assunto a partire dai 6 anni di età. I seguenti dosaggi sono consigliati per adulti e ragazzi di età superiore ai 14 anni: 1-2 compresse rivestite 3 volte al giorno. Nei bambini di età compresa tra i 6 ed i 14 anni: seguire la prescrizione del medico. Le compresse devono essere assunte intere con un’adeguata quantità d’acqua.");
                    cat1.setText("Stomaco");
                    cat2.setVisibility(View.INVISIBLE);

                }

                if (intent.hasExtra("Borocillina"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.neoborocillina.it/wp-content/uploads/2020/02/NB_Gola_Dolore_Pastiglie_foglietto_illustrativo.pdf"));
                            startActivity(viewIntent);
                        }
                    });

                    prodotto.setImageResource( R.drawable.borocillinnap);
                    text = intent.getStringExtra("Borocillina");
                    nomeProdotto.setText("BOROCILLINA");
                    descrizione.setText("La dose raccomandata per adulti e ragazzi oltre i 12 anni di età è: una pastiglia, da sciogliere lentamente in bocca, ogni 3 - 6 ore, a seconda delle necessità, fino ad un massimo giornaliero di 8 pastiglie. Non superare le dosi indicate.");
                    cat1.setText("Gola");
                    cat2.setVisibility(View.INVISIBLE);
                }

                if (intent.hasExtra("Benactiv"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.benagol.it/prodotti/mal-di-gola-forte/?gclid=EAIaIQobChMI4__eh6uW9gIVyu5RCh2AFAz_EAAYASAAEgLSEfD_BwE&gclsrc=aw.ds"));
                            startActivity(viewIntent);
                        }
                    });


                    prodotto.setImageResource( R.drawable.benactivep);
                    text = intent.getStringExtra("Benactiv");
                    nomeProdotto.setText("BENACTIVE");
                    descrizione.setText("Si raccomanda l'utilizzo di 1 dose (3 spruzzi) di Benactivdol Gola Spray ogni 3-6 ore, a seconda della necessità, indirizzando l'erogatore spray in direzione della parte della gola interessata dal dolore e dall'infiammazione. Non assumere più di 5 dosi in un periodo di 24 ore.");
                    cat1.setText("Gola");
                    cat2.setVisibility(View.INVISIBLE);

                }
                if (intent.hasExtra("Okitask"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://okitask.it/okitask-granulato/"));
                            startActivity(viewIntent);
                        }
                    });

                    prodotto.setImageResource( R.drawable.okitaskp);
                    text = intent.getStringExtra("Okitask");
                    nomeProdotto.setText("OKITASK");
                    descrizione.setText("questo è solo un text per capire se esce qualcosa di interessante");
                    cat1.setText("Testa");
                    cat2.setText("Dolori");

                }

                if (intent.hasExtra("Nurofen"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.nurofen.it/prodotti/adulti/nurofen-influenza-e-raffreddore-compresse-rivestite/"));
                            startActivity(viewIntent);
                        }
                    });

                    prodotto.setImageResource( R.drawable.nurofenp);
                    text = intent.getStringExtra("Nurofen");
                    nomeProdotto.setText("NUROFEN");
                    descrizione.setText("Prodotto indicato per adulti e adolescenti dai 12 anni di età: 1-2 compresse ogni 4 ore, secondo necessità (dose massima: 6 compresse nell'arco delle 24 ore).");
                    cat1.setText("Dolori");
                    cat2.setVisibility(View.INVISIBLE);
                }
                if (intent.hasExtra("Dicloreum"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.dicloreum-prodottidiautomedicazione.it/prodotti/schiuma-antinfiammatoria-antidolorifica/"));
                            startActivity(viewIntent);
                        }
                    });


                    prodotto.setImageResource( R.drawable.dicloreump);
                    text = intent.getStringExtra("Dicloreum");
                    nomeProdotto.setText("DICLOREUM");
                    descrizione.setText("Adulti: applicare il medicinale da 1 a 3 volte al giorno per brevi periodi di trattamento. Agitare la bomboletta prima dell’uso. Tenendola capovolta, erogare una quantità di schiuma di 3-5 centimetri di diametro sul palmo della mano ed applicare con un breve massaggio sulla zona da trattare. Non utilizzare nei bambini e negli adolescenti al di sotto dei 14 anni di età.");
                    cat1.setText("Dolori");
                    cat2.setVisibility(View.INVISIBLE);

                }

                if (intent.hasExtra("Biochetasi"))
                {
                    sitoinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.biochetasi.it/wp-content/uploads/2020/06/Biochetasi-GranulatoEffervescente_Fogliietto-illustrativo.pdf"));
                            startActivity(viewIntent);
                        }
                    });

                    prodotto.setImageResource( R.drawable.biochetasip);
                    text = intent.getStringExtra("Biochetasi");
                    nomeProdotto.setText("BIOCHETASI");
                    descrizione.setText("Non superi le dosi raccomandate e usi Biochetasi solo per brevi periodi di trattamento. Adulti e bambini di età superiore ai 12 anni:2 compresse ettervescenti o 2 bustine di granulato effervescente, 3 volte al giorno. Uso nei bambini al di sotto di 12 anni");
                    cat1.setText("Stomaco");
                    cat2.setVisibility(View.INVISIBLE);

                }
    }
}