package com.example.vk12;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    ImageView imageRemove, imageEdit;
    TextView txtName, editName;



    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        imageRemove = itemView.findViewById(R.id.imageDelete);
        imageEdit = itemView.findViewById(R.id.imageEdit);
        txtName = itemView.findViewById(R.id.txtName);
        editName = itemView.findViewById(R.id.editTextProduct);
    }
}
