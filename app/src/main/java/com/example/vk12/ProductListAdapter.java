package com.example.vk12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private Context context;
    private ArrayList<Product> products = new ArrayList<>();

    public ProductListAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.txtName.setText(products.get(position).getName());
        holder.imageEdit.setImageResource(android.R.drawable.ic_menu_edit);
        holder.imageRemove.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);

        holder.imageRemove.setOnClickListener(view -> {
            Storage.getInstance().getProducts().remove(holder.getAdapterPosition());
            notifyItemRemoved(holder.getAdapterPosition());
        });

        holder.imageEdit.setOnClickListener(view -> {

            if(holder.editName.getVisibility() == View.VISIBLE){
                Product product = Storage.getInstance().getProducts().get(holder.getAdapterPosition());
                product.setName(holder.editName.getText().toString());
                holder.editName.setVisibility(View.GONE);
                notifyDataSetChanged();
            } else {
                holder.editName.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
