package com.example.paymentspinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editAmount;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAmount = findViewById(R.id.editAmount);
        spinner = findViewById(R.id.spinner);
    }

    public void transferAmount(View view) {
        Intent intent = new Intent(MainActivity.this, Transaction.class);
        Bundle bundle = new Bundle();

        double sendAmount = Double.parseDouble(editAmount.getText().toString());
        String sendPayment = spinner.getSelectedItem().toString();

        bundle.putString("PAYMENT", sendPayment);
        bundle.putDouble("AMOUNT", sendAmount);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}
