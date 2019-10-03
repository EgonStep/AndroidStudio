package com.example.appwithroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    private EditText editName, editAmount;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        editName = findViewById(R.id.editName);
        editAmount = findViewById(R.id.editAmount);

        findViewById(R.id.saveBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveItem();
            }
        });
    }

    private void saveItem() {
        String name = editName.getText().toString().trim();
        String amount = editAmount.getText().toString().trim();

        if (name.isEmpty()) {
            editName.setError("Name Required!");
            editName.requestFocus();
            return;
        }
        if (amount.isEmpty()) {
            editAmount.setError("Amount Required!");
            editAmount.requestFocus();
            return;
        }

        database = AppDatabase.getInstance(getApplicationContext());
        Item item = new Item(name, Integer.parseInt(amount));

        long result = database.itemDAO().insert(item);

        if (result > 0) {
            Toast.makeText(this, "Item Saved", Toast.LENGTH_SHORT).show();
            exit();
        } else {
            Toast.makeText(this, "Error on saved", Toast.LENGTH_SHORT).show();
        }
    }

    private void exit() {
        Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
