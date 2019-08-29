package com.example.myapplication7;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashActivity extends AppCompatActivity {

    private TextView textExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        textExample = findViewById(R.id.textExample);

        Bundle bundle = getIntent().getExtras();

        String example = bundle.getString("EXAMPLE");
        double value = bundle.getDouble("VALUE");

        String show = "Text: " + example + "\n and " + value;

        textExample.setText(show);

        Log.d("CYCLE", "onCreate execute(DashActivity)");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CYCLE", "onStart execute(DashActivity)");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CYCLE", "onResume execute(DashActivity)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CYCLE", "onPause execute(DashActivity)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CYCLE", "onStop execute(DashActivity)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CYCLE", "onDestroy execute(DashActivity)");
    }
}
