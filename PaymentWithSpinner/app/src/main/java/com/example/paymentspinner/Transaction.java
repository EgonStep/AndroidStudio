package com.example.paymentspinner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("DefaultLocale")
public class Transaction extends AppCompatActivity {

    private TextView textOriginal, textValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        textOriginal = findViewById(R.id.textOriginal);
        textValue = findViewById(R.id.textValue);

        Bundle bundle = getIntent().getExtras();

        setValues(bundle);
    }

    private void setValues(Bundle bundle) {
        String paymentMethod = bundle.getString("PAYMENT");
        double originalAmount = bundle.getDouble("AMOUNT");
        textOriginal.setText(String.format("Original Amount: %.2f", originalAmount));

        if (paymentMethod.equalsIgnoreCase("Credit"))
            textValue.setText(String.format("Credit: 3x - %.2f \n 6x - %.2f",
                    originalAmount/3, originalAmount/6));
        else if (paymentMethod.equalsIgnoreCase("Debit"))
            textValue.setText(String.format("Debit: %.2f",
                    originalAmount * 0.9));
        else if (paymentMethod.equalsIgnoreCase("Billet"))
            textValue.setText(String.format("Billet: %.2f",
                    originalAmount + 2.5));
    }
}
