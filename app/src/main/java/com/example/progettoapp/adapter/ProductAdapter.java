package com.example.progettoapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progettoapp.ProdottiActivity;
import com.example.progettoapp.Productdetails;
import com.example.progettoapp.R;
import com.example.progettoapp.model.Products;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Products> productsList;
    String l;


    public ProductAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.products_row_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {

        holder.prodImage.setImageResource(productsList.get(position).getImageUrl());
        holder.prodName.setText(productsList.get(position).getProductName());
        holder.prodQty.setText(productsList.get(position).getProductQty());
        holder.prodPrice.setText(productsList.get(position).getProductPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Productdetails.class);

                if(i.hasExtra("Lingua"))
                {
                   l = i.getStringExtra("Lingua");
                   i.putExtra("Lingua", l);
                   context.startActivity(i);
                 }

                if(holder.prodName.getText().equals("Tachipirina"))
                {
                    i.putExtra("Tachipirina", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Aspirina"))
                {
                    i.putExtra("Aspirina", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Moment"))
                {
                    i.putExtra("Moment", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Froben"))
                {
                    i.putExtra("Froben", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Buscopon"))
                {
                    i.putExtra("Buscopon", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Borocillina"))
                {
                    i.putExtra("Borocillina", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Benactiv"))
                {
                    i.putExtra("Benactiv", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Okitask"))
                {
                    i.putExtra("Okitask", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Nurofen"))
                {
                    i.putExtra("Nurofen", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Dicloreum"))
                { ;
                    i.putExtra("Dicloreum", holder.prodName.getText().toString());
                }
                if(holder.prodName.getText().equals("Biochetasi"))
                {
                    i.putExtra("Biochetasi", holder.prodName.getText().toString());
                }
                context.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView prodImage;
        TextView prodName, prodQty, prodPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage = itemView.findViewById(R.id.prod_image);
            prodName = itemView.findViewById(R.id.prod_name);
            prodPrice = itemView.findViewById(R.id.prod_price);
            prodQty = itemView.findViewById(R.id.prod_qty);


        }
    }

}
