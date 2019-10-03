package com.example.appwithroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView purchaseList;
    private List<Item> items;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        purchaseList = findViewById(R.id.purchaseList);
        findViewById(R.id.NewItemBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewItem();
            }
        });

        loadData();
    }

    private void loadData() {
        database = AppDatabase.getInstance(getApplicationContext());
        items = database.itemDAO().getAll();
        addNewItemOnList();
    }

    private void addNewItemOnList() {
        ItemAdapter adapter = new ItemAdapter(getApplicationContext(),
                R.layout.item_purchase, items);
        purchaseList.setAdapter(adapter);
    }

    private void createNewItem() {
        Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
        startActivity(intent);
    }
}
