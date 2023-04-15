package com.example.vk12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Storage storage;
    TextView NameInput, txtSortByName;
    ImageView imageSortByTime;
    CheckBox cbImportant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = Storage.getInstance();


        recyclerView = findViewById(R.id.rvProducts);
        txtSortByName = findViewById(R.id.txtSortByName);
        imageSortByTime = findViewById(R.id.imageSortByTime);
        cbImportant = findViewById(R.id.cbImportant);

        NameInput = findViewById(R.id.editTextAddProduct);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductListAdapter(getApplicationContext(), storage.getProducts()));
    }


    public void addProduct(View view) {
        Boolean important = false;
        if (cbImportant.isChecked()){
            important = true;
        }
        storage.getProducts().add(new Product(NameInput.getText().toString(), important));
        int position = storage.getProducts().size() - 1;
        recyclerView.getAdapter().notifyItemInserted(position);
        recyclerView.scrollToPosition(position);
    }

    public void sortByName(View view) {
        Collections.sort(Storage.getInstance().getProducts());
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void sortByTime(View view){
        Storage.getInstance().getProducts().sort(Comparator.comparing(Product::getOrder));
        recyclerView.getAdapter().notifyDataSetChanged();
    }


}