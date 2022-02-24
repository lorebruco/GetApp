package com.example.progettoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progettoapp.adapter.ProductAdapter;
import com.example.progettoapp.adapter.ProductCategoryAdapter;
import com.example.progettoapp.model.ProductCategory;
import com.example.progettoapp.model.Products;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdottiActivity extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;
    EditText nomeAccount;
    TextView tit, tit2;
    String nomet, ling, ts;
    ImageView imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodotti);

        tit = findViewById(R.id.textView5);
        tit2 = findViewById(R.id.textView6);
        imm = findViewById(R.id.imageView4);

        imm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        Intent intent = getIntent();
        if (intent.hasExtra("Lingua")) {
            ling = intent.getStringExtra("Lingua");
            ts =ling;

        if(ling.equals("it"))
        {
            tit.setText("ECCO QUA");
            tit2.setText("Trova le principali caratteristiche di un medicinale");
            FirebaseUser User = FirebaseAuth.getInstance().getCurrentUser();

            List<ProductCategory> productCategoryList = new ArrayList<>();
            productCategoryList.add(new ProductCategory(1, "Più Popolari"));
            productCategoryList.add(new ProductCategory(2, "Testa"));
            productCategoryList.add(new ProductCategory(3, "Dolori"));
            productCategoryList.add(new ProductCategory(4, "Gola"));
            productCategoryList.add(new ProductCategory(5, "Tutti"));
            setProductRecycler(productCategoryList);
        }

        if(ling.equals("ing"))
        {
            tit.setText("HERE IT IS");
            tit2.setText("Find the main characteristics of a medicine");
            FirebaseUser User = FirebaseAuth.getInstance().getCurrentUser();

            List<ProductCategory> productCategoryList = new ArrayList<>();
            productCategoryList.add(new ProductCategory(1, "Most Popular"));
            productCategoryList.add(new ProductCategory(2, "Head"));
            productCategoryList.add(new ProductCategory(3, "Pain"));
            productCategoryList.add(new ProductCategory(4, "Troat"));
            productCategoryList.add(new ProductCategory(5, "All"));
            setProductRecycler(productCategoryList);
        }

            List<Products> productsList = new ArrayList<>();
            productsList.add(new Products(1, "Tachipirina", "500 mg", "$ 5.50", R.drawable.tachipirina));
            productsList.add(new Products(2, "Buscopon", "10 mg", "$ 7.70", R.drawable.buscopon));
            productsList.add(new Products(3, "Moment", "200 g", "$ 8.93", R.drawable.moment));
            productsList.add(new Products(4, "Froben", "160 ml", "$ 5.37", R.drawable.froben));
            productsList.add(new Products(5, "Aspirina", "400 g", "$ 6.98", R.drawable.aspirina));
            productsList.add(new Products(5, "Borocillina", "15 ml", "$ 8.90", R.drawable.borocillina));
            productsList.add(new Products(5, "Benactiv", "15 ml", "$ 4.55", R.drawable.benactiv));
            productsList.add(new Products(5, "Okitask", "40 mg", "$ 7.69", R.drawable.okitask));
            productsList.add(new Products(5, "Nurofen", "200 mg", "$ 5.50", R.drawable.nuronfen));
            productsList.add(new Products(5, "Dicloreum", "100 g", "$ 5.62", R.drawable.dicloreum));
            productsList.add(new Products(5, "Biochetasi", "100 mg", "$ 6.21", R.drawable.biochetasi));

            setProdItemRecycler(productsList);


    }}

    private void setProductRecycler(List<ProductCategory> productCategoryList){

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);
    }

    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);
    }



}
