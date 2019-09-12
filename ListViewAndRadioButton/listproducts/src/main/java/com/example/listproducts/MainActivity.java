package com.example.listproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> products;
    private ListView productListView;
    private EditText editProduct, editAmount;
    private Spinner spinner;
    private CheckBox checkPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productListView = findViewById(R.id.listProducts);
        editProduct = findViewById(R.id.editProduct);
        editAmount = findViewById(R.id.editAmount);
        spinner = findViewById(R.id.spinner);
        checkPriority = findViewById(R.id.checkPriority);
    }

    @Override
    protected void onStart() {
        super.onStart();
        products = new ArrayList<>();
        ArrayAdapter adapter = new ProductAdapter(getApplicationContext(),
                R.layout.list_products, products);
        productListView.setAdapter(adapter);
    }

    public void chooseProduct(View view) {
        String name = editProduct.getText().toString();
        String type = spinner.getSelectedItem().toString();
        double amount = Double.parseDouble(editAmount.getText().toString());

        Product product = new Product(name, type, amount, checkPriority.isChecked());
        products.add(product);
    }
}
